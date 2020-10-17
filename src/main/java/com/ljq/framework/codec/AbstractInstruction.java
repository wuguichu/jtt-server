package com.ljq.framework.codec;

public abstract class AbstractInstruction{
	public void setHeader(MessageHeader header){
		this.header = header;
	}

	public MessageHeader getHeader(){
		return header;
	}
	
	protected MessageHeader header;
}
