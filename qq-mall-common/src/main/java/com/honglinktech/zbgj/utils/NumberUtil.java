package com.honglinktech.zbgj.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by Dayong on 16/3/24.
 */
public final class NumberUtil {

    private NumberUtil() {
    }

    /**
     * Double to string .
     *
     * @param value the value
     * @return the string
     */
    public static String double2String(double value) {
        DecimalFormat format = new DecimalFormat("###,##0.00");
        format.setRoundingMode(RoundingMode.DOWN);
        return format.format(value);
    }
}
