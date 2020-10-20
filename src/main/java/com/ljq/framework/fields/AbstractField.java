package com.ljq.framework.fields;

public abstract class AbstractField<T> {
    public void setLength(int length) {
    }

    public int getLength() {
        return 0;
    }

    public abstract T getValue(byte[] buf, int offset);

    public abstract byte[] getByteArray(Object type);
}
