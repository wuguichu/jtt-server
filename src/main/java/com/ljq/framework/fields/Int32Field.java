package com.ljq.framework.fields;

import io.netty.buffer.ByteBuf;

public class Int32Field extends AbstractField<Integer> {
    @Override
    public Integer getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < 4) {
            return null;
        }
        int anInt = buf.getIntLE(buf.readerIndex());
        buf.skipBytes(4);
        return anInt;
    }

    @Override
    public void getByteArray(Object type, ByteBuf buf) {
        if (!(type instanceof Integer) || buf == null)
            return;

        buf.writeIntLE((Integer) type);
    }
}
