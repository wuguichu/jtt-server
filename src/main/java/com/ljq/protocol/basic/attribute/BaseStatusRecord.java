package com.ljq.protocol.basic.attribute;

import java.util.Arrays;

public class BaseStatusRecord {
    public BaseStatusRecord() {
        recordStatus = new short[16];

        Arrays.fill(recordStatus, (short) 0xff);
    }

    public short[] getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(short[] recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "BaseStatusRecord{" +
                "recordStatus=" + Arrays.toString(recordStatus) +
                '}';
    }

    private short[] recordStatus;
}