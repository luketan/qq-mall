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
    private String content;

    GoodsStatusEnum(int code, String content) {
        this.code = code;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
