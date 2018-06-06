package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.honglinktech.zbgj.entity.*;

@SuppressWarnings("unused")
public class OrderBean implements Serializable {

	private static final long serialVersionUID = -577728722353044309L;

	private Integer id;
	private String orderCode;
	private Integer userId;
	private Integer addressId;
	private BigDecimal money;
	private BigDecimal totalMoney;
	private BigDecimal lostPostMoney;
	private BigDecimal lostMoney;
	private Integer paymentId;
	private String paymentName;
	private Integer payStatus;
	private Integer status;
	private Integer postId;
	private String postName;
	private String postCode;
	private BigDecimal postMoney;
	private Integer invoiceIs;
	private String invoiceHead;
	private Integer push;
	private Integer readIs;
	private Integer deleteFlag;
	private Integer form;
	private String remark;
	private Date createTime;
	
	private List<OrderItemBean> orderItems;
	private CouponBean coupon;

	private UserAddress userAddress;
	
	public OrderBean(){
 	}

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

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
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

	public BigDecimal getPostMoney() {
		return postMoney;
	}

	public void setPostMoney(BigDecimal postMoney) {
		this.postMoney = postMoney;
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
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<OrderItemBean> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemBean> orderItems) {
		this.orderItems = orderItems;
	}

	public CouponBean getCoupon() {
		return coupon;
	}

	public void setCoupon(CouponBean coupon) {
		this.coupon = coupon;
	}

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}
}
