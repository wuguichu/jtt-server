package com.ljq.framework.fields;

import io.netty.buffer.ByteBuf;

public class Uint8Field extends AbstractField<Short> {
    @Override
    public Short getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < 1) {
            return null;
        }
        short unsignedByte = buf.getUnsignedByte(buf.readerIndex());
        buf.skipBytes(1);
        return unsignedByte;
    }

    @Override
    public void getByteArray(Object type, ByteBuf buf) {
        if (!(type instanceof Short) || buf == null)
            return;

        buf.writeByte((Short) type);
    }
}
