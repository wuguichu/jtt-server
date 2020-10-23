package com.ljq.framework.fields;

import io.netty.buffer.ByteBuf;

public class ReserveField extends AbstractField<Byte> {
    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public Byte getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < length) {
            return null;
        }
        buf.skipBytes(length);
        return 0;
    }

    @Override
    public byte[] getByteArray(Object type) {
        return new byte[length];
    }

    private int length;
}
