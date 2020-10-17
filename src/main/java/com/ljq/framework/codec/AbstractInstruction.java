package com.ljq.framework.codec;

public abstract class AbstractInstruction {
    public MessageHeader getHeader() {
        return header;
    }

    public void setHeader(MessageHeader header) {
        this.header = header;
    }

    protected MessageHeader header;
}
