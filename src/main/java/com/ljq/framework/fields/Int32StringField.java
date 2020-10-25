package com.ljq.framework.fields;

import com.ljq.framework.codec.CommonDefine;
import io.netty.buffer.ByteBuf;

public class Int32StringField extends AbstractField<String> {
    @Override
    public String getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < 4) {
            return null;
        }
        int length = buf.getIntLE(buf.readerIndex());
        buf.skipBytes(4);
        if (length == 0) {
            return "";
        } else if (length < 0 || buf.readableBytes() < length) {
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
        buf.writeIntLE(buffer.length);
        buf.writeBytes(buffer);
    }
}
