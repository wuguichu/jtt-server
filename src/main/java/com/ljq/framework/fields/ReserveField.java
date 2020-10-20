package com.ljq.framework.fields;

public class ReserveField extends AbstractField<Byte> {
    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public Byte getValue(byte[] buf, int offset, int[] retLength) {
        if (buf == null || buf.length < offset + length || retLength == null) {
            return null;
        }
        retLength[0] = length;

        return 0;
    }

    @Override
    public byte[] getByteArray(Object type) {
        return new byte[length];
    }

    private int length;
}
