/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.vo;

import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.bean.FormatBean;

import java.math.BigDecimal;
import java.util.List;

public class OrderItemVO {
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

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public List<FormatBean> getFormats() {
        return formats;
    }

    public List<ActivityBean> getActivitys() {
        return activitys;
    }

    public Integer getNum() {
        return num;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public String getRemark() {
        return remark;
    }

    public Integer getDisIs() {
        return disIs;
    }
}