package com.ljq.framework.fields;

public class Int8Field extends AbstractField<Byte> {
    @Override
    public int byte2type(byte[] buf, int offset) {
        if (buf == null || buf.length < offset) {
            return -1;
        }
        type = buf[offset];
        return 1;
    }

    @Override
    public byte[] type2byte() {
        return new byte[]{type};
    }
}
