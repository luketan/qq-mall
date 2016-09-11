package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*用户关注的主题
**/
public class TSocietySubUser extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "society_subject_id",length = 10,allowNull=false)
	private Integer societySubjectId;
	@FieldMeta(primaryKey = true,fieldName = "",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId;
	@FieldMeta(primaryKey = false,fieldName = "社区圈共享值",dbName = "val",length = 10,allowNull=true)
	private Integer val;
	@FieldMeta(primaryKey = false,fieldName = "用在在板块的身份，1是正常，2是版主",dbName = "type",length = 10,allowNull=true)
	private Integer type;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TSocietySubUser(){
 	}
 	public TSocietySubUser(Integer societySubjectId,Integer userId,Integer val,Integer type){
 		this.societySubjectId = societySubjectId;
		this.userId = userId;
		this.val = val;
		this.type = type;
		
 	}
 	
		/**/
	public Integer getSocietySubjectId(){
		 return this.societySubjectId; 
	}
	public void setSocietySubjectId(Integer societySubjectId){
		  this.societySubjectId = societySubjectId; 
	}
	/**/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*社区圈共享值*/
	public Integer getVal(){
		 return this.val; 
	}
	public void setVal(Integer val){
		  this.val = val; 
	}
	/*用在在板块的身份，1是正常，2是版主*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
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
