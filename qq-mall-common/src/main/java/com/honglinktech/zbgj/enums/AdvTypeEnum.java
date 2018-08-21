package com.honglinktech.zbgj.enums;

import java.io.Serializable;

/**
 * Created by Dayong on 16/9/18.
 */
public enum AdvTypeEnum implements Serializable {
    /**
     * 网页
     */
    Web("网页"),
    Type("类型"),
    TypeSub("子类型"),
    /**
     *
     */
    Other("其他");

    /**
     * 类型的描述
     */
    private String name;

    AdvTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
