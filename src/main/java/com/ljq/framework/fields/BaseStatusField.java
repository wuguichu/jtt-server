package com.ljq.framework.fields;

import com.ljq.framework.codec.CommonDefine;
import com.ljq.protocol.basic.attribute.*;

import io.netty.buffer.ByteBuf;

public class BaseStatusField extends AbstractField<BaseStatus> {

    @Override
    public BaseStatus getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < 8) {
            return null;
        }
		buf.skipBytes(4);
		
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
}
