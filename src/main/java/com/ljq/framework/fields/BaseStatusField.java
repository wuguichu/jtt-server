package com.ljq.framework.fields;

import com.ljq.protocol.basic.attribute.BaseStatus;
import io.netty.buffer.ByteBuf;

public class BaseStatusField extends AbstractField<BaseStatus> {

    @Override
    public BaseStatus getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < 8) {
            return null;
        }
        buf.skipBytes(4);

        return new BaseStatus();
    }

    @Override
    public void getByteArray(Object type, ByteBuf buf) {
        if (!(type instanceof String) || buf == null) {
        }
    }
}
