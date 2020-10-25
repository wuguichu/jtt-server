package com.ljq.framework.fields;

import io.netty.buffer.ByteBuf;

public abstract class AbstractField<T> {
    public void setLength(int length) {
    }

    public abstract T getValue(ByteBuf buf);

    public abstract void getByteArray(Object type, ByteBuf buf);
}
