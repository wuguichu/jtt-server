package com.ljq.framework.fields;

import com.ljq.framework.codec.CommonDefine;
import io.netty.buffer.ByteBuf;

public class FixedStringField extends AbstractField<String> {
    @Override
    public void setLength(int length) {
        this.length = Math.max(length, 0);
    }

    @Override
    public String getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < length) {
            return null;
        }
        String value = buf.toString(buf.readerIndex(), length, CommonDefine.codecCharset);
        buf.skipBytes(length);
        return value;
    }

    @Override
    public void getByteArray(Object type, ByteBuf buf) {
        if (!(type instanceof String) || buf == null)
            return;

        String value = (String) type;
        byte[] buffer = value.getBytes(CommonDefine.codecCharset);
        if (buffer.length > length)
            buf.writeBytes(buffer, 0, length);
        else {
            buf.writeBytes(buffer);
            buf.writeZero(length - buffer.length);
        }
    }

    private int length;
}
