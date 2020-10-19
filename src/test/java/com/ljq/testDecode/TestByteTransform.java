package com.ljq.testDecode;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.MessageDecode;
import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ljq.framework.utils.ByteTransform;

public class TestByteTransform {
    private static final Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Test
    public void TestDecodeJtt() {
        byte[] buf = {-1, -1, -1, -1, -1, -1, -1, -1};

		byte retByte = ByteTransform.byte2Byte(buf, 0);
        log.info("0x{} byte2Byte = {}", Integer.toHexString(buf[0] & 0xFF), retByte);

		short retByte1 = ByteTransform.byte2UnsignedByte(buf, 0);
        log.info("0x{} byte2UnsignedByte = {}", Integer.toHexString(buf[0] & 0xFF), retByte1);
		
        short ret = ByteTransform.byte2Short(buf, 0);
        log.info("0x{}, 0x{} byte2Short = {}", Integer.toHexString(buf[0] & 0xFF), Integer.toHexString(buf[1] & 0xFF), ret);

		int ret1 = ByteTransform.byte2UnsignedShort(buf, 0);
        log.info("0x{}, 0x{} byte2UnsignedShort = {}", Integer.toHexString(buf[0] & 0xFF), Integer.toHexString(buf[1] & 0xFF), ret1);

		int retint = ByteTransform.byte2int(buf, 0);
        log.info("0x{}, 0x{}, 0x{}, 0x{} byte2Int = {}", Integer.toHexString(buf[0] & 0xFF), Integer.toHexString(buf[1] & 0xFF), 
			Integer.toHexString(buf[2] & 0xFF), Integer.toHexString(buf[3] & 0xFF), retint);

		long retlong = ByteTransform.byte2Unsignedint(buf, 0);
        log.info("0x{}, 0x{}, 0x{}, 0x{} byte2UnsignedInt = {}", Integer.toHexString(buf[0] & 0xFF), Integer.toHexString(buf[1] & 0xFF), 
			Integer.toHexString(buf[2] & 0xFF), Integer.toHexString(buf[3] & 0xFF), retlong);

		long byte2Longret = ByteTransform.byte2Long(buf, 0);
        log.info("0x{}, 0x{}, 0x{}, 0x{}, 0x{}, 0x{}, 0x{}, 0x{} byte2Long = {}", Integer.toHexString(buf[0] & 0xFF), Integer.toHexString(buf[1] & 0xFF), 
			Integer.toHexString(buf[2] & 0xFF), Integer.toHexString(buf[3] & 0xFF),
			Integer.toHexString(buf[4] & 0xFF), Integer.toHexString(buf[5] & 0xFF),
			Integer.toHexString(buf[6] & 0xFF), Integer.toHexString(buf[7] & 0xFF), byte2Longret);

		//log.info("=============================================");
		//log.info("0x{} UnsignedByte2byteBuf = {}", Integer.toHexString(0xff), ByteTransform.UnsignedByte2byteBuf((short)0xff));
		//log.info("0x{} Byte2byteBuf = {}", Integer.toHexString(0xff), ByteTransform.Byte2byteBuf((byte)0xff));
		//log.info("0x{} UnsignedShort2byteBuf = {}", Integer.toHexString(0xaeea), ByteTransform.UnsignedShort2byteBuf(0xaeea));
    }
}
