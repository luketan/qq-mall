package com.honglinktech.zbgj.enums;

/**
 * 支付类型
 * Created by Dayong on 16/2/23.
 */
public enum PaymentTypeEnum {
    Weixin(1, "微信"),
    Alipay(2, "支付宝"),
    Balance(3, "余额");

    private int code;
    private String name;

    PaymentTypeEnum(int code, String name) {
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
