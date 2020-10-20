package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;

public class Int64Field extends AbstractField<Long> {
    @Override
    public Long getValue(byte[] buf, int offset, int[] retLength) {
        if (buf == null || buf.length < offset + 8 || retLength == null) {
            return null;
        }
        retLength[0] = 8;
        return ByteTransform.byte2Long(buf, offset);
    }

    @Override
    public byte[] getByteArray(Object type) {
        if (!(type instanceof Long)) {
            return null;
        }
        return ByteTransform.long2byteArray((Long) type);
    }
}
