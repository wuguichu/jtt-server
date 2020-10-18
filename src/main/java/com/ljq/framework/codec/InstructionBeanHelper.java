package com.ljq.framework.codec;

import com.ljq.framework.fields.AbstractField;
import com.ljq.framework.fields.FieldFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class InstructionBeanHelper {

    public static <T extends AbstractInstruction> HashMap<Integer, InstructionBeanInfo<T>> getBeanInfo(String packagePath) {
        List<Class<?>> classList = getClassList(packagePath);

        return getBeanInfo(classList);
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

    private static List<Class<?>> getClassList(String packagePath) {
        List<Class<?>> classList = new LinkedList<>();
        String path = packagePath.replace(".", "/");
        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(path);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();

                if (url != null) {
                    String protocol = url.getProtocol();

                    if (protocol.equals("file")) {
                        addClass(classList, url.toURI().getPath(), packagePath);
                    } else if (protocol.equals("jar")) {
                        JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                        JarFile jarFile = jarURLConnection.getJarFile();

                        Enumeration<JarEntry> jarEntries = jarFile.entries();
                        while (jarEntries.hasMoreElements()) {

                            JarEntry jarEntry = jarEntries.nextElement();
                            String entryName = jarEntry.getName();

                            if (entryName.startsWith(path) && entryName.endsWith(".class")) {
                                String className = entryName.substring(0, entryName.lastIndexOf(".")).replaceAll("/", ".");
                                addClass(classList, className);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return classList;
    }

    private static void addClass(List<Class<?>> classList, String packagePath, String packageName) {
        try {
            File[] files = new File(packagePath).listFiles(file -> (file.isDirectory() || file.getName().endsWith(".class")));
            if (files != null)
                for (File file : files) {
                    String fileName = file.getName();
                    if (file.isFile()) {
                        String className = fileName.substring(0, fileName.lastIndexOf("."));
                        if (packageName != null) {
                            className = packageName + "." + className;
                        }
                        addClass(classList, className);
                    } else {
                        String subPackagePath = fileName;
                        if (packageName != null) {
                            subPackagePath = packagePath + "/" + subPackagePath;
                        }
                        String subPackageName = fileName;
                        if (packageName != null) {
                            subPackageName = packageName + "." + subPackageName;
                        }
                        addClass(classList, subPackagePath, subPackageName);
                    }
                }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void addClass(List<Class<?>> classList, String className) throws ClassNotFoundException {
        classList.add(Class.forName(className));
    }
}
