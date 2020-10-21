package com.ljq.framework.fields;

import com.ljq.framework.utils.ByteTransform;

public class Uint32StringField extends AbstractField<String> {
    @Override
    public String getValue(byte[] buf, int offset, int[] retLength) {
        if (buf == null || buf.length < offset + 4 || retLength == null) {
            return null;
        }
        retLength[0] = ByteTransform.byte2int(buf, offset);
        if (retLength[0] < 0 || buf.length < offset + 4 + retLength[0]) {
            return null;
        }
        byte[] buffer = new byte[retLength[0]];
        System.arraycopy(buf, offset + 4, buffer, 0, retLength[0]);
        retLength[0] += 4;

        return new String(buffer);
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
