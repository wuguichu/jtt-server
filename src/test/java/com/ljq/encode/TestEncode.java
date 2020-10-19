package com.ljq.encode;//package com.ssh.framework.test;

import com.ljq.framework.codec.MessageDecode;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.MessageEncode;
import org.junit.Test;
import java.util.*;

import com.ljq.protocol.basic.TerminalAuth;
import com.ljq.framework.codec.MessageHeader;

public class TestEncode {
    @Test
    public void TestDecodeJtt() {
        //System.out.println("argv is null");
		/*if(args.length <= 0){
			System.out.println("argv is null");
			return;
		}
		byte[] res = {'R', 'P', 'T', 'P', 67, 125, 0, 0, 0, 1, 0, 0, 0, 0, 0, 10, 0, 0, 0, 3,
                0, 0, 0, 1, 20, 1, 9, 2, 8, 5, 0, 0, 9, 2, 8, 5, 0, 0, 0, 0, 'c', 's', 'i', 'd', 'c', 's', 'i', 'd'
                , 'c', 's', 'i', 'd', 'c', 's', 'i', 'd', 'c', 's', 'i', 'd', 'c', 's', 'i', 'd', 'c', 's', 'i', 'd', 'c', 's', 'i', 'd'};
		System.out.println("test decode:" + args[0]);
		logger.debug("test decode:" + args[0]);
		logger.warn("test decode:" + args[0]);
		logger.info("test decode:" + args[0]);
		logger.error("test decode:" + args[0]);*/
        MessageEncode encoder = new MessageEncode();
        encoder.initial("com.ljq.protocol.basic");
        TerminalAuth instruct = new TerminalAuth();

		byte[] facturerId = {'c', 's', 'i', 'd', 'c', 's', 'i', 'd', 'c', 's', 'i', 'd', 'c', 's', 'i', 'd', 'c', 
			's', 'i', 'd', 'c', 's', 'i', 'd', 'c', 's', 'i', 'd', 'c', 's', 'i', 'd'};
		byte[] Serial = {1,2,3,4,5,6};
		MessageHeader header = instruct.getHeader();
		// header.setCurrentPack(1);
		// header.setTotalPack(3);
		header.setSerialNo(15);
		header.setTerminalNum("123456789012");
		header.setInstruction(0x0101);
		instruct.setBcdTerminalSerial(Serial);
		instruct.setManufacturerId("facturerIdfacturerIdID");
        System.out.println(instruct);

		byte[] res = encoder.encode(instruct);
		System.out.println("res = " + Arrays.toString(res));


		MessageDecode decoder = new MessageDecode();
		decoder.initial("com.ljq.protocol.basic");
        AbstractInstruction decode = decoder.decode(res);
        System.out.println("decode = " + decode);
    }
}
