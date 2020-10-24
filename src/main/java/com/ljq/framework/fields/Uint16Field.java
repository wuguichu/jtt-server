package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;
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
    public byte[] getByteArray(Object type) {
        if (!(type instanceof Integer)) {
            return null;
        }
        return ByteTransform.unsignedShort2byteArray((Integer) type);
    }
}
