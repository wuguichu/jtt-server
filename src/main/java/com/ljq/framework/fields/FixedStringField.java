package com.ljq.framework.fields;

public class FixedStringField extends AbstractField<String> {
    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String getValue(byte[] buf, int offset, int[] retLength) {
        if (buf == null || buf.length < offset + length || retLength == null) {
            return null;
        }
        byte[] buffer = new byte[length];
        System.arraycopy(buf, offset, buffer, 0, length);
        retLength[0] = length;
        return new String(buffer);
    }

    @Override
    public byte[] getByteArray(Object type) {
        if (!(type instanceof String)) {
            return null;
        }

        String value = (String) type;
        byte[] buffer = value.getBytes();
        byte[] buf = new byte[length];
        if (buffer.length > length)
            System.arraycopy(buffer, 0, buf, 0, length);
        else
            System.arraycopy(buffer, 0, buf, length - buffer.length, buffer.length);
        return buf;
    }

    private int length;
}
