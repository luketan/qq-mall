package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*活动
**/
public class TGActivity extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "活动ID",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "活动名称",dbName = "name",length = 225,allowNull=false)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "活动类型(1打折,2包邮,3赠送)",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "活动系数",dbName = "args",length = 225,allowNull=true)
	private String args=null;
	@FieldMeta(primaryKey = false,fieldName = "活动详情",dbName = "detail",length = 225,allowNull=true)
	private String detail=null;
	@FieldMeta(primaryKey = false,fieldName = "是否有时效(0无时效，1有时效)",dbName = "available",length = 10,allowNull=true)
	private Integer available=null;
	@FieldMeta(primaryKey = false,fieldName = "开始时间",dbName = "start_time",length = 19,allowNull=true)
	private Date startTime=null;
	@FieldMeta(primaryKey = false,fieldName = "结束时间",dbName = "end_time",length = 19,allowNull=true)
	private Date endTime=null;
	@FieldMeta(primaryKey = false,fieldName = "状态(1正常，2删除，3下架)",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TGActivity(){
 	}
 	public TGActivity(Integer id,String name,Integer type,String args,String detail,Integer available,Date startTime,Date endTime,Integer status){
 		this.id = id;
		this.name = name;
		this.type = type;
		this.args = args;
		this.detail = detail;
		this.available = available;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		
 	}
 	
		/*活动ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*活动名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*活动类型(1打折,2包邮,3赠送)*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*活动系数*/
	public String getArgs(){
		 return this.args; 
	}
	public void setArgs(String args){
		  this.args = args; 
	}
	/*活动详情*/
	public String getDetail(){
		 return this.detail; 
	}
	public void setDetail(String detail){
		  this.detail = detail; 
	}
	/*是否有时效(0无时效，1有时效)*/
	public Integer getAvailable(){
		 return this.available; 
	}
	public void setAvailable(Integer available){
		  this.available = available; 
	}
	/*开始时间*/
	public Date getStartTime(){
		 return this.startTime; 
	}
	public void setStartTime(Date startTime){
		  this.startTime = startTime; 
	}
	/*结束时间*/
	public Date getEndTime(){
		 return this.endTime; 
	}
	public void setEndTime(Date endTime){
		  this.endTime = endTime; 
	}
	/*状态(1正常，2删除，3下架)*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
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
