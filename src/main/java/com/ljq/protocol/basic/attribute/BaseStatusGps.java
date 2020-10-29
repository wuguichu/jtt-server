package com.ljq.protocol.basic.attribute;

public class BaseStatusGps {
    public short getGpsStatus() {
        return gpsStatus;
    }

    public void setGpsStatus(short gpsStatus) {
        this.gpsStatus = gpsStatus;
    }

    @Override
    public String toString() {
        return "BaseStatusGps{" +
                "gpsStatus=" + gpsStatus +
                '}';
    }

    private short gpsStatus;
}