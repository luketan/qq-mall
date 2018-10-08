package com.honglinktech.zbgj.enums;

/**
 * 订单状态枚举类
 */
public enum OrderPayStatusEnum {
	waitPayment(1, "待支付", "您的订单已提交成功，请尽快支付，我们将尽快为你发货~"),
    Success(2, "支付成功", "请你稍等片刻，我们正在快马加鞭的为你配置商品，立即为你发货~"),
    Fail(3, "支付失败", "");


    private int code;
    private String name;
    private String desc;

    OrderPayStatusEnum(int code, String name, String desc) {
        this.code = code;
        this.name = name;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
