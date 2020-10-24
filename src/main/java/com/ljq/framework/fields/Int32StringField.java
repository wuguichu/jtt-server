package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

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
        } else if (buf.readableBytes() < length) {
            return null;
        }
        String value = buf.toString(buf.readerIndex(), length, Charset.forName("gbk"));
        buf.skipBytes(length);
        return value;
    }

    @Override
    public byte[] getByteArray(Object type) {
        if (!(type instanceof String)) {
            return null;
        }

        String value = (String) type;
        byte[] buffer = value.getBytes();
        byte[] buf = new byte[buffer.length + 4];
        System.arraycopy(ByteTransform.int2byteArray(buffer.length), 0, buf, 0, 4);
        System.arraycopy(buffer, 0, buf, 4, buffer.length);
        return buf;
    }
}
