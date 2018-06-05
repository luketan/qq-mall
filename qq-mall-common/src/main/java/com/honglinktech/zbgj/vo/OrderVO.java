package com.honglinktech.zbgj.vo;

import com.honglinktech.zbgj.entity.Order;
import com.honglinktech.zbgj.entity.OrderItem;
import com.honglinktech.zbgj.entity.UserAddress;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
public class OrderVO {

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

	private List<OrderItem> orderItemList;
	private UserAddress tuserAddress;

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

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
	/*订单状态是否已读(0未读，1已读)*/
	public Integer getReadIs(){
		 return this.readIs; 
	}
	public void setReadIs(Integer readIs){
		  this.readIs = readIs; 
	}
	/*删除标志*/
	public Integer getDeleteFlag(){
		 return this.deleteFlag; 
	}
	public void setDeleteFlag(Integer deleteFlag){
		  this.deleteFlag = deleteFlag; 
	}
	/*订单来源(1直接购买,2社区赠送,3一元购)*/
	public Integer getForm(){
		 return this.form; 
	}
	public void setForm(Integer form){
		  this.form = form; 
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
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public UserAddress getTuserAddress() {
		return tuserAddress;
	}
	public void setTuserAddress(UserAddress tuserAddress) {
		this.tuserAddress = tuserAddress;
	}
	public String getOrderStatus(){
		String orderStatus = "";
		switch (this.status.intValue()) {
			case 1:
				orderStatus = "待付款";
				break;
			case 2:
				orderStatus = "待发货";
				break;
			case 3:
				orderStatus = "运送中";
				break;
			case 4:
				orderStatus = "已完成";
				break;
			case 7:
				orderStatus = "已取消";
				break;
			default:
				break;
		}
		return orderStatus;
	}

	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	
}
