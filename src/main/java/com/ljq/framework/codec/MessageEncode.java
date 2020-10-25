package com.ljq.framework.codec;

import com.ljq.framework.fields.AbstractField;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MessageEncode {
    public MessageEncode(String packagePath) {
        clazzMap = new HashMap<>();
        instructInfo = InstructionBeanHelper.getBeanInfo(packagePath, clazzMap);
    }

    public ByteBuf encode(AbstractInstruction instruct) {
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
            ByteBuf buf = Unpooled.buffer(64, 1024);
            encodeHeader(header, buf);

            TreeMap<Integer, FieldBeanInfo> fieldInfo = instructionBeanInfo.getFieldInfo();
            for (Map.Entry<Integer, FieldBeanInfo> next : fieldInfo.entrySet()) {
                FieldBeanInfo value = next.getValue();

                Method readMethod = value.getReadMethod();
                AbstractField<?> field = value.getField();
                if (readMethod == null) {
                    log.error("协议bean没有readMethod");
                    return null;
                }
                field.getByteArray(readMethod.invoke(instruct), buf);
            }

            buf.setIntLE(buf.readerIndex() + 8, buf.readableBytes() - 20); // 设置header的包长字段
            buf.writeBytes("RTTP".getBytes(CommonDefine.codecCharset));
            return buf;
        } catch (Exception e) {
            log.error("编码出现错误");
            e.printStackTrace();
        }

        return null;
    }

    private static void encodeHeader(MessageHeader header, ByteBuf buf) {
        buf.writeBytes("RPTP".getBytes(CommonDefine.codecCharset));
        buf.writeShortLE(header.getSerialNo());
        buf.writeZero(2);   // reserve 2
        buf.writeIntLE((int) header.getPackageLen());
        buf.writeIntLE((int) header.getTotalPack());
        buf.writeIntLE((int) header.getCurrentPack());
        buf.writeIntLE((int) header.getInstruction());
        if (header.getTerminalNum() != null) {
            if (header.getTerminalNum().length > 6)
                buf.writeBytes(header.getTerminalNum(), 0, 6);
            else {
                buf.writeBytes(header.getTerminalNum());
                buf.writeZero(6 - header.getTerminalNum().length);
            }
        } else
            buf.writeZero(6);
        buf.writeZero(2);   // reserve 2
    }

    private final HashMap<Integer, InstructionBeanInfo<AbstractInstruction>> instructInfo;
    private final HashMap<String, Integer> clazzMap;
    private static final Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
}
