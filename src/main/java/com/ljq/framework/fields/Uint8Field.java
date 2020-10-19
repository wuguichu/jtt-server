package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;

public class Uint8Field extends AbstractField<Short> {
    @Override
    public int byte2type(byte[] buf, int offset) {
        if (buf == null || buf.length < offset + 1) {
            return -1;
        }
        type = ByteTransform.byte2UnsignedByte(buf, offset);
        return 1;
    }

    @Override
    public byte[] type2byte() {
        return ByteTransform.unsignedByte2byteArray(type);
    }
}
