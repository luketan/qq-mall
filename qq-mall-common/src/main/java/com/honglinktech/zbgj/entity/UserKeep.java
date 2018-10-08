/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import java.math.BigDecimal;
import java.util.Date;

public class UserKeep {
    /**
     * ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 收藏ID(商品，帖子)
     */
    private Integer objId;

    /**
     * 类型ID
     */
    private Integer objType;

    /**
     * 类型名称
     */
    private String objTypeName;

    /**
     * 类型(1商品，2贴子)
     */
    private Integer type;

    /**
     * 名称
     */
    private String name;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 市场价
     */
    private BigDecimal markPrice;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    private boolean status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    public Integer getObjType() {
        return objType;
    }

    public void setObjType(Integer objType) {
        this.objType = objType;
    }

    public String getObjTypeName() {
        return objTypeName;
    }

    public void setObjTypeName(String objTypeName) {
        this.objTypeName = objTypeName == null ? null : objTypeName.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public BigDecimal getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(BigDecimal markPrice) {
        this.markPrice = markPrice;
    }
}