package com.honglinktech.zbgj.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dayong on 2016/10/18.
 */
public final class DateUtil {
    /**
     * The Sdf.
     */
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 计算两个时间相差的天数
     *
     * @param nextDay 今天往后的一个时间
     * @param today   今天
     * @return 天数
     */
    public static long calculateDays(Date nextDay, Date today) {
        return (nextDay.getTime() - today.getTime()) / (Constant.MILLISECOND_OF_SECOND * Constant.SECOND_OF_MINUTE * Constant.MINUTE_OF_HOUR * Constant.HOUR_OF_DAY);
    }

    /**
     * 转换日期
     *
     * @param date 日期（字符串）
     * @param flag true为00:00:00， false为23:59:59
     * @return 转换结果
     */
    public static Date parseDate(String date, boolean flag) {
        try {
            if (date != null && !date.isEmpty()) {
                if (flag) {
                    return DATE_FORMAT.parse(date + " 00:00:00");
                } else {
                    return DATE_FORMAT.parse(date + " 23:59:59");
                }
            }
        } catch (ParseException e) {
        }
        return null;
    }

    private DateUtil() {
    }
}
