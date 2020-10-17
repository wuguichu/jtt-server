package com.ljq.framework.fields;

public enum FieldType{
	INT8(),
	FIXEDSTRING(),
	BCD(),
	REVERSE();

	private FieldType(){
	}

	private FieldType(String desc){
		this.desc = desc;
	}

	public String desc;
}
