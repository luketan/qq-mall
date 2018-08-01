/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.bean.CouponBean;
import com.honglinktech.zbgj.vo.CouponVO;

import java.util.Date;

public class Coupon {
    /**
     * ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 条件文本
     */
    private String condition;

    /**
     * 详情
     */
    private String detail;

    /**
     * 条件商品类型ID
     */
    private Integer goodsType;

    /**
     * 条件满多少可以用
     */
    private Integer max;

    /**
     * 
     */
    private Integer value;

    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition == null ? null : condition.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public CouponBean toBean(){
        CouponBean couponBean = new CouponBean();
        couponBean.setGoodsType(goodsType);
        couponBean.setId(id);
        couponBean.setMax(max);
        couponBean.setName(name);
        couponBean.setValue(value);
        return couponBean;
    }

    public CouponVO toVO(){
        CouponVO couponVO = new CouponVO();
        couponVO.setGoodsType(goodsType);
        couponVO.setId(id);
        couponVO.setMax(max);
        couponVO.setName(name);
        couponVO.setValue(value);
        return couponVO;
    }
}