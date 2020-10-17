package com.ljq.framework.codec;

import java.util.TreeMap;

public class InstructionBeanInfo<T extends AbstractInstruction> {
    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
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

    private Class<T> clazz;
    private TreeMap<Integer, FieldBeanInfo> fieldInfo;
}
