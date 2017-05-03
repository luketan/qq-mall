package com.honglinktech.zbgj.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统设置缓存类,提供给Web页面使用
 * Created by Dayong on 16/2/22.
 */
public class SystemArgsCache {
    private static Map<String, String> map = new HashMap<String, String>();

    /**
     * 设置参数的值
     *
     * @param key
     * @param value
     */
    public static void put(String key, String value) {
        map.put(key, value);
    }


    /**
     * 获取参数的值
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        return map.get(key);
    }

    /**
     * 获取所有参数
     *
     * @return
     */
    public static Map<String, String> getMap() {
        return map;
    }
}
