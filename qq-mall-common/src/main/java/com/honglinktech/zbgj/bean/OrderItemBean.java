/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderItemBean {
    /**
     * 订单项Id
     */
    private Integer id;

    /**
     * 主订单ID
     */
    private Integer orderId;

    /**
     * 产品单品ID
     */
    private Integer goodsId;

    /**
     * 单品名称
     */
    private String goodsName;

    /**
     *
     */
    private String goodsImg;

    /**
     * 购买数量
     */
    private Integer num;

    /**
     * 成交价格
     */
    private BigDecimal price;

    /**
     * 市场价格
     */
    private BigDecimal marketPrice;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否已经评论(0未评论,1已评论)
     */
    private Integer disIs;

    /**
     * 商品规格名称
     */
    private List<FormatBean> formats;

    /**
     *
     */
    private List<ActivityBean> activitys;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDisIs() {
        return disIs;
    }

    public void setDisIs(Integer disIs) {
        this.disIs = disIs;
    }

    public List<FormatBean> getFormats() {
        return formats;
    }

    public void setFormats(List<FormatBean> formats) {
        this.formats = formats;
    }

    public List<ActivityBean> getActivitys() {
        return activitys;
    }

    public void setActivitys(List<ActivityBean> activitys) {
        this.activitys = activitys;
    }
}