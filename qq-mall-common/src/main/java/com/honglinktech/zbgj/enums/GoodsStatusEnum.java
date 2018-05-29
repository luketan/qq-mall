package com.honglinktech.zbgj.enums;

/**
 * Created by on 16/2/23.
 */
public enum GoodsStatusEnum {
    //商品状态（1正常,2已售完，3已下架,4删除，5待审核）
    Normal(1, "正常"),
    SoldOut(2, "已售完"),
    DropOff(3, "已下架"),
    //Delete(4, "删除"),
    Pending(5, "待审核")
    ;

    private int code;
    private String name;

    GoodsStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
