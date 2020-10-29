package com.ljq.protocol.basic.attribute;

public class BaseStatusWifi {
    public short getModule() {
        return module;
    }

    public void setModule(short module) {
        this.module = module;
    }

    public short getSingle() {
        return single;
    }

    public void setSingle(short single) {
        this.single = single;
    }

    public short getFeatures() {
        return features;
    }

    public void setFeatures(short features) {
        this.features = features;
    }

    public short getMode() {
        return mode;
    }

    public void setMode(short mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "BaseStatusWifi{" +
                "module=" + module +
                ", single=" + single +
                ", features=" + features +
                ", mode=" + mode +
                '}';
    }

    private short module;
    private short single;
    private short features;
    private short mode;
}