package com.ljq.framework.codec;

public interface CustomCodec {
    int customDecode(int index, byte[] buf, int offset);

    byte[] customEncode(int index);
}
