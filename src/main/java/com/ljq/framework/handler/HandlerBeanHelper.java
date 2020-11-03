package com.ljq.framework.handler;

import com.ljq.framework.codec.AbstractInstruction;
import com.ljq.framework.utils.ClassUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

public final class HandlerBeanHelper {

    public static HashMap<Integer, AbstractHandler<? extends AbstractInstruction>> getBeanInfo(String packagePath) {
        List<Class<?>> classList = ClassUtil.getClassList(packagePath);

        return getBeanInfo(classList);
    }

    private static HashMap<Integer, AbstractHandler<? extends AbstractInstruction>> getBeanInfo(List<Class<?>> clazzList) {
        HashMap<Integer, AbstractHandler<? extends AbstractInstruction>> infoHashMap = new HashMap<>();

        for (Class<?> clazz : clazzList) {
            Class<?> superclass = clazz.getSuperclass();
            if (superclass != null && AbstractHandler.class.isAssignableFrom(superclass)) {
                HandlerMap annotation = clazz.getAnnotation(HandlerMap.class);
                if (annotation != null) {
                    Object handlerObj;
                    try {
                        handlerObj = clazz.getDeclaredConstructor().newInstance();
                        for (int value : annotation.value()) {
                            infoHashMap.put(value, (AbstractHandler<? extends AbstractInstruction>) handlerObj);
                        }
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return infoHashMap;
    }
}
