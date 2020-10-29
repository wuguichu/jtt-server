package com.ljq.protocol.basic.attribute;

public class BaseStatusWifi {
    public short getModule() {
        return module;
    }

    public void setModule(short module) {
        this.module = module;
    }

    public short getSingel() {
        return singel;
    }

    public void setSingel(short singel) {
        this.singel = singel;
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
                ", singel=" + singel +
                ", features=" + features +
                ", mode=" + mode +
                '}';
    }

    private short module;
    private short singel;
    private short features;
    private short mode;
}