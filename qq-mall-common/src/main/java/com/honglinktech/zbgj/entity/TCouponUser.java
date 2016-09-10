package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*
**/
public class TCouponUser extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "coupon_id",length = 10,allowNull=false)
	private Integer couponId;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "coupon_name",length = 128,allowNull=true)
	private String couponName;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "value",length = 10,allowNull=true)
	private Integer value;
	@FieldMeta(primaryKey = false,fieldName = "1正常",dbName = "status",length = 10,allowNull=true)
	private Integer status;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "start_date",length = 19,allowNull=true)
	private Date startDate;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "end_date",length = 19,allowNull=true)
	private Date endDate;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TCouponUser(){
 	}
 	public TCouponUser(Integer id,Integer couponId,String couponName,Integer value,Integer status,Date startDate,Date endDate){
 		this.id = id;
		this.couponId = couponId;
		this.couponName = couponName;
		this.value = value;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/**/
	public Integer getCouponId(){
		 return this.couponId; 
	}
	public void setCouponId(Integer couponId){
		  this.couponId = couponId; 
	}
	/**/
	public String getCouponName(){
		 return this.couponName; 
	}
	public void setCouponName(String couponName){
		  this.couponName = couponName; 
	}
	/**/
	public Integer getValue(){
		 return this.value; 
	}
	public void setValue(Integer value){
		  this.value = value; 
	}
	/*1正常*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}
	/**/
	public Date getStartDate(){
		 return this.startDate; 
	}
	public void setStartDate(Date startDate){
		  this.startDate = startDate; 
	}
	/**/
	public Date getEndDate(){
		 return this.endDate; 
	}
	public void setEndDate(Date endDate){
		  this.endDate = endDate; 
	}
	/**/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}
	/**/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

}
