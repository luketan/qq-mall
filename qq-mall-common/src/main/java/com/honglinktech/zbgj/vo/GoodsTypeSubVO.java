/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.vo;

import java.util.Date;

public class GoodsTypeSubVO {
    /**
     * 
     */
    private Integer id;

    /**
     * 类型名称
     */
    private String name;

    /**
     * 商品类型
     */
    private Integer goodsType;

    /**
     * 类型名称
     */
    private String typeName;

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
}