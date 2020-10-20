package com.ljq.framework.codec;

import com.ljq.framework.fields.AbstractField;
import com.ljq.framework.utils.ByteTransform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.*;

public class MessageEncode {

    public void initial(String packagePath) {
        clazzMap = new HashMap<>();
        instructInfo = InstructionBeanHelper.getBeanInfo(packagePath, clazzMap);
    }

    public byte[] encode(AbstractInstruction instruct) {
        Integer instruction = clazzMap.get(instruct.getClass().getName());
        MessageHeader header = instruct.getHeader();
        if (instruction == null) {
            log.error("找不到对应的指令");
            return null;
        }
        header.setInstruction(instruction);
        InstructionBeanInfo<AbstractInstruction> instructionBeanInfo = instructInfo.get(instruction);
        if (instructionBeanInfo == null) {
            log.error("找不到指令id {} 对应的协议bean", instruction);
            return null;
        }
        try {
            int len = 0;
            List<byte[]> bufList = new LinkedList<>();

            TreeMap<Integer, FieldBeanInfo> fieldInfo = instructionBeanInfo.getFieldInfo();
            for (Map.Entry<Integer, FieldBeanInfo> next : fieldInfo.entrySet()) {
                FieldBeanInfo value = next.getValue();

                Method readMethod = value.getReadMethod();
                AbstractField<?> field = value.getField();
                if (readMethod == null) {
                    log.error("协议bean没有readMethod");
                    return null;
                }
                byte[] indexBuf = field.getByteArray(readMethod.invoke(instruct));
                if (indexBuf == null) {
                    log.error("编码字段出现错误");
                    return null;
                }
                len += field.getLength();
                bufList.add(indexBuf);
                if (len > 1024) {
                    log.error("编码超出长度，请分包");
                    return null;
                }
            }

            header.setPackageLen(len);
            byte[] headerBuf = encodeHeader(header);
            byte[] buf = new byte[headerBuf.length + len + 4];
            System.arraycopy(headerBuf, 0, buf, 0, headerBuf.length);
            int offset = headerBuf.length;
            for (byte[] indexBuf : bufList) {
                System.arraycopy(indexBuf, 0, buf, offset, indexBuf.length);
                offset += indexBuf.length;
            }
            System.arraycopy("RPTP".getBytes(), 0, buf, offset, 4);
            return buf;
        } catch (Exception e) {
            log.error("编码出现错误");
            e.printStackTrace();
        }

        return null;
    }

    private static byte[] encodeHeader(MessageHeader header) {
        byte[] buf = new byte[32];

        System.arraycopy("RPTP".getBytes(), 0, buf, 0, 4);
        System.arraycopy(ByteTransform.unsignedShort2byteArray(header.getSerialNo()), 0, buf, 4, 2);
        // reserve 2
        System.arraycopy(ByteTransform.unsignedInt2byteArray(header.getPackageLen()), 0, buf, 8, 4);
        System.arraycopy(ByteTransform.unsignedInt2byteArray(header.getTotalPack()), 0, buf, 12, 4);
        System.arraycopy(ByteTransform.unsignedInt2byteArray(header.getCurrentPack()), 0, buf, 16, 4);
        System.arraycopy(ByteTransform.unsignedInt2byteArray(header.getInstruction()), 0, buf, 20, 4);
        if (header.getTerminalNum() != null) {
            if (header.getTerminalNum().length > 6)
                System.arraycopy(header.getTerminalNum(), 0, buf, 24, 6);
            else
                System.arraycopy(header.getTerminalNum(), 0, buf, 30 - header.getTerminalNum().length, header.getTerminalNum().length);
        }
        // reserve 2

        return buf;
    }

    private HashMap<Integer, InstructionBeanInfo<AbstractInstruction>> instructInfo;
    private HashMap<String, Integer> clazzMap;
    private static final Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
}
