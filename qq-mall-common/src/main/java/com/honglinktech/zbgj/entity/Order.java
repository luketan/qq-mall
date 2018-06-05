/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.bean.OrderBean;
import com.honglinktech.zbgj.vo.OrderVO;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    /**
     * 
     */
    private Integer id;

    /**
     * 订单编号
     */
    private String orderCode;

    /**
     * 
     */
    private Integer userId;

    /**
     * 商品总价
     */
    private BigDecimal money;

    /**
     * 订单总价
     */
    private BigDecimal totalMoney;

    /**
     * 支付方式（1是支付宝支付，2是微信支付,3货到付款）
     */
    private Integer paymentId;

    /**
     * 
     */
    private String paymentName;

    /**
     * 订单状态(0未支付,1支付成功,2支付未成功)
     */
    private Integer payStatus;

    /**
     * 订单状态(1待付款，2待发货，3运送中，4已完成)
     */
    private Integer status;

    /**
     * 快递公司ID
     */
    private Integer postId;

    /**
     * 快递公司名称
     */
    private String postName;

    /**
     * 快递单号
     */
    private String postCode;

    /**
     * 邮费
     */
    private BigDecimal postMoney;

    /**
     * 运费减免
     */
    private BigDecimal lostPostMoney;

    /**
     * 优惠金额
     */
    private BigDecimal lostMoney;

    /**
     * 是否需要发票
     */
    private Integer invoiceIs;

    /**
     * 发票抬头
     */
    private String invoiceHead;

    /**
     * 
     */
    private Integer addressId;

    /**
     * 地址详细信息
     */
    private String address;

    /**
     * 邮编
     */
    private String zipcode;

    /**
     * 优惠券id
     */
    private Integer couponId;

    /**
     * 优惠券信息
     */
    private String coupon;

    /**
     * 消息推送记录(0为推送，1已推送)
     */
    private Integer push;

    /**
     * 订单状态是否已读(0未读，1已读)
     */
    private Integer readIs;

    /**
     * 删除标志
     */
    private Integer deleteFlag;

    /**
     * 订单来源(1直接购买,2社区赠送,3一元购)
     */
    private Integer form;

    /**
     * 备注
     */
    private String remark;

    /**
     * 订单说明
     */
    private String explain;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 活动l列表
     */
    private String activitys;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName == null ? null : paymentName.trim();
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public BigDecimal getPostMoney() {
        return postMoney;
    }

    public void setPostMoney(BigDecimal postMoney) {
        this.postMoney = postMoney;
    }

    public BigDecimal getLostPostMoney() {
        return lostPostMoney;
    }

    public void setLostPostMoney(BigDecimal lostPostMoney) {
        this.lostPostMoney = lostPostMoney;
    }

    public BigDecimal getLostMoney() {
        return lostMoney;
    }

    public void setLostMoney(BigDecimal lostMoney) {
        this.lostMoney = lostMoney;
    }

    public Integer getInvoiceIs() {
        return invoiceIs;
    }

    public void setInvoiceIs(Integer invoiceIs) {
        this.invoiceIs = invoiceIs;
    }

    public String getInvoiceHead() {
        return invoiceHead;
    }

    public void setInvoiceHead(String invoiceHead) {
        this.invoiceHead = invoiceHead == null ? null : invoiceHead.trim();
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon == null ? null : coupon.trim();
    }

    public Integer getPush() {
        return push;
    }

    public void setPush(Integer push) {
        this.push = push;
    }

    public Integer getReadIs() {
        return readIs;
    }

    public void setReadIs(Integer readIs) {
        this.readIs = readIs;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getForm() {
        return form;
    }

    public void setForm(Integer form) {
        this.form = form;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain == null ? null : explain.trim();
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

    public String getActivitys() {
        return activitys;
    }

    public void setActivitys(String activitys) {
        this.activitys = activitys == null ? null : activitys.trim();
    }

    public Order(){}
    public Order(OrderBean orderBean){
        if(orderBean!=null){
            this.id = orderBean.getId();
            this.orderCode = orderBean.getOrderCode();
            this.userId = orderBean.getUserId();
            this.addressId = orderBean.getAddressId();
            this.money = orderBean.getMoney();
            this.totalMoney = orderBean.getTotalMoney();
            this.paymentId = orderBean.getPaymentId();
            this.paymentName = orderBean.getPaymentName();
            this.payStatus = orderBean.getPayStatus();
            this.status = orderBean.getStatus();
            this.postId = orderBean.getPostId();
            this.postName = orderBean.getPostName();
            this.postCode = orderBean.getPostCode();
            this.postMoney = orderBean.getPostMoney();
            this.lostPostMoney = orderBean.getLostPostMoney();
            this.lostMoney  = orderBean.getLostMoney();
            this.invoiceIs = orderBean.getInvoiceIs();
            this.invoiceHead = orderBean.getInvoiceHead();
            this.push = orderBean.getPush();
            this.readIs = orderBean.getReadIs();
            this.deleteFlag = orderBean.getDeleteFlag();
            this.form = orderBean.getForm();
            this.remark = orderBean.getRemark();
            this.createTime = orderBean.getCreateTime();
        }
    }

    public OrderVO toVO(){
        OrderVO orderVO = new OrderVO();
        orderVO.setId(this.getId());
        orderVO.setOrderCode(this.getOrderCode());
        orderVO.setUserId(this.getUserId());
        orderVO.setAddressId(this.getAddressId());
        orderVO.setMoney(this.getMoney());
        orderVO.setTotalMoney(this.getTotalMoney());
        orderVO.setPaymentId(this.getPaymentId());
        orderVO.setPaymentName(this.getPaymentName());
        orderVO.setPayStatus(this.getPayStatus());
        orderVO.setPayStatus(this.getStatus());
        orderVO.setPostId(this.getPostId());
        orderVO.setPostName(this.getPostName());
        orderVO.setPostCode(this.getPostCode());
        orderVO.setPostMoney(this.getPostMoney());
        orderVO.setLostPostMoney(this.getLostPostMoney());
        orderVO.setLostMoney(this.getLostMoney());
        orderVO.setInvoiceIs(this.getInvoiceIs());
        orderVO.setInvoiceHead(this.getInvoiceHead());
        orderVO.setPush(this.getPush());
        orderVO.setReadIs(this.getReadIs());
        orderVO.setForm(this.getForm());
        orderVO.setRemark(this.getRemark());
        orderVO.setCreateTime(this.getCreateTime());
        return orderVO;
    }

    public OrderBean toBean(){
        OrderBean orderVO = new OrderBean();
        orderVO.setId(this.getId());
        orderVO.setOrderCode(this.getOrderCode());
        orderVO.setUserId(this.getUserId());
        orderVO.setAddressId(this.getAddressId());
        orderVO.setMoney(this.getMoney());
        orderVO.setTotalMoney(this.getTotalMoney());
        orderVO.setPaymentId(this.getPaymentId());
        orderVO.setPaymentName(this.getPaymentName());
        orderVO.setPayStatus(this.getPayStatus());
        orderVO.setPayStatus(this.getStatus());
        orderVO.setPostId(this.getPostId());
        orderVO.setPostName(this.getPostName());
        orderVO.setPostCode(this.getPostCode());
        orderVO.setPostMoney(this.getPostMoney());
        orderVO.setLostPostMoney(this.getLostPostMoney());
        orderVO.setLostMoney(this.getLostMoney());
        orderVO.setInvoiceIs(this.getInvoiceIs());
        orderVO.setInvoiceHead(this.getInvoiceHead());
        orderVO.setPush(this.getPush());
        orderVO.setReadIs(this.getReadIs());
        orderVO.setForm(this.getForm());
        orderVO.setRemark(this.getRemark());
        orderVO.setCreateTime(this.getCreateTime());
        return orderVO;
    }


}