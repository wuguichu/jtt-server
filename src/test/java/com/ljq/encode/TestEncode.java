package com.ljq.encode;//package com.ssh.framework.test;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.MessageDecode;
import com.ljq.framework.codec.MessageEncode;
import com.ljq.framework.codec.MessageHeader;
import com.ljq.framework.utils.BCDTransform;
import com.ljq.protocol.basic.TerminalAuth;
import org.junit.Test;

import java.util.Arrays;

public class TestEncode {
    @Test
    public void TestDecodeJtt() {
        MessageEncode encoder = new MessageEncode();
        encoder.initial("com.ljq.protocol.basic");
        TerminalAuth instruct = new TerminalAuth();

        byte[] Serial = {1, 2, 3, 4, 5, 6};
        MessageHeader header = instruct.getHeader();
        header.setSerialNo(15);
        header.setTerminalNum("123456789012");
        instruct.setBcdTerminalSerial(Serial);
        instruct.setManufacturerId("facturerIdfacturerIdID");
        System.out.println(instruct);

        byte[] res = encoder.encode(instruct);
        System.out.println("res = " + Arrays.toString(res));

        MessageDecode decoder = new MessageDecode();
        decoder.initial("com.ljq.protocol.basic");
        AbstractInstruction decode = decoder.decode(res);
        System.out.println("decode = " + decode);
        TerminalAuth decodeTer = (TerminalAuth) decode;
        System.out.println(decode.getHeader().getTerminalNum());
        System.out.println(BCDTransform.toString(decodeTer.getBcdTerminalSerial()));
    }
}
