package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.vo.AdvVO;

import java.util.Date;

/**
 * 广告图
 */
public class Adv{

    private Integer id;

    private String image;

    private String url;

    private String title;

    private String type;

    private String styleType;

    private Integer sort;

    private Date updateDate;

    private Integer createUserId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStyleType() {
        return styleType;
    }

    public void setStyleType(String styleType) {
        this.styleType = styleType;
    }

    public AdvVO toVO() {
        AdvVO vo = new AdvVO();
        vo.setImage(this.image);
        vo.setTitle(this.title);
        vo.setUrl(this.url);
        vo.setType(this.type.toString());
        vo.setStyleType(this.styleType);
        return vo;
    }

    public Adv() {
    }



}
