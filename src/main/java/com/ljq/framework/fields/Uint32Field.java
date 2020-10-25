package com.ljq.framework.fields;

import io.netty.buffer.ByteBuf;

public class Uint32Field extends AbstractField<Long> {
    @Override
    public Long getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < 4) {
            return null;
        }
        long unsignedInt = buf.getUnsignedIntLE(buf.readerIndex());
        buf.skipBytes(4);
        return unsignedInt;
    }

    @Override
    public void getByteArray(Object type, ByteBuf buf) {
        if (!(type instanceof Long) || buf == null)
            return;

        buf.writeIntLE(((Long) type).intValue());
    }
}
