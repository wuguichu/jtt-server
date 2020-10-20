package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;

public class Int16Field extends AbstractField<Short> {
    @Override
    public int getLength() {
        return 2;
    }

    @Override
    public Short getValue(byte[] buf, int offset) {
        if (buf == null || buf.length < offset + 2) {
            return null;
        }
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
