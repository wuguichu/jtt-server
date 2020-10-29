package com.ljq.protocol.basic.attribute;

import java.util.Arrays;

public class BaseStatusStorage {
    public BaseStatusStorage() {
        type = new short[4];
        status = new short[4];
        totalCapacity = new long[4];
        serial = new String[4];

        Arrays.fill(type, (short) 0xff);
    }

    public short[] getType() {
        return type;
    }

    public void setType(short[] type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "BaseStatusStorage{" +
                "type=" + Arrays.toString(type) +
                ", status=" + Arrays.toString(status) +
                ", totalCapacity=" + Arrays.toString(totalCapacity) +
                ", serial=" + Arrays.toString(serial) +
                '}';
    }

    private short[] type;
    private short[] status;
    private long[] totalCapacity;
    private String[] serial;
}