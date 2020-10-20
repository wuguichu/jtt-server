package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;

public class Int16Field extends AbstractField<Short> {
    @Override
    public Short getValue(byte[] buf, int offset, int[] retLength) {
        if (buf == null || buf.length < offset + 2 || retLength == null) {
            return null;
        }
        retLength[0] = 2;
        return ByteTransform.byte2Short(buf, offset);
    }

    @Override
    public byte[] getByteArray(Object type) {
        if (!(type instanceof Short)) {
            return null;
        }
        return ByteTransform.short2byteArray((Short) type);
    }
}
