package com.ljq.protocol.basic;

import com.ljq.framework.codec.Field;
import com.ljq.framework.codec.Instruction;
import com.ljq.framework.fields.FieldType;

@Instruction(0x0101)// 0x0101 BasicId.TERMINAL_AUTH.id
public class TerminalAuth{
	public void setBcdTerminalSerial(byte[] bcdTerminalSerial){
		this.bcdTerminalSerial = bcdTerminalSerial;
	}

	@Field(index = 0, type = FieldType.BCD, length = 6)
	public byte[] getBcdTerminalSerial(){
		return bcdTerminalSerial;
	}

	public void setReverse(byte reverse){
		this.reverse = reverse;
	}

	@Field(index = 1, type = FieldType.REVERSE, length = 2)
	public byte getReverse(){
		return reverse;
	}

	public void setManufacturerId(String manufacturerId){
		this.manufacturerId = manufacturerId;
	}

	@Field(index = 2, type = FieldType.FIXEDSTRING, length = 32)
	public String getManufacturerId(){
		return manufacturerId;
	}

	private byte[] bcdTerminalSerial;
	private byte reverse;
	private String manufacturerId;
}
