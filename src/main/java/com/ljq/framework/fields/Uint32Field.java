package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;

public class Uint32Field extends AbstractField<Long> {
    @Override
    public Long getValue(byte[] buf, int offset, int[] retLength) {
        if (buf == null || buf.length < offset + 4 || retLength == null) {
            return null;
        }
        retLength[0] = 4;
        return ByteTransform.byte2Unsignedint(buf, offset);
    }

    @Override
    public byte[] getByteArray(Object type) {
        if (!(type instanceof Long)) {
            return null;
        }
        return ByteTransform.unsignedInt2byteArray((Long) type);
    }
}
