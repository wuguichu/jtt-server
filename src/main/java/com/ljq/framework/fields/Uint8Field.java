package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;
import io.netty.buffer.ByteBuf;

public class Uint8Field extends AbstractField<Short> {
    @Override
    public Short getValue(ByteBuf buf) {
        if (buf == null || buf.readableBytes() < 1) {
            return null;
        }
        short unsignedByte = buf.getUnsignedByte(buf.readerIndex());
        buf.skipBytes(1);
        return unsignedByte;
    }

    @Override
    public byte[] getByteArray(Object type) {
        if (!(type instanceof Short)) {
            return null;
        }
        return ByteTransform.unsignedByte2byteArray((Short) type);
    }
}
