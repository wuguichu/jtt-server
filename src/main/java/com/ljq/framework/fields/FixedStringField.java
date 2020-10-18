package com.ljq.framework.fields;

public class FixedStringField extends AbstractField<String> {
    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public int byte2type(byte[] buf, int offset) {
        if (buf.length < length + offset) {
            return -1;
        }
        byte[] buffer = new byte[length];
        System.arraycopy(buf, offset, buffer, 0, length);
        type = new String(buffer);
        return length;
    }

    @Override
    public byte[] type2byte() {
        byte[] buffer = type.getBytes();
        byte[] buf = new byte[length];
        System.arraycopy(buffer, 0, buf, 0, buffer.length);
        return buf;
    }

    private int length;
}
