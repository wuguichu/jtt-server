package com.ljq.framework.codec;

import com.ljq.framework.fields.AbstractField;
import com.ljq.framework.utils.ByteTransform;
import io.netty.buffer.ByteBuf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MessageDecode {

    public MessageDecode(String packagePath) {
        instructInfo = InstructionBeanHelper.getBeanInfo(packagePath);
    }

    public AbstractInstruction decode(ByteBuf buf) {
        try {
            MessageHeader header = decodeHeader(buf);
            if (null == header) {
                log.warn("找不到合法头部");
                return null;
            }

            if (buf.length < header.getPackageLen() + 32 + 4) {
                log.warn("length too small {} {}", buf.length, header.getPackageLen());
                return null;
            }

            int index = 32;
            long instruction = header.getInstruction();
            InstructionBeanInfo<AbstractInstruction> instructionBeanInfo = instructInfo.get((int) instruction);
            if (instructionBeanInfo == null) {
                log.warn("找不到指令id {} 对应的协议bean", instruction);
                return null;
            }

            AbstractInstruction instructionBean = instructionBeanInfo.getClazz().getDeclaredConstructor().newInstance();
            instructionBean.setHeader(header);

            int[] length = new int[1];
            TreeMap<Integer, FieldBeanInfo> fieldInfo = instructionBeanInfo.getFieldInfo();
            for (Map.Entry<Integer, FieldBeanInfo> next : fieldInfo.entrySet()) {
                FieldBeanInfo value = next.getValue();

                Method writeMethod = value.getWriteMethod();
                AbstractField<?> field = value.getField();
                Object obj = field.getValue(buf, index, length);
                if (obj == null) {
                    log.error("解码字段出现错误");
                    return null;
                }
                index += length[0];
                if (writeMethod != null)
                    writeMethod.invoke(instructionBean, obj);
            }

            if (index != header.getPackageLen() + 32) {
                log.error("length error {} {}", index, header.getPackageLen());
                return null;
            }
            byte[] sign = subByte(buf, index, 4);
            String signTail = new String(sign);
            if (!"RPTP".equals(signTail)) {
                log.error("signTail error {}", signTail);
                return null;
            }

            return instructionBean;
        } catch (Exception e) {
            log.error("解码出现错误");
            e.printStackTrace();
        }

        return null;
    }

    private static MessageHeader decodeHeader(byte[] buf) {
        if (buf.length < 32) {
            log.debug("buf.length error:{}", buf.length);
            return null;
        }

        byte[] sign = subByte(buf, 0, 4);
        String signHeader = new String(sign);
        if (!"RPTP".equals(signHeader)) {
            log.warn("signHeader error:{}", signHeader);
            return null;
        }
        MessageHeader header = new MessageHeader();
        header.setSerialNo(ByteTransform.byte2UnsignedShort(buf, 4));
        header.setPackageLen(ByteTransform.byte2Unsignedint(buf, 8));
        header.setTotalPack(ByteTransform.byte2Unsignedint(buf, 12));
        header.setCurrentPack(ByteTransform.byte2Unsignedint(buf, 16));
        header.setInstruction(ByteTransform.byte2Unsignedint(buf, 20));
        header.setTerminalNum(subByte(buf, 24, 6));

        log.debug(header);

        return header;
    }

    private static byte[] subByte(byte[] src, int begin, int count) {
        byte[] bs = new byte[count];
        System.arraycopy(src, begin, bs, 0, count);
        return bs;
    }

    private HashMap<Integer, InstructionBeanInfo<AbstractInstruction>> instructInfo;
    private static final Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
}
