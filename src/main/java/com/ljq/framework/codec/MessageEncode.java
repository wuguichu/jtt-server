package com.ljq.framework.codec;

import com.ljq.framework.fields.AbstractField;
import com.ljq.framework.utils.BCDTransform;
import com.ljq.framework.utils.ByteTransform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MessageEncode {

    public void initial(String packagePath) {
		clazzMap = new HashMap<String, Integer>();
        instructInfo = InstructionBeanHelper.getBeanInfo(packagePath, clazzMap);
    }

    public byte[] encode(AbstractInstruction instruct) {
    	// Integer instruction = clazzMap.get(instruct.class);
    	MessageHeader header = instruct.getHeader();
		if (instruction == 0) {
            log.error("找不到头部");
            return null;
        }
		// header.setInstruction(instruction);
		InstructionBeanInfo<AbstractInstruction> instructionBeanInfo = instructInfo.get(instruction);
        if (instructionBeanInfo == null) {
            log.error("找不到指令id {} 对应的协议bean", instruction);
            return null;
        }
		/*
		if (!(instruct instanceof instructionBeanInfo.getClazz())){
            log.error("找不到指令id {} 对应的协议", instruction);
            return null;
        }
        */
        try {
			int len = 0;
			List<byte[]> bufList = new LinkedList<>();
		
            TreeMap<Integer, FieldBeanInfo> fieldInfo = instructionBeanInfo.getFieldInfo();
            for (Map.Entry<Integer, FieldBeanInfo> next : fieldInfo.entrySet()) {
                FieldBeanInfo value = next.getValue();

                Method readMethod = value.getReadMethod();
                AbstractField<?> field = value.getField();
				if (readMethod == null){
                    log.error("readMethod解码字段出现错误");
                    return null;
                }
				field.setType(readMethod.invoke(instruct));
                byte[] indexBuf = field.type2byte();
                if (indexBuf == null) {
                    log.error("indexBuf解码字段出现错误");
                    return null;
                }
				len += indexBuf.length;
				bufList.add(indexBuf);
				if (len > 1024) {
                    log.error("indexBuf {}", indexBuf);
                    return null;
                }
				log.debug("len: {}, indexBuf.length: {}", len, indexBuf.length);
            }

			header.setPackageLen(len);
			byte[] headerBuf = encodeHeader(header);
			byte[] buf = new byte[headerBuf.length+len];
			System.arraycopy(headerBuf, 0, buf, 0, headerBuf.length);
			int offset = headerBuf.length;
			for(byte[] indexBuf : bufList){
				System.arraycopy(indexBuf, 0, buf, offset, indexBuf.length);
				offset += indexBuf.length;
			}
			return buf;
        } catch (Exception e) {
            log.error("解码出现错误");
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
		System.arraycopy(header.getTerminalNum().getBytes(), 0, buf, 24, 6);
		// reserve 2
		
        return buf;
    }

    private static byte[] subByte(byte[] src, int begin, int count) {
        byte[] bs = new byte[count];
        System.arraycopy(src, begin, bs, 0, count);
        return bs;
    }

    private HashMap<Integer, InstructionBeanInfo<AbstractInstruction>> instructInfo;
	private HashMap<String, Integer> clazzMap;
    private static final Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
}
