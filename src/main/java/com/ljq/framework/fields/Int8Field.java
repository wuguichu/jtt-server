package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;

public class Int8Field extends AbstractField<Byte> {
    @Override
    public int getLength() {
        return 1;
    }

    @Override
    public Byte getValue(byte[] buf, int offset) {
        if (buf == null || buf.length < offset + 1) {
            return null;
        }
        return ByteTransform.byte2Byte(buf, offset);
    }

    @Override
    public byte[] getByteArray(Object type) {
        if (!(type instanceof Byte)) {
            return null;
        }
        return ByteTransform.byte2byteArray((Byte) type);
    }
}
