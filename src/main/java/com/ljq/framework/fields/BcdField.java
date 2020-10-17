package com.ljq.framework.fields;

public class BcdField extends AbstractField<byte[]>{
	@Override
	public void setLength(int length){ this.length = length;}
	
	@Override
	public int byte2type(byte[] buf){
		if(buf.length < length){
			return -1;
		}
		System.arraycopy(buf, 0, type, 0, length);
		return length;
	}

	@Override
	public byte[] type2byte(){
		return type;
	}

	private int length;
}
