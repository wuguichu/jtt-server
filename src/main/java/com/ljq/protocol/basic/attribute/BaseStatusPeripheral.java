package com.ljq.protocol.basic.attribute;

import java.util.Arrays;

public class BaseStatusPeripheral {
    public short[] getType() {
        return type;
    }

    public void setType(short[] type) {
        this.type = type;
    }

    public short[] getStat() {
        return stat;
    }

    public void setStat(short[] stat) {
        this.stat = stat;
    }

    public short[] getName() {
        return name;
    }

    public void setName(short[] name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BaseStatusPeripheral{" +
                "type=" + Arrays.toString(type) +
                ", stat=" + Arrays.toString(stat) +
                ", name=" + Arrays.toString(name) +
                '}';
    }

    private short[] type;
    private short[] stat;
    private short[] name;
}