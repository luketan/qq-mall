/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.bean.FormatBean;
import com.honglinktech.zbgj.bean.FormatSubBean;
import com.honglinktech.zbgj.bean.OrderItemBean;
import com.honglinktech.zbgj.vo.ActivityVO;
import com.honglinktech.zbgj.vo.FormatSubVO;
import com.honglinktech.zbgj.vo.FormatVO;
import com.honglinktech.zbgj.vo.OrderItemVO;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItem {
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
     * 商品规格名称
     */
    private String formats;

    /**
     * 
     */
    private String activitys;

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
    private BigDecimal markPrice;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否已经评论(0未评论,1已评论)
     */
    private Integer disIs;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

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
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg == null ? null : goodsImg.trim();
    }

    public String getFormats() {
        return formats;
    }

    public void setFormats(String formats) {
        this.formats = formats == null ? null : formats.trim();
    }

    public String getActivitys() {
        return activitys;
    }

    public void setActivitys(String activitys) {
        this.activitys = activitys == null ? null : activitys.trim();
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

    public BigDecimal getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(BigDecimal markPrice) {
        this.markPrice = markPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getDisIs() {
        return disIs;
    }

    public void setDisIs(Integer disIs) {
        this.disIs = disIs;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public OrderItem(){}

    public OrderItem(OrderItemBean orderItemBean){
        this.id = orderItemBean.getId();
        this.orderId = orderItemBean.getOrderId();
        this.goodsId = orderItemBean.getGoodsId();
        this.goodsName = orderItemBean.getGoodsName();
        this.goodsImg = orderItemBean.getGoodsImg();
        this.num = orderItemBean.getNum();
        this.price = orderItemBean.getPrice();
        this.markPrice = orderItemBean.getMarkPrice();
        this.remark = orderItemBean.getRemark();
        this.disIs = orderItemBean.getDisIs();
        if(orderItemBean.getActivitys()!=null){
            this.formats = JSON.toJSONString(orderItemBean.getActivitys());
        }
        if(orderItemBean.getFormats()!=null){
            this.activitys = JSON.toJSONString(orderItemBean.getFormats());
        }

    }

    public OrderItemBean toBean() {
        OrderItemBean orderItemBean = new OrderItemBean();
        orderItemBean.setId(this.id);
        orderItemBean.setGoodsId(this.goodsId);
        orderItemBean.setDisIs(this.disIs);
        orderItemBean.setGoodsName(this.goodsName);
        orderItemBean.setGoodsImg(this.goodsImg);
        orderItemBean.setPrice(this.price);
        orderItemBean.setMarkPrice(this.markPrice);
        orderItemBean.setNum(this.num);
        orderItemBean.setRemark(this.remark);

        try {
            if(!StringUtils.isEmpty(this.activitys)){
                orderItemBean.setActivitys(JSON.parseArray(this.activitys, ActivityBean.class));
            }
            if(!StringUtils.isEmpty(this.formats)){
                orderItemBean.setFormats(JSON.parseArray(this.formats, FormatSubBean.class));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return orderItemBean;
    }

    public OrderItemVO toVO() {
        OrderItemVO orderItemVO = new OrderItemVO();
        orderItemVO.setId(this.id);
        orderItemVO.setGoodsId(this.goodsId);
        orderItemVO.setDisIs(this.disIs);
        orderItemVO.setGoodsName(this.goodsName);
        orderItemVO.setGoodsImg(this.goodsImg);
        orderItemVO.setPrice(this.price);
        orderItemVO.setMarkPrice(this.markPrice);
        orderItemVO.setNum(this.num);
        orderItemVO.setRemark(this.remark);
        try {
            if(!StringUtils.isEmpty(this.activitys)){
                orderItemVO.setActivitys(JSON.parseArray(this.activitys, ActivityVO.class));
            }
            if(!StringUtils.isEmpty(this.formats)){
                orderItemVO.setFormats(JSON.parseArray(this.formats, FormatSubVO.class));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        return orderItemVO;
    }
    public static void main(String[] str){

    }
}