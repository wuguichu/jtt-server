package com.ljq.framework.codec;

import com.ljq.framework.fields.AbstractField;
import com.ljq.framework.utils.BCDTransform;
import com.ljq.framework.utils.ByteTransform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MessageDecode {

    public void initial(String packagePath) {
        instructInfo = InstructionBeanHelper.getBeanInfo(packagePath);
    }

    public AbstractInstruction decode(byte[] buf) {
        try {
            MessageHeader header = decodeHeader(buf);
            if (null == header) {
                log.warn("找不到合法头部");
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

            TreeMap<Integer, FieldBeanInfo> fieldInfo = instructionBeanInfo.getFieldInfo();
            for (Map.Entry<Integer, FieldBeanInfo> next : fieldInfo.entrySet()) {
                FieldBeanInfo value = next.getValue();

                Method writeMethod = value.getWriteMethod();
                AbstractField<?> field = value.getField();
                int len = field.byte2type(buf, index);
                if (len < 0) {
                    log.warn("解码字段出现错误");
                    continue;
                }
                index += len;
                if (writeMethod != null)
                    writeMethod.invoke(instructionBean, field.getType());
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
        byte[] terminalNum = subByte(buf, 24, 6);
        header.setTerminalNum(BCDTransform.toString(terminalNum));

        System.out.println(header);

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
