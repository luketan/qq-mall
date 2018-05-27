package com.honglinktech.zbgj.enums;

import java.io.Serializable;

/**
 * Created by Dayong on 16/9/18.
 */
public enum ActivityTypeEnum implements Serializable {
    /**
     * 系列
     */
    DZ(1, "打折"),
    /**
     * 单品
     */
    BY(2, "包邮"),
    /**
     * 网页
     */
    ZS(3, "赠送"),
    /**
     * 分组
     */
    MJ(4, "满减");
    /**
     * 类型的描述
     */
    private int code;

    /**
     * 类型的描述
     */
    private String name;

    ActivityTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
