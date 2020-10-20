package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;

public class Uint16Field extends AbstractField<Integer> {
    @Override
    public Integer getValue(byte[] buf, int offset, int[] retLength) {
        if (buf == null || buf.length < offset + 2 || retLength == null) {
            return null;
        }
        retLength[0] = 2;
        return ByteTransform.byte2UnsignedShort(buf, offset);
    }

    @Override
    public byte[] getByteArray(Object type) {
        if (!(type instanceof Integer)) {
            return null;
        }
        return ByteTransform.unsignedShort2byteArray((Integer) type);
    }
}
