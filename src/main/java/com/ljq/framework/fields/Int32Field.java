package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;

public class Int32Field extends AbstractField<Integer> {
    @Override
    public int byte2type(byte[] buf, int offset) {
        if (buf == null || buf.length < offset + 4) {
            return -1;
        }
        type = ByteTransform.byte2int(buf, offset);
        return 4;
    }

    @Override
    public byte[] type2byte() {
        return ByteTransform.int2byteArray(type);
    }
}
