package com.honglinktech.zbgj.admin.bean;

/**
 * Created by Dayong on 16/3/9.
 */
public class AuditingBean {
    private int orderId;
    private float goldWeight;
    private float totalFee;
    private int type;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getGoldWeight() {
        return goldWeight;
    }

    public void setGoldWeight(float goldWeight) {
        this.goldWeight = goldWeight;
    }

    public float getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(float totalFee) {
        this.totalFee = totalFee;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
