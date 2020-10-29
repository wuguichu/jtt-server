package com.ljq.protocol.basic.attribute;

import java.util.Arrays;

public class BaseStatusRecord {
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