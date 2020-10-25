package com.ljq.framework.codec;

import com.ljq.framework.fields.AbstractField;
import com.ljq.framework.fields.FieldFactory;
import com.ljq.framework.utils.ClassUtil;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public final class InstructionBeanHelper {

    public static <T extends AbstractInstruction> HashMap<Integer, InstructionBeanInfo<T>> getBeanInfo(String packagePath, HashMap<String, Integer> clazzMap) {
        List<Class<?>> classList = ClassUtil.getClassList(packagePath);

        return getBeanInfo(classList, clazzMap);
    }

    public static <T extends AbstractInstruction> HashMap<Integer, InstructionBeanInfo<T>> getBeanInfo(String packagePath) {
        List<Class<?>> classList = ClassUtil.getClassList(packagePath);

        return getBeanInfo(classList);
    }


    private static <T extends AbstractInstruction> HashMap<Integer, InstructionBeanInfo<T>> getBeanInfo(List<Class<?>> clazzList, HashMap<String, Integer> clazzMap) {
        HashMap<Integer, InstructionBeanInfo<T>> infoHashMap = new HashMap<>();

        for (Class<?> clazz : clazzList) {
            Class<?> superclass = clazz.getSuperclass();
            if (superclass != null && AbstractInstruction.class.isAssignableFrom(superclass)) {
                Instruction instructAnno = clazz.getAnnotation(Instruction.class);
                if (instructAnno != null && instructAnno.value() > 0) {
                    InstructionBeanInfo<T> beanInfo = new InstructionBeanInfo<>();

                    beanInfo.setClazz((Class<T>) clazz);
                    beanInfo.setFieldInfo(getClassifiedInfo(clazz));

                    infoHashMap.put(instructAnno.value(), beanInfo);
                    clazzMap.put(clazz.getName(), instructAnno.value());
                }
            }
        }

        return infoHashMap;
    }

    private static <T extends AbstractInstruction> HashMap<Integer, InstructionBeanInfo<T>> getBeanInfo(List<Class<?>> clazzList) {
        HashMap<Integer, InstructionBeanInfo<T>> infoHashMap = new HashMap<>();

        for (Class<?> clazz : clazzList) {
            Class<?> superclass = clazz.getSuperclass();
            if (superclass != null && AbstractInstruction.class.isAssignableFrom(superclass)) {
                Instruction instructAnno = clazz.getAnnotation(Instruction.class);
                if (instructAnno != null && instructAnno.value() > 0) {
                    InstructionBeanInfo<T> beanInfo = new InstructionBeanInfo<>();

                    beanInfo.setClazz((Class<T>) clazz);
                    beanInfo.setFieldInfo(getClassifiedInfo(clazz));

                    infoHashMap.put(instructAnno.value(), beanInfo);
                }
            }
        }

        return infoHashMap;
    }

    private static TreeMap<Integer, FieldBeanInfo> getClassifiedInfo(Class<?> clazz) {
        TreeMap<Integer, FieldBeanInfo> integerFieldBeanInfoTreeMap = new TreeMap<>();

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                Method readMethod = propertyDescriptor.getReadMethod();
                if (readMethod != null && readMethod.isAnnotationPresent(Field.class)) {
                    Field field = readMethod.getDeclaredAnnotation(Field.class);
                    AbstractField<?> fieldProduct = FieldFactory.getFieldProduct(field.type());
                    if (field.length() > 0) {
                        assert fieldProduct != null;
                        fieldProduct.setLength(field.length());
                    }

                    FieldBeanInfo fieldBeanInfo = new FieldBeanInfo();
                    fieldBeanInfo.setField(fieldProduct);
                    fieldBeanInfo.setReadMethod(readMethod);
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    if (writeMethod != null) {
                        fieldBeanInfo.setWriteMethod(writeMethod);
                    }
                    integerFieldBeanInfoTreeMap.put(field.index(), fieldBeanInfo);
                }

            }
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }
        return integerFieldBeanInfoTreeMap;
    }
}
