package com.ljq.protocol.basic;

public enum BasicId{
	CENTER_RESPONSE(0x0001, ""),
	TERMINAL_RESPONSE(0x0002, ""),
	TERMINAL_AUTH(0x0101, ""),
	INVALID_RESPONSE(0xffff, "");

	private BasicId(int id, String desc){
		this.id = id;
		this.desc = desc;
	}

	public final int id;
	public String desc;
}
