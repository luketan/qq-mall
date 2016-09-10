package com.honglinktech.zbgj.enums;

/**
 * 支付类型
 * Created by Dayong on 16/2/23.
 */
public enum PaymentTypeEnum {
    Offline(1, "线下支付"), Alipay(2, "支付宝"), OrangeBank(3, "平安橙e付");

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
