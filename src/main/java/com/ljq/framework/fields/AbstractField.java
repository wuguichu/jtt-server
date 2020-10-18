package com.ljq.framework.fields;

public abstract class AbstractField<T>{
	public void setLength(int length){}
	public T getType(){return type;}
	public void setType(T type){this.type = type;}
	public abstract int byte2type(byte[] buf,int offset);
	public abstract byte[] type2byte();

	protected T type;
}
