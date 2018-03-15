package com.honglinktech.zbgj.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Method util.
 *
 * @author Dayong
 */
public final class MethodUtil {
    private MethodUtil() {
    }

    /**
     * 获取传进来的类的属性，static类型的除外
     *
     * @param cls the cls
     * @return all field
     */
    public static Map<String, String> getAllField(Class<?> cls) {
        Map<String, String> result = new HashMap<String, String>();
        // 取得本类的全部属性
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            // 权限修饰符
            int mo = field.getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            if (priv.indexOf("static") > -1) {
                // Do nothing
                continue;
            } else {
                Class<?> type = field.getType();
                result.put(field.getName(), type.getName());
            }
        }
        return result;
    }

    /**
     * 获取所有Get开头的方法
     *
     * @param cls the cls
     * @return getter method
     */
    public List<String> getGetterMethod(Class<?> cls) {
        Method[] methods = cls.getMethods();
        List<String> result = new ArrayList<String>();
        for (Method method : methods) {
            String name = method.getName();
            if (name.startsWith("get")) {
                result.add(name);
            }
        }
        return result;
    }

    /**
     * 获取传进来的类的所有Set开头的方法
     *
     * @param cls the cls
     * @return setter method
     */
    public List<String> getSetterMethod(Class<?> cls) {
        Method[] methods = cls.getMethods();
        List<String> result = new ArrayList<String>();
        for (Method method : methods) {
            String name = method.getName();
            if (name.startsWith("set")) {
                result.add(name);
            }
        }
        return result;
    }

    /**
     * 调用传进来的类的方法
     *
     * @param owner      the owner
     * @param methodName the method name
     * @param args       the args
     * @return object
     * @throws Exception the exception
     */
    public static Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
        Class<?> ownerClass = owner.getClass();
        Method method = null;
        if (null != args && args.length > 0) {
            Class<?>[] argsClass = new Class[args.length];
            for (int i = 0, j = args.length; i < j; i++) {
                if (null != args[i]) {
                    argsClass[i] = args[i].getClass();
                }
            }
            method = ownerClass.getDeclaredMethod(methodName, argsClass);
            return method.invoke(owner, args);
        } else {
            method = ownerClass.getDeclaredMethod(methodName);
            return method.invoke(owner);
        }
    }
}
