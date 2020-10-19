package com.ljq.framework.codec;

public abstract class AbstractInstruction {
	public AbstractInstruction(){
		header = new MessageHeader();
		header.setCurrentPack(0);
		header.setTotalPack(0);
	}
	
    public MessageHeader getHeader() {
        return header;
    }

    public void setHeader(MessageHeader header) {
        this.header = header;
    }

    protected MessageHeader header;
}
