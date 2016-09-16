package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.math.BigDecimal; 

import java.util.Date; 


/**
*订单信息
**/
public class TOrder extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "订单编号",dbName = "order_code",length = 64,allowNull=true)
	private String orderCode=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "address_id",length = 10,allowNull=true)
	private Integer addressId=null;
	@FieldMeta(primaryKey = false,fieldName = "总价",dbName = "money",length = 10,allowNull=true)
	private BigDecimal money=null;
	@FieldMeta(primaryKey = false,fieldName = "支付方式（1是支付宝支付，2是微信支付,3货到付款）",dbName = "pay_type",length = 10,allowNull=true)
	private Integer payType=null;
	@FieldMeta(primaryKey = false,fieldName = "订单状态(0未支付,1支付成功,2支付未成功)",dbName = "pay_status",length = 10,allowNull=true)
	private Integer payStatus=null;
	@FieldMeta(primaryKey = false,fieldName = "订单状态(1待确认，2待发货，3运送中，4已完成)",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "快递公司ID",dbName = "post_id",length = 10,allowNull=true)
	private Integer postId=null;
	@FieldMeta(primaryKey = false,fieldName = "快递公司名称",dbName = "post_name",length = 50,allowNull=true)
	private String postName=null;
	@FieldMeta(primaryKey = false,fieldName = "快递单号",dbName = "post_code",length = 50,allowNull=true)
	private String postCode=null;
	@FieldMeta(primaryKey = false,fieldName = "邮费",dbName = "post_money",length = 10,allowNull=true)
	private BigDecimal postMoney=null;
	@FieldMeta(primaryKey = false,fieldName = "是否需要发票",dbName = "invoice_is",length = 10,allowNull=true)
	private Integer invoiceIs=null;
	@FieldMeta(primaryKey = false,fieldName = "发票抬头",dbName = "invoice_head",length = 128,allowNull=true)
	private String invoiceHead=null;
	@FieldMeta(primaryKey = false,fieldName = "消息推送记录(0为推送，1已推送)",dbName = "push",length = 10,allowNull=true)
	private Integer push=null;
	@FieldMeta(primaryKey = false,fieldName = "订单状态是否已读(0未读，1已读)",dbName = "read_is",length = 10,allowNull=true)
	private Integer readIs=null;
	@FieldMeta(primaryKey = false,fieldName = "删除标志",dbName = "delete_flag",length = 10,allowNull=true)
	private Integer deleteFlag=null;
	@FieldMeta(primaryKey = false,fieldName = "订单来源(1直接购买,2社区赠送,3一元购)",dbName = "form",length = 10,allowNull=true)
	private Integer form=null;
	@FieldMeta(primaryKey = false,fieldName = "备注",dbName = "remark",length = 225,allowNull=true)
	private String remark=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TOrder(){
 	}
 	public TOrder(Integer id,String orderCode,Integer userId,Integer addressId,BigDecimal money,Integer payType,Integer payStatus,Integer status,Integer postId,String postName,String postCode,BigDecimal postMoney,Integer invoiceIs,String invoiceHead,Integer push,Integer readIs,Integer deleteFlag,Integer form,String remark){
 		this.id = id;
		this.orderCode = orderCode;
		this.userId = userId;
		this.addressId = addressId;
		this.money = money;
		this.payType = payType;
		this.payStatus = payStatus;
		this.status = status;
		this.postId = postId;
		this.postName = postName;
		this.postCode = postCode;
		this.postMoney = postMoney;
		this.invoiceIs = invoiceIs;
		this.invoiceHead = invoiceHead;
		this.push = push;
		this.readIs = readIs;
		this.deleteFlag = deleteFlag;
		this.form = form;
		this.remark = remark;
		
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
	/*修改时间*/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

}
