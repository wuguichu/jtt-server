package com.ljq.framework.fields;

import io.netty.buffer.ByteBuf;

public class Uint16Field extends AbstractField<Integer> {
    @Override
    public Integer getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < 2) {
            return null;
        }
        int unsignedShort = buf.getUnsignedShortLE(buf.readerIndex());
        buf.skipBytes(2);
        return unsignedShort;
    }

    @Override
    public void getByteArray(Object type, ByteBuf buf) {
        if (!(type instanceof Integer) || buf == null)
            return;

        buf.writeShortLE((Integer) type);
    }
}
