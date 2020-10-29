package com.ljq.protocol.basic.attribute;

public class BaseStatusVoltage {
    public int getVoltageStatus() {
        return voltageStatus;
    }

    public void setVoltageStatus(int voltageStatus) {
        this.voltageStatus = voltageStatus;
    }

    public short getAccStatus() {
        return accStatus;
    }

    public void setAccStatus(short accStatus) {
        this.accStatus = accStatus;
    }

    @Override
    public String toString() {
        return "BaseStatusVoltage{" +
                "voltageStatus=" + voltageStatus +
                ", accStatus=" + accStatus +
                '}';
    }

    private int voltageStatus;
    private short accStatus;
}