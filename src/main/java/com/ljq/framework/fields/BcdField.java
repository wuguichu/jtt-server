package com.ljq.framework.fields;

public class BcdField extends AbstractField<byte[]> {
    public BcdField() {
    }

    @Override
    public void setLength(int length) {
        this.length = length;
        type = new byte[length];
    }

    @Override
    public int byte2type(byte[] buf, int offset) {
        if (buf.length < length + offset) {
            return -1;
        }
        System.arraycopy(buf, offset, type, 0, length);
        return length;
    }

    @Override
    public byte[] type2byte() {
        return type;
    }

    private int length;
}
