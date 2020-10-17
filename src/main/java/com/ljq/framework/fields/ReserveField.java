package com.ljq.framework.fields;

public class ReserveField extends AbstractField<Byte>{
	@Override
	public void setLength(int length){ this.length = length;}
	
	@Override
	public int byte2type(byte[] buf){
		if(buf.length < length){
			return -1;
		}
		return length;
	}

	@Override
	public byte[] type2byte(){
		byte[] buf = new byte[length];
		return buf;
	}

	private int length;
}
