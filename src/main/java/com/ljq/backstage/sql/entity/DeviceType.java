package com.ljq.backstage.sql.entity;

public class DeviceType {
    public DeviceType() {
    }

    public DeviceType(byte id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "DeviceType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    private byte id;
    private String typeName;
}
