package com.ljq.framework.codec;

import com.ljq.framework.fields.AbstractField;

import java.lang.reflect.Method;

public class FieldBeanInfo {
	public InstructionBeanInfo getSubTypeBeanInfo() {
        return subTypeBeanInfo;
    }

    public void setSubTypeBeanInfo(InstructionBeanInfo subTypeBeanInfo) {
        this.subTypeBeanInfo = subTypeBeanInfo;
    }
	
    public AbstractField<?> getField() {
        return field;
    }

    public void setField(AbstractField<?> field) {
        this.field = field;
    }

    public Method getReadMethod() {
        return readMethod;
    }

    public void setReadMethod(Method readMethod) {
        this.readMethod = readMethod;
    }

    public Method getWriteMethod() {
        return writeMethod;
    }

    public void setWriteMethod(Method writeMethod) {
        this.writeMethod = writeMethod;
    }

    @Override
    public String toString() {
        return "FieldBeanInfo{" +
				"subTypeBeanInfo=" + subTypeBeanInfo +
                "field=" + field +
                ", readMethod=" + readMethod +
                ", writeMethod=" + writeMethod +
                '}';
    }

	private InstructionBeanInfo subTypeBeanInfo;
    private AbstractField<?> field;
    private Method readMethod;
    private Method writeMethod;
}
