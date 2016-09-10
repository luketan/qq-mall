package com.honglinktech.zbgj.admin.bean;

import java.util.List;

/**
 * Created by Dayong on 16/3/13.
 */
public class SubmitDelivery {
    private String orderId;
    private int deliveryId;
    private String deliveryNo;
    private List<Integer> ids;
    private List<Integer> vals;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<Integer> getVals() {
        return vals;
    }

    public void setVals(List<Integer> vals) {
        this.vals = vals;
    }
}
