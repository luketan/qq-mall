/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.bean;

import java.util.Date;

public class GoodsTypeSubBean {
    /**
     *
     */
    private Integer id;

    /**
     * 类型名称
     */
    private String name;

    private String img;
    private Boolean rec;
    private Boolean sale;
    private Integer sort;

    /**
     * 商品类型
     */
    private Integer goodsType;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 参数配置
     */
    private GoodsPhoneBean goodsPhone;

    /**
     * 删除标志
     */
    private Integer deleteFlag;

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

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Boolean getRec() {
        return rec;
    }

    public void setRec(Boolean rec) {
        this.rec = rec;
    }

    public Boolean getSale() {
        return sale;
    }

    public void setSale(Boolean sale) {
        this.sale = sale;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public GoodsPhoneBean getGoodsPhone() {
        return goodsPhone;
    }

    public void setGoodsPhone(GoodsPhoneBean goodsPhone) {
        this.goodsPhone = goodsPhone;
    }
}