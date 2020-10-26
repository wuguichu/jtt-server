package com.ljq.framework.codec;

import java.util.TreeMap;

public class InstructionBeanInfo {
    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public TreeMap<Integer, FieldBeanInfo> getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(TreeMap<Integer, FieldBeanInfo> fieldInfo) {
        this.fieldInfo = fieldInfo;
    }

    @Override
    public String toString() {
        return "InstructionBeanInfo{" +
                "clazz=" + clazz +
                ", fieldInfo size=" + fieldInfo.size() +
                '}';
    }

    private Class<?> clazz;
    private TreeMap<Integer, FieldBeanInfo> fieldInfo;
}
