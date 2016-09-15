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
	@FieldMeta(primaryKey = false,fieldName = "订单编号",dbName = "order_code",length = 50,allowNull=true)
	private String orderCode=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "总价",dbName = "money",length = 10,allowNull=true)
	private BigDecimal money=null;
	@FieldMeta(primaryKey = false,fieldName = "邮费",dbName = "post_money",length = 10,allowNull=true)
	private BigDecimal postMoney=null;
	@FieldMeta(primaryKey = false,fieldName = "支付方式（1货到付款，2是支付宝支付，3是微信支付）",dbName = "pay_type",length = 10,allowNull=true)
	private Integer payType=null;
	@FieldMeta(primaryKey = false,fieldName = "订单状态（1未支付，2支付未成功，3支付成功）",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "订单来源，1用户购物车,2社区赠送",dbName = "form",length = 10,allowNull=true)
	private Integer form=null;
	@FieldMeta(primaryKey = false,fieldName = "快递单号",dbName = "post_code",length = 50,allowNull=true)
	private String postCode=null;
	@FieldMeta(primaryKey = false,fieldName = "备注",dbName = "remark",length = 225,allowNull=true)
	private String remark=null;
	@FieldMeta(primaryKey = false,fieldName = "是否需要发票",dbName = "invoice_is",length = 10,allowNull=true)
	private Integer invoiceIs=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "invoice_head",length = 128,allowNull=true)
	private String invoiceHead=null;
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
 	public TOrder(Integer id,String orderCode,Integer userId,BigDecimal money,BigDecimal postMoney,Integer payType,Integer status,Integer form,String postCode,String remark,Integer invoiceIs,String invoiceHead){
 		this.id = id;
		this.orderCode = orderCode;
		this.userId = userId;
		this.money = money;
		this.postMoney = postMoney;
		this.payType = payType;
		this.status = status;
		this.form = form;
		this.postCode = postCode;
		this.remark = remark;
		this.invoiceIs = invoiceIs;
		this.invoiceHead = invoiceHead;
		
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
	/*总价*/
	public BigDecimal getMoney(){
		 return this.money; 
	}
	public void setMoney(BigDecimal money){
		  this.money = money; 
	}
	/*邮费*/
	public BigDecimal getPostMoney(){
		 return this.postMoney; 
	}
	public void setPostMoney(BigDecimal postMoney){
		  this.postMoney = postMoney; 
	}
	/*支付方式（1货到付款，2是支付宝支付，3是微信支付）*/
	public Integer getPayType(){
		 return this.payType; 
	}
	public void setPayType(Integer payType){
		  this.payType = payType; 
	}
	/*订单状态（1未支付，2支付未成功，3支付成功）*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}
	/*订单来源，1用户购物车,2社区赠送*/
	public Integer getForm(){
		 return this.form; 
	}
	public void setForm(Integer form){
		  this.form = form; 
	}
	/*快递单号*/
	public String getPostCode(){
		 return this.postCode; 
	}
	public void setPostCode(String postCode){
		  this.postCode = postCode; 
	}
	/*备注*/
	public String getRemark(){
		 return this.remark; 
	}
	public void setRemark(String remark){
		  this.remark = remark; 
	}
	/*是否需要发票*/
	public Integer getInvoiceIs(){
		 return this.invoiceIs; 
	}
	public void setInvoiceIs(Integer invoiceIs){
		  this.invoiceIs = invoiceIs; 
	}
	/**/
	public String getInvoiceHead(){
		 return this.invoiceHead; 
	}
	public void setInvoiceHead(String invoiceHead){
		  this.invoiceHead = invoiceHead; 
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
