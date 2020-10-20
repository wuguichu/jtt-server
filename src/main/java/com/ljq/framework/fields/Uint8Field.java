package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;

public class Uint8Field extends AbstractField<Short> {
    @Override
    public Short getValue(byte[] buf, int offset, int[] retLength) {
        if (buf == null || buf.length < offset + 1 || retLength == null) {
            return null;
        }
        retLength[0] = 1;
        return ByteTransform.byte2UnsignedByte(buf, offset);
    }

    @Override
    public byte[] getByteArray(Object type) {
        if (!(type instanceof Short)) {
            return null;
        }
        return ByteTransform.unsignedByte2byteArray((Short) type);
    }
}
