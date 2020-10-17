package com.ljq.framework.fields;

public enum FieldType {
    INT8(),
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
