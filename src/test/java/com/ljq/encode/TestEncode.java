package com.ljq.encode;

import com.ljq.framework.codec.*;
import com.ljq.framework.fields.AbstractField;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.*;

public class TestEncode {
    @Test
    public void TestDecodeJtt() {
        MessageEncode encoder = new MessageEncode("com.ljq.protocol.basic");
        MessageDecode decoder = new MessageDecode("com.ljq.protocol.basic");

        getDefaultInstruction();

        for (AbstractInstruction instruction : list) {
            ByteBuf buf = encoder.encode(instruction);
            AbstractInstruction decodeInstruction = decoder.decode(Unpooled.copiedBuffer(buf));

            log.info("======================== 指令 0x{} ========================", Long.toHexString(instruction.getHeader().getInstruction()));
            log.info("编码前 bean ：{}", instruction);
            log.info("编码后十六进制 ：{}", ByteBufUtil.hexDump(buf));
            log.info("解码后 bean ：{} \n", decodeInstruction);
        }
    }

    private void getDefaultInstruction() {
        HashMap<Integer, InstructionBeanInfo> beanInfo = InstructionBeanHelper.getBeanInfo("com.ljq.protocol.basic");

        for (Map.Entry<Integer, InstructionBeanInfo> entry : beanInfo.entrySet()) {

            Integer instructionValue = entry.getKey();
            InstructionBeanInfo info = entry.getValue();
            try {
                Object defaultInstructionBean = getDefaultInstructionBean(info);
                if (!(defaultInstructionBean instanceof AbstractInstruction)) {
                    log.error("设置bean失败，指令是: 0x{}", Long.toHexString(instructionValue));
                    continue;
                }

                AbstractInstruction instruction = (AbstractInstruction) defaultInstructionBean;
                initHeader(instruction);
                list.add(instruction);
            } catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private Object getDefaultInstructionBean(InstructionBeanInfo info) throws Exception {
        Object instance = info.getClazz().getDeclaredConstructor().newInstance();
        TreeMap<Integer, FieldBeanInfo> fieldInfo = info.getFieldInfo();

        for (Map.Entry<Integer, FieldBeanInfo> next : fieldInfo.entrySet()) {
            FieldBeanInfo value = next.getValue();
            Method writeMethod = value.getWriteMethod();
            AbstractField<?> field = value.getField();
            InstructionBeanInfo subTypeBeanInfo = value.getSubTypeBeanInfo();

            Object obj = null;
            if (subTypeBeanInfo != null)
                obj = getDefaultInstructionBean(subTypeBeanInfo);
            else {
                int count = 0;
                while (count++ < 100) {
                    if (count < 50)
                        obj = field.getValue(getRandomByteBuf());
                    else
                        obj = field.getValue(getInt32StringRandomByteBuf());
                    if (obj == null) {
                        continue;
                    }
                    break;
                }
            }
            if (obj == null) {
                log.error("随机设置值失败, writeMethod: {}", writeMethod);
                return null;
            }
            if (writeMethod != null)
                writeMethod.invoke(instance, obj);
        }

        return instance;
    }

    private ByteBuf getRandomByteBuf() {
        ByteBuf buffer = Unpooled.buffer(128, 256);
        Random random = new Random(LocalDateTime.now().getSecond());

        while (buffer.maxWritableBytes() >= 4) {
            buffer.writeIntLE(random.nextInt());
        }
        return buffer;
    }

    private ByteBuf getInt32StringRandomByteBuf() {
        ByteBuf buffer = Unpooled.buffer(128, 256);
        Random random = new Random(LocalDateTime.now().getSecond());

        buffer.writeIntLE(random.nextInt(32));
        while (buffer.maxWritableBytes() >= 4) {
            buffer.writeIntLE(random.nextInt());
        }
        return buffer;
    }

    private void initHeader(AbstractInstruction instruction) {
        byte[] terminalNum = {1, 2, 8, 1, 2, 8};

        instruction.getHeader().setSerialNo(serialNo++);
        instruction.getHeader().setTerminalNum(terminalNum);
    }

    private final List<AbstractInstruction> list = new LinkedList<>();
    private int serialNo = 0;
    private static final Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
}
