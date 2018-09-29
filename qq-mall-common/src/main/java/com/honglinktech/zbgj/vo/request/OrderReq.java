package com.honglinktech.zbgj.vo.request;

import javax.lang.model.element.NestingKind;
import java.io.Serializable;
import java.util.List;

/**
 */
public class OrderReq implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2978980691877697087L;

    /**
     * 直接购买商品Id
     */
    private int goodsId;
    /**
     * 商品规格选择
     */
    private List<Integer> formatSubIdList;
    /**
     *
     */
    private int num;
    /**
     * 购物车Id
     */
    private List<Integer> shoppingCartIds;

    /**
     * 优惠券ID
     */
    private int couponUserId;

    /**
     * orderPayType: 1立即下单,0购物车下单
     */
    private int orderPayType;

    /**
     * 地址Id
     */
    private int addressId;

    /**
     * 地址
     */
    private String address;
    /**
     *
     */
    private String userName;
    /**
     *
     */
    private String phone;
    /**
     *
     */
    private String paymentCode;

    /**
     * 来源
     */
    private String form;

    /**
     *
     */
    private String remark;

    private String openId;
    private String requestIp;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Integer> getShoppingCartIds() {
        return shoppingCartIds;
    }

    public void setShoppingCartIds(List<Integer> shoppingCartIds) {
        this.shoppingCartIds = shoppingCartIds;
    }

    public int getOrderPayType() {
        return orderPayType;
    }

    public void setOrderPayType(int orderPayType) {
        this.orderPayType = orderPayType;
    }

    public List<Integer> getFormatSubIdList() {
        return formatSubIdList;
    }

    public void setFormatSubIdList(List<Integer> formatSubIdList) {
        this.formatSubIdList = formatSubIdList;
    }

    public int getCouponUserId() {
        return couponUserId;
    }

    public void setCouponUserId(int couponUserId) {
        this.couponUserId = couponUserId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }
}
