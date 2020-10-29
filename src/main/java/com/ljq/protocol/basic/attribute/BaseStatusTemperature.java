package com.ljq.protocol.basic.attribute;

public class BaseStatusTemperature {
    public short getInsideTemperature() {
        return insideTemperature;
    }

    public void setInsideTemperature(short insideTemperature) {
        this.insideTemperature = insideTemperature;
    }

    public short getOutsideTemperature() {
        return outsideTemperature;
    }

    public void setOutsideTemperature(short outsideTemperature) {
        this.outsideTemperature = outsideTemperature;
    }

    @Override
    public String toString() {
        return "BaseStatusTemperature{" +
                "insideTemperature=" + insideTemperature +
                ", outsideTemperature=" + outsideTemperature +
                '}';
    }

    private short insideTemperature;
    private short outsideTemperature;
}