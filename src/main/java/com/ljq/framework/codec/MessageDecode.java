package com.ljq.framework.codec;

import com.ljq.framework.utils.*;

public class MessageDecode {
    public void decode(byte[] buf) {
        MessageHeader header = decodeHeader(buf);
        if (null == header) {
            return;
        }
        long instruction = header.getInstruction();
    }

    private static MessageHeader decodeHeader(byte[] buf) {
        if (buf.length < 32) {
            System.out.println("buf.length error:" + buf.length);
            return null;
        }

        byte[] sign = subByte(buf, 0, 4);
        String signHeader = new String(sign);
        if (!"RPTP".equals(signHeader)) {
            System.out.println("signHeader error:" + signHeader);
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
}
