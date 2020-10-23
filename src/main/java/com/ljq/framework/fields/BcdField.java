package com.ljq.framework.fields;

import io.netty.buffer.ByteBuf;

public class BcdField extends AbstractField<byte[]> {
    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public byte[] getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < length) {
            return null;
        }

        byte[] buffer = new byte[length];
        buf.getBytes(buf.readerIndex(), buffer);
        buf.skipBytes(length);
        return buffer;
    }

    @Override
    public byte[] getByteArray(Object type) {
        if (!(type instanceof byte[])) {
            return null;
        }

        byte[] value = (byte[]) type;
        byte[] buf = new byte[length];
        if (value.length > length)
            System.arraycopy(value, 0, buf, 0, length);
        else
            System.arraycopy(value, 0, buf, length - value.length, value.length);
        return buf;
    }

    private int length;
}
