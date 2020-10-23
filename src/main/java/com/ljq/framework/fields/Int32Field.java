package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;
import io.netty.buffer.ByteBuf;

public class Int32Field extends AbstractField<Integer> {
    @Override
    public Integer getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < 4) {
            return null;
        }
        int anInt = buf.getInt(buf.readerIndex());
        buf.skipBytes(4);
        return anInt;
    }

    @Override
    public byte[] getByteArray(Object type) {
        if (!(type instanceof Integer)) {
            return null;
        }
        return ByteTransform.int2byteArray((Integer) type);
    }
}
