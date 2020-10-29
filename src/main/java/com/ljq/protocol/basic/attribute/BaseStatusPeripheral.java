package com.ljq.protocol.basic.attribute;

import java.util.Arrays;

public class BaseStatusPeripheral {
	public BaseStatusPeripheral() {
        type = new short[12];
		stat = new short[12];
		name = new String[12];

		for(int i = 0; i < type.length; i++){
			type[i] = 0xff;
		}			
    }
	
    public short[] getType() {
        return type;
    }

    public void setType(short[] type) {
        this.type = type;
    }

    public short[] getStat() {
        return stat;
    }

    public void setStat(short[] stat) {
        this.stat = stat;
    }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BaseStatusPeripheral{" +
                "type=" + Arrays.toString(type) +
                ", stat=" + Arrays.toString(stat) +
                ", name=" + Arrays.toString(name) +
                '}';
    }

    private short[] type;
    private short[] stat;
    private String[] name;
}