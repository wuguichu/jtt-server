package com.ljq.framework.fields;

import io.netty.buffer.ByteBuf;

public class ReserveField extends AbstractField<Byte> {
    @Override
    public void setLength(int length) {
        this.length = Math.max(length, 0);
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
    public void getByteArray(Object type, ByteBuf buf) {
        if (buf == null)
            return;

        buf.writeZero(length);
    }

    private int length;
}
