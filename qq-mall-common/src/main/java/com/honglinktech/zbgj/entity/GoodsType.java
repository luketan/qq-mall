/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.bean.GoodsTypeBean;
import com.honglinktech.zbgj.vo.GoodsTypeVO;

import java.util.Date;

public class GoodsType {
    /**
     * 
     */
    private Integer id;

    /**
     * 类别名称
     */
    private String name;

    /**
     * 类型图标
     */
    private String ico;

    /**
     * 类型图片
     */
    private String img;
    /**
     *
     */
    private Boolean sale;
    /**
     *
     */
    private Boolean rec;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 
     */
    private String summary;

    /**
     * 
     */
    private String search;

    /**
     * 状态(0正常，1删除)
     */
    private Integer deleteFlag;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Date createTime;

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

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico == null ? null : ico.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search == null ? null : search.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
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

    public GoodsTypeVO toVO(){
        GoodsTypeVO goodsTypeVO = new GoodsTypeVO();
        goodsTypeVO.setId(this.id);
        goodsTypeVO.setName(this.name);
        goodsTypeVO.setIco(this.ico);
        goodsTypeVO.setImg(this.img);
        goodsTypeVO.setSearch(this.search);
        return goodsTypeVO;
    }

    public GoodsTypeBean toBean(){
        GoodsTypeBean goodsTypeBean = new GoodsTypeBean();
        goodsTypeBean.setId(this.id);
        goodsTypeBean.setName(this.name);
        goodsTypeBean.setIco(this.ico);
        goodsTypeBean.setImg(this.img);
        goodsTypeBean.setSearch(this.search);
        goodsTypeBean.setSummary(this.summary);
        goodsTypeBean.setSale(this.sale);
        goodsTypeBean.setRec(this.rec);
        return goodsTypeBean;
    }

}