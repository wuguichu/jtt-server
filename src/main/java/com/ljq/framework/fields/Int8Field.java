package com.ljq.framework.fields;

import io.netty.buffer.ByteBuf;

public class Int8Field extends AbstractField<Byte> {
    @Override
    public Byte getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < 1) {
            return null;
        }
        byte aByte = buf.getByte(buf.readerIndex());
        buf.skipBytes(1);
        return aByte;
    }

    @Override
    public void getByteArray(Object type, ByteBuf buf) {
        if (!(type instanceof Byte) || buf == null)
            return;

        buf.writeByte((Byte) type);
    }
}
