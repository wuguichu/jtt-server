package com.ljq.protocol.basic.attribute;

public class BaseStatusGsensor {
    public short getGsensorStatus() {
        return gsensorStatus;
    }

    public void setGsensorStatus(short gsensorStatus) {
        this.gsensorStatus = gsensorStatus;
    }

    @Override
    public String toString() {
        return "BaseStatusGsensor{" +
                "gsensorStatus=" + gsensorStatus +
                '}';
    }

    private short gsensorStatus;
}