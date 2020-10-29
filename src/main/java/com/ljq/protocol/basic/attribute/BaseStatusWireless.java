package com.ljq.protocol.basic.attribute;

public class BaseStatusWireless {
    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public byte getSignal() {
        return signal;
    }

    public void setSignal(byte signal) {
        this.signal = signal;
    }

    public short getMode() {
        return mode;
    }

    public void setMode(short mode) {
        this.mode = mode;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "BaseStatusWireless{" +
                "type=" + type +
                ", signal=" + signal +
                ", mode=" + mode +
                ", mac='" + mac + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }

    private short type;
    private byte signal;
    private short mode;
    private String mac;
    private String ip;
}