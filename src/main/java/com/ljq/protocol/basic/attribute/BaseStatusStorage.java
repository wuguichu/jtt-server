package com.ljq.protocol.basic.attribute;

public class BaseStatusStorage {
	public BaseStatusStorage() {
        status = new short[4];
		totalCapacity = new long[4];
		serial = new String[4];

		for(int i = 0; i < status.length; i++){
			status[i] = 0xff;
		}			
    }
	
    public short[] getStatus() {
        return status;
    }

    public void setStatus(short[] status) {
        this.status = status;
    }

    public long[] getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(long[] totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public String[] getSerial() {
        return serial;
    }

    public void setSerial(String[] serial) {
        this.serial = serial;
    }

    private short[] status;
    private long[] totalCapacity;
    private String[] serial;
}