package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;

public class Int64Field extends AbstractField<Long> {
    @Override
    public int getLength() {
        return 8;
    }

    @Override
    public Long getValue(byte[] buf, int offset) {
        if (buf == null || buf.length < offset + 8) {
            return null;
        }
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
