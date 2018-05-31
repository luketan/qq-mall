/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import java.util.Date;

public class GoodsFormat{
    /**
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 规格ID
     */
    private Integer formatId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getFormatId() {
        return formatId;
    }

    public void setFormatId(Integer formatId) {
        this.formatId = formatId;
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
}