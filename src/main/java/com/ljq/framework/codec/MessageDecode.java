package com.ljq.framework.codec;

import com.ljq.framework.fields.AbstractField;
import io.netty.buffer.ByteBuf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.nio.charset.Charset;
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

            if (buf.readableBytes() < header.getPackageLen() + 32 + 4) {
                log.warn("length too small {} {}", buf.readableBytes(), header.getPackageLen());
                return null;
            }
            buf.skipBytes(32);

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
                Object obj = field.getValue(buf);
                if (obj == null) {
                    log.error("解码字段出现错误");
                    return null;
                }
                if (writeMethod != null)
                    writeMethod.invoke(instructionBean, obj);
            }

            if (buf.readableBytes() < 4) {
                log.error("tail length error  {}", buf.readableBytes());
                return null;
            }
            String signTail = buf.toString(buf.readerIndex(), 4, Charset.forName("gbk"));
            if (!"RPTP".equals(signTail)) {
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
        header.setSerialNo(buf.getUnsignedShort(buf.readerIndex() + 4));
        // reserves 2byte
        header.setPackageLen(buf.getUnsignedInt(buf.readerIndex() + 8));
        header.setTotalPack(buf.getUnsignedInt(buf.readerIndex() + 12));
        header.setCurrentPack(buf.getUnsignedInt(buf.readerIndex() + 16));
        header.setInstruction(buf.getUnsignedInt(buf.readerIndex() + 20));
        buf.getBytes(buf.readerIndex() + 24, terminalNum);
        header.setTerminalNum(terminalNum);
        // reserves 2byte

        log.debug(header);

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
            if ("RPTP".equals(buf.toString(buf.readerIndex(), 4, Charset.forName("gbk"))))
                return true;
            buf.skipBytes(1);
        }
    }

    private final HashMap<Integer, InstructionBeanInfo<AbstractInstruction>> instructInfo;
    private static final Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
}
