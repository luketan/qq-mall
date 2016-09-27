package com.honglinktech.zbgj.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

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
	@FieldMeta(primaryKey = false,fieldName = "商品总价",dbName = "money",length = 10,allowNull=true)
	private BigDecimal money=null;
	@FieldMeta(primaryKey = false,fieldName = "订单总价",dbName = "total_money",length = 10,allowNull=true)
	private BigDecimal totalMoney=null;
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
	@FieldMeta(primaryKey = false,fieldName = "运费减免",dbName = "lost_post_money",length = 10,allowNull=true)
	private BigDecimal lostPostMoney=null;
	@FieldMeta(primaryKey = false,fieldName = "优惠金额",dbName = "lost_money",length = 10,allowNull=true)
	private BigDecimal lostMoney=null;
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
	@FieldMeta(primaryKey = false,fieldName = "订单说明",dbName = "explain",length = 225,allowNull=true)
	private String explain=null;
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
 	public TOrder(Integer id,String orderCode,Integer userId,Integer addressId,BigDecimal money,BigDecimal totalMoney,Integer payType,Integer payStatus,Integer status,Integer postId,String postName,String postCode,BigDecimal postMoney,BigDecimal lostPostMoney,BigDecimal lostMoney,Integer invoiceIs,String invoiceHead,Integer push,Integer readIs,Integer deleteFlag,Integer form,String remark,String explain){
 		this.id = id;
		this.orderCode = orderCode;
		this.userId = userId;
		this.addressId = addressId;
		this.money = money;
		this.totalMoney = totalMoney;
		this.payType = payType;
		this.payStatus = payStatus;
		this.status = status;
		this.postId = postId;
		this.postName = postName;
		this.postCode = postCode;
		this.postMoney = postMoney;
		this.lostPostMoney = lostPostMoney;
		this.lostMoney = lostMoney;
		this.invoiceIs = invoiceIs;
		this.invoiceHead = invoiceHead;
		this.push = push;
		this.readIs = readIs;
		this.deleteFlag = deleteFlag;
		this.form = form;
		this.remark = remark;
		this.explain = explain;
		
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
	/*商品总价*/
	public BigDecimal getMoney(){
		 return this.money; 
	}
	public void setMoney(BigDecimal money){
		  this.money = money; 
	}
	/*订单总价*/
	public BigDecimal getTotalMoney(){
		 return this.totalMoney; 
	}
	public void setTotalMoney(BigDecimal totalMoney){
		  this.totalMoney = totalMoney; 
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
	/*运费减免*/
	public BigDecimal getLostPostMoney(){
		 return this.lostPostMoney; 
	}
	public void setLostPostMoney(BigDecimal lostPostMoney){
		  this.lostPostMoney = lostPostMoney; 
	}
	/*优惠金额*/
	public BigDecimal getLostMoney(){
		 return this.lostMoney; 
	}
	public void setLostMoney(BigDecimal lostMoney){
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
	/*订单说明*/
	public String getExplain(){
		 return this.explain; 
	}
	public void setExplain(String explain){
		  this.explain = explain; 
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

	
	public enum DBMaping{
		tableName("t_order",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		orderCode("order_code",Types.VARCHAR,false,false,true),
		userId("user_id",Types.INTEGER,false,false,false),
		addressId("address_id",Types.INTEGER,false,false,true),
		money("money",Types.DECIMAL,false,false,true),
		totalMoney("total_money",Types.DECIMAL,false,false,true),
		payType("pay_type",Types.INTEGER,false,false,true),
		payStatus("pay_status",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		postId("post_id",Types.INTEGER,false,false,true),
		postName("post_name",Types.VARCHAR,false,false,true),
		postCode("post_code",Types.VARCHAR,false,false,true),
		postMoney("post_money",Types.DECIMAL,false,false,true),
		lostPostMoney("lost_post_money",Types.DECIMAL,false,false,true),
		lostMoney("lost_money",Types.DECIMAL,false,false,true),
		invoiceIs("invoice_is",Types.INTEGER,false,false,true),
		invoiceHead("invoice_head",Types.VARCHAR,false,false,true),
		push("push",Types.INTEGER,false,false,true),
		readIs("read_is",Types.INTEGER,false,false,true),
		deleteFlag("delete_flag",Types.INTEGER,false,false,true),
		form("form",Types.INTEGER,false,false,true),
		remark("remark",Types.VARCHAR,false,false,true),
		explain("explain",Types.VARCHAR,false,false,true),
		updateTime("update_time",Types.TIMESTAMP,false,false,true),
		createTime("create_time",Types.TIMESTAMP,false,false,true);
		private String dbName;
		private int dbType;
		private boolean primaryKey;
		private boolean isAotuIn;
		private boolean isAllowNull;
	    public String getDbName(){
	    	 return this.dbName;
	    }
	    public int getDbType(){
	    	 return this.dbType;
	    }
	    public boolean getPrimaryKey(){
	    	 return this.primaryKey;
	    }
	    public boolean isAotuIn(){
	    	 return this.isAotuIn;
	    }
	    public boolean isAllowNull(){
	    	 return this.isAllowNull;
	    }
	    private DBMaping(String dbName,int dbType,boolean primaryKey,boolean isAotuIn,boolean isAllowNull){
	    	 this.dbName = dbName;
	    	 this.dbType = dbType;
	    	 this.primaryKey = primaryKey;
	    	 this.isAotuIn = isAotuIn;
	    	 this.isAllowNull = isAllowNull;
	    }
	}
	public Object[] getDBMapping(String filedName){
		for(DBMaping d:DBMaping.values()){
			if(d.toString().equals(filedName)){
				DBMaping dbMaping = DBMaping.valueOf(filedName);
				Object[] values = {dbMaping.dbName,dbMaping.dbType,dbMaping.primaryKey,dbMaping.isAotuIn,dbMaping.isAllowNull};
				return values;
			}
		}
		return null;
	}
	public static class TOrderRowMapper implements RowMapper<TOrder> {  
        @Override  
        public TOrder mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TOrder tOrder = new TOrder();
			tOrder.setId(rs.getInt("id"));
			tOrder.setOrderCode(rs.getString("order_code"));
			tOrder.setUserId(rs.getInt("user_id"));
			tOrder.setAddressId(rs.getInt("address_id"));
			tOrder.setMoney(rs.getBigDecimal("money"));
			tOrder.setTotalMoney(rs.getBigDecimal("total_money"));
			tOrder.setPayType(rs.getInt("pay_type"));
			tOrder.setPayStatus(rs.getInt("pay_status"));
			tOrder.setStatus(rs.getInt("status"));
			tOrder.setPostId(rs.getInt("post_id"));
			tOrder.setPostName(rs.getString("post_name"));
			tOrder.setPostCode(rs.getString("post_code"));
			tOrder.setPostMoney(rs.getBigDecimal("post_money"));
			tOrder.setLostPostMoney(rs.getBigDecimal("lost_post_money"));
			tOrder.setLostMoney(rs.getBigDecimal("lost_money"));
			tOrder.setInvoiceIs(rs.getInt("invoice_is"));
			tOrder.setInvoiceHead(rs.getString("invoice_head"));
			tOrder.setPush(rs.getInt("push"));
			tOrder.setReadIs(rs.getInt("read_is"));
			tOrder.setDeleteFlag(rs.getInt("delete_flag"));
			tOrder.setForm(rs.getInt("form"));
			tOrder.setRemark(rs.getString("remark"));
			tOrder.setExplain(rs.getString("explain"));
			tOrder.setUpdateTime(rs.getTimestamp("update_time"));
			tOrder.setCreateTime(rs.getTimestamp("create_time"));
			return tOrder; 
        }  
          
    }
}
