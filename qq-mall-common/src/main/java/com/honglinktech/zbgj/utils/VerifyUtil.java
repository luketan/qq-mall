package com.honglinktech.zbgj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * Created by Dayong on 2015/12/30.
 */
public final class VerifyUtil {
    /**
     *
     */
    private static final int TEN = 10;
    /**
     *
     */
    private static final int THREE = 3;

    private VerifyUtil() {
    }

    /**
     * 判断字符串是否为空或者空字符串
     *
     * @param str 要判断的字符
     * @return 是否为空 boolean
     */
    public static boolean equalsString(String str) {
        if (str != null && !str.trim().equals("")) {
            return true;
        }
        return false;
    }

    /**
     * 验证时候有此参数
     *
     * @param map       要检查的Map
     * @param paramName 参数名称
     * @return 检查结果 boolean
     */
    public static boolean equalsMap(Map map, String paramName) {
        if (map.containsKey(paramName) && !map.get(paramName).equals("")) {
            return true;
        }
        return false;
    }

    /**
     * 匹配指定值
     *
     * @param map       要检查的Map
     * @param paramName 参数名称
     * @param mapParam  mapParam
     * @return 检查结果 boolean
     */
    public static boolean equalsMap(Map map, String paramName, Map<String, Boolean> mapParam) {
        if (map.containsKey(paramName) && !map.get(paramName).equals("")) {
            if (mapParam.containsKey(map.get(paramName).toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 转换时间
     *
     * @param param  字符时间
     * @param format 格式（yyyy-MM-dd HH:mm:ss）
     * @return date
     * @throws ParseException 转换异常
     */
    public static Date convertDate(String param, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(param);
    }


    /**
     * Gen random code string.
     *
     * @param digit the digit
     * @return the string
     */
    public static String genRandomCode(int digit) {
        if (digit < THREE || digit > TEN) {
            return null;
        }
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < digit + 1; ++i) {
            sb.append(random.nextInt(TEN));
        }
        return sb.toString();
    }
}
