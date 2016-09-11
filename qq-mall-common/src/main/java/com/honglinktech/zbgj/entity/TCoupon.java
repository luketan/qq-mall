package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*优惠券
**/
public class TCoupon extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "ID",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "名称",dbName = "name",length = 50,allowNull=true)
	private String name;
	@FieldMeta(primaryKey = false,fieldName = "类型(1优惠券，2红包红包可兑换社区币）",dbName = "type",length = 10,allowNull=true)
	private Integer type;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "value",length = 10,allowNull=true)
	private Integer value;
	@FieldMeta(primaryKey = false,fieldName = "1正常",dbName = "status",length = 10,allowNull=true)
	private Integer status;
	@FieldMeta(primaryKey = false,fieldName = "开始时间",dbName = "start_date",length = 19,allowNull=true)
	private Date startDate;
	@FieldMeta(primaryKey = false,fieldName = "结束时间",dbName = "end_date",length = 19,allowNull=true)
	private Date endDate;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TCoupon(){
 	}
 	public TCoupon(Integer id,String name,Integer type,Integer value,Integer status,Date startDate,Date endDate){
 		this.id = id;
		this.name = name;
		this.type = type;
		this.value = value;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		
 	}
 	
		/*ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*类型(1优惠券，2红包红包可兑换社区币）*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
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
	/*开始时间*/
	public Date getStartDate(){
		 return this.startDate; 
	}
	public void setStartDate(Date startDate){
		  this.startDate = startDate; 
	}
	/*结束时间*/
	public Date getEndDate(){
		 return this.endDate; 
	}
	public void setEndDate(Date endDate){
		  this.endDate = endDate; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}
	/*修改时间*/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}

}
