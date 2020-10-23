package com.ljq.framework.fields;

import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

public class FixedStringField extends AbstractField<String> {
    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < length) {
            return null;
        }
        String value = buf.toString(buf.readerIndex(), length, Charset.forName("gbk"));
        buf.skipBytes(length);
        return value;
    }

    @Override
    public byte[] getByteArray(Object type) {
        if (!(type instanceof String)) {
            return null;
        }

        String value = (String) type;
        byte[] buffer = value.getBytes();
        byte[] buf = new byte[length];
        if (buffer.length > length)
            System.arraycopy(buffer, 0, buf, 0, length);
        else
            System.arraycopy(buffer, 0, buf, length - buffer.length, buffer.length);
        return buf;
    }

    private int length;
}
