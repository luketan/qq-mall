package com.honglinktech.zbgj.bean;

import com.honglinktech.zbgj.entity.Order;
import com.honglinktech.zbgj.entity.OrderItem;
import com.honglinktech.zbgj.entity.UserAddress;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SuppressWarnings("unused")
public class OrderSimpleBean {

	private Integer id=null;
	private String orderCode=null;
	private Integer userId=null;
	private String userName=null;
	private String userPhone=null;
	private BigDecimal totalMoney=null;
	private Integer paymentId=null;
	private Integer payStatus=null;
	private Integer status=null;
	private Integer postId=null;
	private String postCode=null;
	private String postName=null;
	private BigDecimal postMoney=null;
	private Integer push=null;
	private Integer readIs=null;
	private Integer form=null;
	private Date createTime=null;

	public OrderSimpleBean(){
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
	/*订单来源(1直接购买,2社区赠送,3一元购)*/
	public Integer getForm(){
		 return this.form; 
	}
	public void setForm(Integer form){
		  this.form = form; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
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
}
