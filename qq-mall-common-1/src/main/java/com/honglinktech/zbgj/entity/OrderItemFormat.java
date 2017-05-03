/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

public class OrderItemFormat {
    /**
     * 订单项Id
     */
    private Integer id;

    /**
     * 主订单ID
     */
    private Integer orderItemId;

    /**
     * 规格子类ID
     */
    private Integer formatSubId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getFormatSubId() {
        return formatSubId;
    }

    public void setFormatSubId(Integer formatSubId) {
        this.formatSubId = formatSubId;
    }
}