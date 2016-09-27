package com.honglinktech.zbgj.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.honglinktech.zbgj.annotation.FieldMeta;
import com.honglinktech.zbgj.entity.TOrder;
import com.honglinktech.zbgj.entity.TOrderItem;
import com.honglinktech.zbgj.entity.TUserAddress;

@SuppressWarnings("unused")
public class OrderBean {

	private Integer id=null;
	private String orderCode=null;
	private Integer userId=null;
	private Integer addressId=null;
	private BigDecimal money=null;
	private BigDecimal totalMoney=null;
	private BigDecimal lostPostMoney=null;
	private BigDecimal lostMoney=null;
	private Integer payType=null;
	private Integer payStatus=null;
	private Integer status=null;
	private Integer postId=null;
	private String postName=null;
	private String postCode=null;
	private BigDecimal postMoney=null;
	private Integer invoiceIs=null;
	private String invoiceHead=null;
	private Integer push=null;
	private Integer readIs=null;
	private Integer deleteFlag=null;
	private Integer form=null;
	private String remark=null;
	private Date createTime=null;
	
	private List<TOrderItem> orderItemList;
	private TUserAddress tuserAddress;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OrderBean(){
 	}
  	
	public OrderBean(TOrder torder) {
		if(torder!=null){
			this.id = torder.getId();
			this.orderCode = torder.getOrderCode();
			this.userId = torder.getUserId();
			this.addressId = torder.getAddressId();
			this.money = torder.getMoney();
			this.totalMoney = torder.getTotalMoney();
			this.payType = torder.getPayType();
			this.payStatus = torder.getPayStatus();
			this.status = torder.getStatus();
			this.postId = torder.getPostId();
			this.postName = torder.getPostName();
			this.postCode = torder.getPostCode();
			this.postMoney = torder.getPostMoney();
			this.lostPostMoney = torder.getLostPostMoney();
			this.lostMoney  = torder.getLostMoney();
			this.invoiceIs = torder.getInvoiceIs();
			this.invoiceHead = torder.getInvoiceHead();
			this.push = torder.getPush();
			this.readIs = torder.getReadIs();
			this.deleteFlag = torder.getDeleteFlag();
			this.form = torder.getForm();
			this.remark = torder.getRemark();
			this.createTime = torder.getCreateTime();
		}
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
	public Integer getPayType(){
		 return this.payType; 
	}
	public void setPayType(Integer payType){
		  this.payType = payType; 
	}
	/*订单状态(0未支付,1支付成功,2支付未成功)*/
	public Integer getPayStatus(){
		 return this.payStatus; 
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
	public List<TOrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<TOrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public TUserAddress getTuserAddress() {
		return tuserAddress;
	}
	public void setTuserAddress(TUserAddress tuserAddress) {
		this.tuserAddress = tuserAddress;
	}
	public String getOrderStatus(){
		String orderStatus = "";
		switch (this.status.intValue()) {
			case 1:
				orderStatus = "待确认";
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
			default:
				break;
		}
		return orderStatus;
	}
	//1是支付宝支付，2是微信支付,3货到付款,4银联支付
	public String getPayMethed(){
		String payMethed = "";
		switch (this.status.intValue()) {
			case 1:
				payMethed = "支付宝支付";
				break;
			case 2:
				payMethed = "微信支付";
				break;
			case 3:
				payMethed = "货到付款";
				break;
			case 4:
				payMethed = "银联支付";
				break;
			default:
				break;
		}
		return payMethed;
	}
	
	
}
