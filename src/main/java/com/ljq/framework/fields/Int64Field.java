package com.ljq.framework.fields;

import io.netty.buffer.ByteBuf;

public class Int64Field extends AbstractField<Long> {
    @Override
    public Long getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < 8) {
            return null;
        }
        long aLong = buf.getLongLE(buf.readerIndex());
        buf.skipBytes(8);
        return aLong;
    }

    @Override
    public void getByteArray(Object type, ByteBuf buf) {
        if (!(type instanceof Long) || buf == null)
            return;

        buf.writeLongLE((Long) type);
    }
}
