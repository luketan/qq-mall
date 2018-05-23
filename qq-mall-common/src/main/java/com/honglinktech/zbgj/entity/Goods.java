/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
    /**
     * 
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 子标题（提醒）
     */
    private String subName;

    /**
     * 售出数量
     */
    private Integer salesNum;

    /**
     * 库存数量
     */
    private Integer keepNum;

    /**
     * 市场价
     */
    private BigDecimal markPrice;

    /**
     * 原价
     */
    private BigDecimal formerPrice;

    /**
     * 现在价格
     */
    private BigDecimal price;

    /**
     * 评论数量
     */
    private Integer discussNum;
    /**
     * 是否热卖
     */
    private Integer hotIs;

    /**
     * 是否是精品
     */
    private Integer giftsIs;

    /**
     * 品牌ID
     */
    private Integer brandId;

    /**
     * 类别ID
     */
    private Integer typeId;

    /**
     * 子类别(款式)ID
     */
    private Integer typeSubId;

    /**
     * 收藏数量
     */
    private Integer collectNum;

    /**
     * 商品状态（1正常,2已售完，3已下架,4删除，5待审核）
     */
    private Integer status;

    /**
     * 主图路径
     */
    private String imgUrl;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 商品详情
     */
    private String detail;

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

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName == null ? null : subName.trim();
    }

    public Integer getSalesNum() {
        return salesNum;
    }

    public void setSalesNum(Integer salesNum) {
        this.salesNum = salesNum;
    }

    public Integer getKeepNum() {
        return keepNum;
    }

    public void setKeepNum(Integer keepNum) {
        this.keepNum = keepNum;
    }

    public BigDecimal getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(BigDecimal markPrice) {
        this.markPrice = markPrice;
    }

    public BigDecimal getFormerPrice() {
        return formerPrice;
    }

    public void setFormerPrice(BigDecimal formerPrice) {
        this.formerPrice = formerPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getDiscussNum() {
        return discussNum;
    }

    public void setDiscussNum(Integer discussNum) {
        this.discussNum = discussNum;
    }

    public Integer getHotIs() {
        return hotIs;
    }

    public void setHotIs(Integer hotIs) {
        this.hotIs = hotIs;
    }

    public Integer getGiftsIs() {
        return giftsIs;
    }

    public void setGiftsIs(Integer giftsIs) {
        this.giftsIs = giftsIs;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeSubId() {
        return typeSubId;
    }

    public void setTypeSubId(Integer typeSubId) {
        this.typeSubId = typeSubId;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}