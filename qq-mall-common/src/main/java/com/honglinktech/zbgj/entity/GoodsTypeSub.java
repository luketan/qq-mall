/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import com.alibaba.fastjson.JSON;
import com.honglinktech.zbgj.bean.GoodsPhoneBean;
import com.honglinktech.zbgj.bean.GoodsTypeSubBean;
import org.springframework.util.StringUtils;

import java.util.Date;

public class GoodsTypeSub {
    /**
     * 
     */
    private Integer id;

    /**
     * 类型名称
     */
    private String name;
    /**
     *
     */
    private String img;

    /**
     *
     */
    private Integer sort;
    /**
     *
     */
    private Boolean sale;
    /**
     *
     */
    private Boolean rec;

    /**
     * 商品类型
     */
    private Integer goodsType;

    /**
     * 参数配置
     */
    private String parameter;

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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getSale() {
        return sale;
    }

    public void setSale(Boolean sale) {
        this.sale = sale;
    }

    public Boolean getRec() {
        return rec;
    }

    public void setRec(Boolean rec) {
        this.rec = rec;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public GoodsTypeSub(){

    }
    public GoodsTypeSub(GoodsTypeSubBean goodsTypeSubBean){
        this.goodsType = goodsTypeSubBean.getGoodsType();
        this.id = goodsTypeSubBean.getId();
        this.img = goodsTypeSubBean.getImg();
        this.name = goodsTypeSubBean.getName();
        this.rec = goodsTypeSubBean.getRec();
        this.sale = goodsTypeSubBean.getSale();
        this.sort = goodsTypeSubBean.getSort();
        if(goodsTypeSubBean.getGoodsPhone() != null){
            this.parameter = JSON.toJSONString(goodsTypeSubBean.getGoodsPhone());
        }
    }
    public GoodsTypeSubBean toBean() {
        GoodsTypeSubBean goodsTypeSubBean = new GoodsTypeSubBean();
        goodsTypeSubBean.setName(this.name);
        goodsTypeSubBean.setId(this.id);
        goodsTypeSubBean.setCreateTime(this.createTime);
        goodsTypeSubBean.setGoodsType(this.goodsType);
        goodsTypeSubBean.setImg(this.img);
        goodsTypeSubBean.setRec(this.rec);
        goodsTypeSubBean.setSale(this.sale);
        goodsTypeSubBean.setSort(this.sort);
        if(!StringUtils.isEmpty(this.parameter)){
            goodsTypeSubBean.setGoodsPhone(JSON.parseObject(this.parameter, GoodsPhoneBean.class));
        }
        return goodsTypeSubBean;
    }
}