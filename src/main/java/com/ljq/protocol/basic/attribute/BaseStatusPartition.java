package com.ljq.protocol.basic.attribute;

public class BaseStatusPartition {
    public short getUdiskStatus() {
        return udiskStatus;
    }

    public void setUdiskStatus(short udiskStatus) {
        this.udiskStatus = udiskStatus;
    }

    public short getUmmcStatus() {
        return ummcStatus;
    }

    public void setUmmcStatus(short ummcStatus) {
        this.ummcStatus = ummcStatus;
    }

    @Override
    public String toString() {
        return "BaseStatusPartition{" +
                "udiskStatus=" + udiskStatus +
                ", ummcStatus=" + ummcStatus +
                '}';
    }

    private short udiskStatus;
    private short ummcStatus;
}