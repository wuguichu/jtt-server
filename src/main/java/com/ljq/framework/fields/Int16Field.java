package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;
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
    public byte[] getByteArray(Object type) {
        if (!(type instanceof Short)) {
            return null;
        }
        return ByteTransform.short2byteArray((Short) type);
    }
}
