package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;
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
    public byte[] getByteArray(Object type) {
        if (!(type instanceof Long)) {
            return null;
        }
        return ByteTransform.long2byteArray((Long) type);
    }
}
