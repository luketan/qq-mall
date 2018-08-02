package com.honglinktech.zbgj.vo;

import com.honglinktech.zbgj.bean.CouponBean;
import com.honglinktech.zbgj.bean.OrderItemBean;
import com.honglinktech.zbgj.entity.Order;
import com.honglinktech.zbgj.entity.OrderItem;
import com.honglinktech.zbgj.entity.UserAddress;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderVO {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
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
	 * 用户备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;

	private List<OrderItemBean> orderItems;
	private CouponVO coupon;

	public OrderVO(){
 	}
	/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*订单编号*/
	public String getOrderCode(){
		 return this.orderCode; 
	}
	public void setOrderCode(String orderCode){
		  this.orderCode = orderCode; 
	}
	/**/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/**/
	public Integer getAddressId(){
		 return this.addressId;
	}
	public void setAddressId(Integer addressId){
		  this.addressId = addressId;
	}
	/*总价*/
	public BigDecimal getMoney(){
		 return this.money; 
	}
	public void setMoney(BigDecimal money){
		  this.money = money; 
	}
	/*支付方式（1是支付宝支付，2是微信支付,3货到付款）*/
	
	/*订单状态(0未支付,1支付成功,2支付未成功)*/
	public Integer getPayStatus(){
		 return this.payStatus; 
	}
	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public void setPayStatus(Integer payStatus){
		  this.payStatus = payStatus; 
	}
	/*订单状态(1待确认，2待发货，3运送中，4已完成)*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}
	/*快递公司ID*/
	public Integer getPostId(){
		 return this.postId; 
	}
	public void setPostId(Integer postId){
		  this.postId = postId; 
	}
	/*快递公司名称*/
	public String getPostName(){
		 return this.postName; 
	}
	public void setPostName(String postName){
		  this.postName = postName; 
	}
	/*快递单号*/
	public String getPostCode(){
		 return this.postCode; 
	}
	public void setPostCode(String postCode){
		  this.postCode = postCode; 
	}
	/*邮费*/
	public BigDecimal getPostMoney(){
		 return this.postMoney; 
	}
	public void setPostMoney(BigDecimal postMoney){
		  this.postMoney = postMoney; 
	}
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	public BigDecimal getLostMoney() {
		return lostMoney;
	}
	public void setLostMoney(BigDecimal lostMoney) {
		this.lostMoney = lostMoney;
	}
	/*是否需要发票*/
	public Integer getInvoiceIs(){
		 return this.invoiceIs; 
	}
	public void setInvoiceIs(Integer invoiceIs){
		  this.invoiceIs = invoiceIs; 
	}
	/*发票抬头*/
	public String getInvoiceHead(){
		 return this.invoiceHead; 
	}
	public void setInvoiceHead(String invoiceHead){
		  this.invoiceHead = invoiceHead; 
	}
	/*消息推送记录(0为推送，1已推送)*/
	public Integer getPush(){
		 return this.push; 
	}
	public void setPush(Integer push){
		  this.push = push; 
	}

	public Integer getRead() {
		return read;
	}

	public void setRead(Integer read) {
		this.read = read;
	}

	/*备注*/
	public String getRemark(){
		 return this.remark; 
	}
	public void setRemark(String remark){
		  this.remark = remark; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}
	public String getPaymentName() {
		return paymentName;
	}
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public String getPayReason() {
		return payReason;
	}

	public void setPayReason(String payReason) {
		this.payReason = payReason;
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

	public List<OrderItemBean> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemBean> orderItems) {
		this.orderItems = orderItems;
	}

	public CouponVO getCoupon() {
		return coupon;
	}

	public void setCoupon(CouponVO coupon) {
		this.coupon = coupon;
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
}
