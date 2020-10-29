package com.ljq.framework.codec;

import com.ljq.framework.fields.AbstractField;
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

            if (buf.readableBytes() < header.getPackageLen() + 20 + 4) {
                log.warn("length too small {} {}", buf.readableBytes(), header.getPackageLen());
                return null;
            }
            buf.skipBytes(32);

            long instruction = header.getInstruction();
            InstructionBeanInfo instructionBeanInfo = instructInfo.get((int) instruction);
            if (instructionBeanInfo == null) {
                log.warn("找不到指令id 0x{} 对应的协议bean", Long.toHexString(instruction));
                return null;
            }

            AbstractInstruction instructionBean = (AbstractInstruction) getInstructionBean(instructionBeanInfo, buf);
            if (instructionBean == null) {
                return null;
            }
            instructionBean.setHeader(header);

            if (buf.readableBytes() < 4) {
                log.error("tail length error  {}", buf.readableBytes());
                return null;
            }
            String signTail = buf.toString(buf.readerIndex(), 4, CommonDefine.codecCharset);
            if (!"RTTP".equals(signTail)) {
                log.error("signTail error {}", signTail);
                return null;
            }
            buf.skipBytes(4);

            return instructionBean;
        } catch (Exception e) {
            log.error("解码出现错误");
            e.printStackTrace();
        }

        return null;
    }

    private static Object getInstructionBean(InstructionBeanInfo beanInfo, ByteBuf buf) {
        try {
            Object instance = beanInfo.getClazz().getDeclaredConstructor().newInstance();
            TreeMap<Integer, FieldBeanInfo> fieldInfo = beanInfo.getFieldInfo();

            for (Map.Entry<Integer, FieldBeanInfo> next : fieldInfo.entrySet()) {
                FieldBeanInfo value = next.getValue();
                Method writeMethod = value.getWriteMethod();
                AbstractField<?> field = value.getField();
                InstructionBeanInfo subTypeBeanInfo = value.getSubTypeBeanInfo();
                Object setObj = null;

                if (field != null)
                    setObj = field.getValue(buf);
                else if (subTypeBeanInfo != null)
                    setObj = getInstructionBean(subTypeBeanInfo, buf);
                if (setObj == null) {
                    log.error("解码字段出现错误 {}" , writeMethod);
                    return null;
                }
                if (writeMethod != null)
                    writeMethod.invoke(instance, setObj);
            }

            return instance;
        } catch (Exception e) {
            log.error("解码出现错误");
            e.printStackTrace();
        }

        return null;
    }

    private static MessageHeader decodeHeader(ByteBuf buf) {
        /*找到RPTP*/
        if (!findHeader(buf)) {
            log.debug("can't find header");
            return null;
        }
        if (buf.readableBytes() < 32) {
            log.warn("length too small {}", buf.readableBytes());
            return null;
        }
        MessageHeader header = new MessageHeader();
        byte[] terminalNum = new byte[6];
        header.setSerialNo(buf.getUnsignedShortLE(buf.readerIndex() + 4));
        // reserves 2byte
        header.setPackageLen(buf.getUnsignedIntLE(buf.readerIndex() + 8));
        header.setTotalPack(buf.getUnsignedIntLE(buf.readerIndex() + 12));
        header.setCurrentPack(buf.getUnsignedIntLE(buf.readerIndex() + 16));
        header.setInstruction(buf.getUnsignedIntLE(buf.readerIndex() + 20));
        buf.getBytes(buf.readerIndex() + 24, terminalNum);
        header.setTerminalNum(terminalNum);
        // reserves 2byte

        return header;
    }

    private static boolean findHeader(ByteBuf buf) {
        int index;
        while (true) {
            if ((index = buf.bytesBefore((byte) 'R')) < 0) {
                buf.clear();
                return false;
            }
            buf.skipBytes(index);
            if (buf.readableBytes() < 4)
                return false;
            if ("RPTP".equals(buf.toString(buf.readerIndex(), 4, CommonDefine.codecCharset)))
                return true;
            buf.skipBytes(1);
        }
    }

    private final HashMap<Integer, InstructionBeanInfo> instructInfo;
    private static final Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
}
