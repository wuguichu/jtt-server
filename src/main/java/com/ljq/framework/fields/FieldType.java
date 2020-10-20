package com.ljq.framework.fields;

public enum FieldType {
    INT8(),
    INT16(),
    INT32(),
    INT64(),
    UINT8(),
    UINT16(),
    UINT32(),
    FIXEDSTRING(),
    BCD(),
    RESERVE();

    FieldType() {
    }

    FieldType(String desc) {
        this.desc = desc;
    }

    public String desc;
}
