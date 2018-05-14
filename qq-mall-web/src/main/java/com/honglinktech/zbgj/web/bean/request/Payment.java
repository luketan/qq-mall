package com.honglinktech.zbgj.web.bean.request;

/**
 * Created by Dayong on 16/3/8.
 */
public class Payment {
    private String id;//订单ID
    private int type;//支付类型
    private String code;//短信验证码(线下支付使用)
    private String payPsw;//支付密码(线下支付使用)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPayPsw() {
        return payPsw;
    }

    public void setPayPsw(String payPsw) {
        this.payPsw = payPsw;
    }
}
