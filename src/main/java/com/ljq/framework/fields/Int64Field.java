package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;

public class Int64Field extends AbstractField<Long> {
    @Override
    public int byte2type(byte[] buf, int offset) {
        if (buf == null || buf.length < offset + 8) {
            return -1;
        }
        type = ByteTransform.byte2Long(buf, offset);
        return 8;
    }

    @Override
    public byte[] type2byte() {
        return ByteTransform.long2byteArray(type);
    }
}
