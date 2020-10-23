package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;
import io.netty.buffer.ByteBuf;

public class Uint32Field extends AbstractField<Long> {
    @Override
    public Long getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < 4) {
            return null;
        }
        long unsignedInt = buf.getUnsignedInt(buf.readerIndex());
        buf.skipBytes(4);
        return unsignedInt;
    }

    @Override
    public byte[] getByteArray(Object type) {
        if (!(type instanceof Long)) {
            return null;
        }
        return ByteTransform.unsignedInt2byteArray((Long) type);
    }
}
