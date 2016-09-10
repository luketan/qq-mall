package com.honglinktech.zbgj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2015/12/30.
 */
public class VerifyUtil {


    /**
     * 判断字符串是否为空或者空字符串
     *
     * @param str
     * @return
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
     * @param map
     * @param paramName
     * @return
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
     * @param map
     * @param paramName
     * @param mapParam
     * @return
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
     * @param param
     * @param format yyyy-MM-dd HH:mm:ss
     * @return
     * @throws ParseException
     */
    public static Date convertDate(String param, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(param);
    }


    public static String genRandomSmscode(int digit) {
        if (digit < 3 || digit > 10)
            return null;

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < digit + 1; ++i) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }
}
