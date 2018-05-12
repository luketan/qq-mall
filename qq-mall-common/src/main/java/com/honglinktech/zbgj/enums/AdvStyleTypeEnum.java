
package com.honglinktech.zbgj.enums;

import java.io.Serializable;

/**
 * Created by Dayong on 16/9/18.
 */
public enum AdvStyleTypeEnum implements Serializable {
    /**
     * 首页
     */
    Home("首页"),
    /**
     * 单品
     */
    Search("搜索");

    /**
     * 类型的描述
     */
    private String name;

    AdvStyleTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
