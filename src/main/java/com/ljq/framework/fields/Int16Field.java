package com.ljq.framework.fields;

import io.netty.buffer.ByteBuf;

public class Int16Field extends AbstractField<Short> {
    @Override
    public Short getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < 2) {
            return null;
        }

        short aShort = buf.getShortLE(buf.readerIndex());
        buf.skipBytes(2);

        return aShort;
    }

    @Override
    public void getByteArray(Object type, ByteBuf buf) {
        if (!(type instanceof Short) || buf == null)
            return;

        buf.writeShortLE((Short) type);
    }
}
