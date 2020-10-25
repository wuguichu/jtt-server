package com.ljq.framework.fields;

import io.netty.buffer.ByteBuf;

public class BcdField extends AbstractField<byte[]> {
    @Override
    public void setLength(int length) {
        this.length = Math.max(length, 0);
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
    public void getByteArray(Object type, ByteBuf buf) {
        if (!(type instanceof byte[]) || buf == null)
            return;

        byte[] buffer = (byte[]) type;
        if (buffer.length > length)
            buf.writeBytes(buffer, 0, length);
        else {
            buf.writeBytes(buffer);
            buf.writeZero(length - buffer.length);
        }
    }

    private int length;
}
