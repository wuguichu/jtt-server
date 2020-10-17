package com.ljq.framework.fields;

public class Int8Field extends AbstractField<Byte> {
    @Override
    public int byte2type(byte[] buf) {
        if (buf == null) {
            return -1;
        }
        type = buf[0];
        return 1;
    }

    @Override
    public byte[] type2byte() {
        return new byte[]{type};
    }
}
