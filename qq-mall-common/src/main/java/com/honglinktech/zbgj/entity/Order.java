/**
 * @author ws
 * 2017-04-20 22:04:20
 */
package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.bean.OrderBean;
import com.honglinktech.zbgj.vo.OrderVO;

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
     *
     */
    private String payReason;

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
     * 商品总价
     */
    private BigDecimal money;

    /**
     * 订单总价
     */
    private BigDecimal totalMoney;

    /**
     * 邮费
     */
    private BigDecimal postMoney;

    /**
     * 活动减免减免
     */
    private BigDecimal lostActivityMoney;

    /**
     * 优惠券减免
     */
    private BigDecimal lostCouponMoney;

    /**
     * 其他优惠金额，积分，红包
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
     * 用户名
     */
    private String userName;
    /**
     * 用户电话
     */
    private String userPhone;

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
     * 消息推送记录(0为推送，1已推送)
     */
    private Integer push;

    /**
     * 订单状态是否已读(0未读，1已读)
     */
    private Integer read;

    /**
     * 订单来源(1直接购买,2社区赠送,3一元购)
     */
    private String form;

    /**
     * 用户备注
     */
    private String remark;

    /**
     * 后台说明
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
        this.orderCode = orderCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        this.paymentName = paymentName;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayReason() {
        return payReason;
    }

    public void setPayReason(String payReason) {
        this.payReason = payReason;
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
        this.postName = postName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
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

    public BigDecimal getPostMoney() {
        return postMoney;
    }

    public void setPostMoney(BigDecimal postMoney) {
        this.postMoney = postMoney;
    }

    public BigDecimal getLostActivityMoney() {
        return lostActivityMoney;
    }

    public void setLostActivityMoney(BigDecimal lostActivityMoney) {
        this.lostActivityMoney = lostActivityMoney;
    }

    public BigDecimal getLostCouponMoney() {
        return lostCouponMoney;
    }

    public void setLostCouponMoney(BigDecimal lostCouponMoney) {
        this.lostCouponMoney = lostCouponMoney;
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
        this.invoiceHead = invoiceHead;
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
        this.address = address;
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

    public Integer getPush() {
        return push;
    }

    public void setPush(Integer push) {
        this.push = push;
    }

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Order(){}
    public Order(OrderBean orderBean){
        if(orderBean!=null){
            this.id = orderBean.getId();
            this.orderCode = orderBean.getOrderCode();
            this.userId = orderBean.getUserId();
            this.paymentId = orderBean.getPaymentId();
            this.paymentName = orderBean.getPaymentName();
            this.payStatus = orderBean.getPayStatus();
            this.payReason = orderBean.getPayReason();
            this.status = orderBean.getStatus();
            this.postId = orderBean.getPostId();
            this.postName = orderBean.getPostName();
            this.postCode = orderBean.getPostCode();
            this.money = orderBean.getMoney();
            this.totalMoney = orderBean.getTotalMoney();
            this.postMoney = orderBean.getPostMoney();
            this.lostActivityMoney  = orderBean.getLostActivityMoney();
            this.lostCouponMoney  = orderBean.getLostCouponMoney();
            this.lostMoney  = orderBean.getLostMoney();
            this.invoiceIs = orderBean.getInvoiceIs();
            this.invoiceHead = orderBean.getInvoiceHead();
            this.addressId = orderBean.getAddressId();
            this.userName = orderBean.getUserName();
            this.userPhone = orderBean.getUserPhone();
            this.address = orderBean.getAddress();
            this.zipcode = orderBean.getZipcode();
            this.couponId = orderBean.getCouponId();
            this.push = orderBean.getPush();
            this.read = orderBean.getRead();
            this.form = orderBean.getForm();
            this.explain = orderBean.getExplain();
            this.remark = orderBean.getRemark();
        }
    }

    public OrderVO toVO(){
        OrderVO orderVO = new OrderVO();
        orderVO.setId(this.getId());
        orderVO.setOrderCode(this.getOrderCode());
        orderVO.setUserId(this.getUserId());
        orderVO.setPaymentId(this.getPaymentId());
        orderVO.setPaymentName(this.getPaymentName());
        orderVO.setPayStatus(this.getPayStatus());
        orderVO.setPayReason(this.getPayReason());
        orderVO.setStatus(this.getStatus());
        orderVO.setPostId(this.getPostId());
        orderVO.setPostName(this.getPostName());
        orderVO.setPostCode(this.getPostCode());
        orderVO.setMoney(this.getMoney());
        orderVO.setTotalMoney(this.getTotalMoney());
        orderVO.setPostMoney(this.getPostMoney());
        orderVO.setLostActivityMoney(this.getLostActivityMoney());
        orderVO.setLostCouponMoney(this.getLostCouponMoney());
        orderVO.setLostMoney(this.getLostMoney());
        orderVO.setInvoiceIs(this.getInvoiceIs());
        orderVO.setInvoiceHead(this.getInvoiceHead());
        orderVO.setAddressId(this.getAddressId());
        orderVO.setUserName(this.getUserName());
        orderVO.setUserPhone(this.getUserPhone());
        orderVO.setAddress(this.getAddress());
        orderVO.setZipcode(this.getZipcode());
        orderVO.setCouponId(this.getCouponId());
        orderVO.setPush(this.getPush());
        orderVO.setRead(this.getRead());
        orderVO.setRemark(this.getRemark());
        return orderVO;
    }

    public OrderBean toBean(){
        OrderBean orderBean = new OrderBean();
        orderBean.setId(this.getId());
        orderBean.setOrderCode(this.getOrderCode());
        orderBean.setUserId(this.getUserId());
        orderBean.setPaymentId(this.getPaymentId());
        orderBean.setPaymentName(this.getPaymentName());
        orderBean.setPayStatus(this.getPayStatus());
        orderBean.setPayReason(this.getPayReason());
        orderBean.setStatus(this.getStatus());
        orderBean.setPostId(this.getPostId());
        orderBean.setPostName(this.getPostName());
        orderBean.setPostCode(this.getPostCode());
        orderBean.setMoney(this.getMoney());
        orderBean.setTotalMoney(this.getTotalMoney());
        orderBean.setPostMoney(this.getPostMoney());
        orderBean.setLostActivityMoney(this.getLostActivityMoney());
        orderBean.setLostCouponMoney(this.getLostCouponMoney());
        orderBean.setLostMoney(this.getLostMoney());
        orderBean.setInvoiceIs(this.getInvoiceIs());
        orderBean.setInvoiceHead(this.getInvoiceHead());
        orderBean.setAddressId(this.getAddressId());
        orderBean.setUserName(this.getUserName());
        orderBean.setUserPhone(this.getUserPhone());
        orderBean.setAddress(this.getAddress());
        orderBean.setZipcode(this.getZipcode());
        orderBean.setCouponId(this.getCouponId());
        orderBean.setPush(this.getPush());
        orderBean.setRead(this.getRead());
        orderBean.setForm(this.getForm());
        orderBean.setRemark(this.getRemark());
        orderBean.setCreateTime(this.getCreateTime());
        return orderBean;
    }


}