/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.vo;

import com.honglinktech.zbgj.entity.GoodsTypeSub;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class GoodsTypeVO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -2616722747811526053L;
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
    private String search;

    /**
     *
     */
    private List<GoodsTypeSubVO> goodsTypeSubList;


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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search == null ? null : search.trim();
    }

    public List<GoodsTypeSubVO> getGoodsTypeSubList() {
        return goodsTypeSubList;
    }

    public void setGoodsTypeSubList(List<GoodsTypeSubVO> goodsTypeSubList) {
        this.goodsTypeSubList = goodsTypeSubList;
    }
}