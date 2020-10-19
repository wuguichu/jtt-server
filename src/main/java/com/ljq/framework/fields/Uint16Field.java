package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;

public class Uint16Field extends AbstractField<Integer> {
    @Override
    public int byte2type(byte[] buf, int offset) {
        if (buf == null || buf.length < offset + 2) {
            return -1;
        }
        type = ByteTransform.byte2UnsignedShort(buf, offset);
        return 2;
    }

    @Override
    public byte[] type2byte() {
        return ByteTransform.unsignedShort2byteArray(type);
    }
}
