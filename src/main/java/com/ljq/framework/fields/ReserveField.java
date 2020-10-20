package com.ljq.framework.fields;

public class ReserveField extends AbstractField<Byte> {
    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public Byte getValue(byte[] buf, int offset) {
        if (buf == null || buf.length < offset + length) {
            return null;
        }

        return 0;
    }

    @Override
    public byte[] getByteArray(Object type) {
        return new byte[length];
    }

    private int length;
}
