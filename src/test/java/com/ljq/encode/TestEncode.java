package com.ljq.encode;//package com.ssh.framework.test;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.codec.MessageDecode;
import com.ljq.framework.codec.MessageEncode;
import com.ljq.framework.codec.MessageHeader;
import com.ljq.protocol.basic.CenterHeartBeat;
import com.ljq.protocol.basic.TerminalAuth;
import com.ljq.protocol.basic.TerminalDeviceInfo;
import org.junit.Test;

import java.util.Arrays;

public class TestEncode {
    @Test
    public void TestDecodeJtt() {
        MessageEncode encoder = new MessageEncode();
        encoder.initial("com.ljq.protocol.basic");
        TerminalAuth instruct = new TerminalAuth();

        byte[] Serial = {1, 2, 8, 1, 2, 8, 1, 2, 8};
        MessageHeader header = instruct.getHeader();
        header.setSerialNo(15);
        header.setTerminalNum(Serial);
        instruct.setBcdTerminalSerial(Serial);
        instruct.setManufacturerId("facturerIdfacturerIdfacturerIdfacturerId");
        System.out.println(instruct);

        byte[] res = encoder.encode(instruct);
        System.out.println("res = " + Arrays.toString(res));

        MessageDecode decoder = new MessageDecode("com.ljq.protocol.basic");
        AbstractInstruction decode = decoder.decode(res);
        System.out.println("decode = " + decode);
        TerminalAuth decodeTer = (TerminalAuth) decode;

        System.out.println("===================");
        CenterHeartBeat instructs = new CenterHeartBeat();
        header = instructs.getHeader();
        header.setSerialNo(16);
        header.setTerminalNum(Serial);
        System.out.println(instructs);
        res = encoder.encode(instructs);
        System.out.println("res = " + Arrays.toString(res));
        decode = decoder.decode(res);
        System.out.println("decode = " + decode);

        System.out.println("===================");
        TerminalDeviceInfo instructTerminalDeviceInfo = new TerminalDeviceInfo();
        header = instructTerminalDeviceInfo.getHeader();
        header.setSerialNo(17);
        header.setTerminalNum(Serial);
        instructTerminalDeviceInfo.setCarLicense("1234567890");
        instructTerminalDeviceInfo.setDeviceType("lrl");
        instructTerminalDeviceInfo.setAppVersion("v1.91");
        instructTerminalDeviceInfo.setMcuVersion("v1.3");
        instructTerminalDeviceInfo.setAiVersion("v1.4");
        System.out.println(instructTerminalDeviceInfo);
        res = encoder.encode(instructTerminalDeviceInfo);
        System.out.println("res = " + Arrays.toString(res));
        decode = decoder.decode(res);
        System.out.println("decode = " + decode);
    }
}
