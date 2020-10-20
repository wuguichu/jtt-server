package com.ljq.framework.fields;

public abstract class AbstractField<T> {
    public void setLength(int length) {
    }

    public abstract T getValue(byte[] buf, int offset, int[] retLength);// retLength[0]返回此字段解析用到的长度，暂时这么干

    public abstract byte[] getByteArray(Object type);
}
