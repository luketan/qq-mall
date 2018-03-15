package com.honglinktech.zbgj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 值类型转换的工具类
 *
 * @author Dayong
 */
public final class TypeUtil {

    /**
     * The constant TWO.
     */
    public static final int TWO = 2;

    private TypeUtil() {
    }

    /**
     * 把字符串转换成首字母大写
     *
     * @param value the value
     * @return string string
     */
    public static String firstUpString(String value) {
        if (value.length() == 1) {
            return value.toUpperCase();
        }
        if (value.length() >= TWO) {
            return value.substring(0, 1).toUpperCase() + value.substring(1);
        }
        return value;
    }

    /**
     * 把各种类型的值转换成String类型的
     *
     * @param type  the type
     * @param value the value
     * @return string string
     */
    public static String valueToSring(String type, Object value) {
        String result = null;
        if (null == value) {
            return "";
        }
        if (type.equals(Date.class.getName())) {
            result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
        } else if (type.equals(Boolean.class.getName())) {
            result = value.toString();
        } else if (type.equals(Byte.class.getName())) {
            result = value.toString();
        } else if (type.equals(Short.class.getName())) {
            result = value.toString();
        } else if (type.equals(Integer.class.getName())) {
            result = value.toString();
        } else if (type.equals(Long.class.getName())) {
            result = value.toString();
        } else if (type.equals(Float.class.getName())) {
            result = value.toString();
        } else if (type.equals(Double.class.getName())) {
            result = value.toString();
        } else {
            result = value.toString();
        }
        return result;
    }

    /**
     * 把String的值转换成属性对应类型的值
     *
     * @param value 属性的值
     * @param type  值的类型
     * @return object object
     * @throws NullPointerException the null pointer exception
     * @throws ParseException       the parse exception
     */
    public static Object stringToValue(String value, String type) throws NullPointerException, ParseException {
        Object result = null;
        if (null == value || "".equals(value)) {
            throw new NullPointerException();
        }
        if (type.equals(Date.class.getName())) {
            result = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value);
        } else if (type.equals(Boolean.class.getName())) {
            result = new Boolean(value);
        } else if (type.equals(Byte.class.getName())) {
            result = Byte.parseByte(value);
        } else if (type.equals(Short.class.getName())) {
            result = Short.parseShort(value);
        } else if (type.equals(Integer.class.getName())) {
            result = Integer.parseInt(value);
        } else if (type.equals(Long.class.getName())) {
            result = Long.parseLong(value);
        } else if (type.equals(Float.class.getName())) {
            result = Float.parseFloat(value);
        } else if (type.equals(Double.class.getName())) {
            result = Double.parseDouble(value);
        } else {
            result = value;
        }
        return result;
    }
}
