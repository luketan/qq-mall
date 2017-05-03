/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

public class ShoppingCartFormat {
    /**
     * 
     */
    private Integer id;

    /**
     * 购物车ID
     */
    private Integer shoppingCartId;

    /**
     * 规格子类ID
     */
    private Integer formatSubId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Integer shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Integer getFormatSubId() {
        return formatSubId;
    }

    public void setFormatSubId(Integer formatSubId) {
        this.formatSubId = formatSubId;
    }
}