package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;
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
    public byte[] getByteArray(Object type) {
        if (!(type instanceof Byte)) {
            return null;
        }
        return ByteTransform.byte2byteArray((Byte) type);
    }
}
