package com.honglinktech.zbgj.enums;

import java.io.Serializable;

/**
 * Created by Dayong on 16/9/18.
 */
public enum AdvTypeEnum implements Serializable {
    /**
     * 系列
     */
    Series("系列"),
    /**
     * 单品
     */
    Item("单品"),
    /**
     * 网页
     */
    Web("网页"),
    /**
     * 分组
     */
    Grouped("分组"),
    /**
     * 名师在线
     */
    Trainer("名师在线"),
    /**
     * ar红包
     */
    Ar("ar红包"),
    /**
     * 地图
     */
    Map("地图"),
    /**
     * 云展厅活动
     */
    Promotion("云展厅活动"),
    /**
     * 钱包合作伙伴
     */
    PartnerWallet("钱包合作伙伴"),
    /**
     * 地图
     */
    MapAndActivity("地图和活动"),
    /**
     *
     */
    GameTiger("老虎机"),
    /**
     *
     */
    Partner("合作伙伴");

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
