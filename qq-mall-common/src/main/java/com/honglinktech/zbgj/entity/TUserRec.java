package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*注册用户推荐奖励
**/
public class TUserRec extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = false,fieldName = "用户id",dbName = "user_id",length = 10,allowNull=true)
	private Integer userId;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "rec_user_id",length = 10,allowNull=true)
	private Integer recUserId;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "rec_user_name",length = 20,allowNull=true)
	private String recUserName;
	@FieldMeta(primaryKey = false,fieldName = "奖励类型（1逗币）",dbName = "award_type",length = 10,allowNull=true)
	private Integer awardType;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "award_num",length = 10,allowNull=true)
	private Integer awardNum;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserRec(){
 	}
 	public TUserRec(Integer userId,Integer recUserId,String recUserName,Integer awardType,Integer awardNum){
 		this.userId = userId;
		this.recUserId = recUserId;
		this.recUserName = recUserName;
		this.awardType = awardType;
		this.awardNum = awardNum;
		
 	}
 	
		/*用户id*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/**/
	public Integer getRecUserId(){
		 return this.recUserId; 
	}
	public void setRecUserId(Integer recUserId){
		  this.recUserId = recUserId; 
	}
	/**/
	public String getRecUserName(){
		 return this.recUserName; 
	}
	public void setRecUserName(String recUserName){
		  this.recUserName = recUserName; 
	}
	/*奖励类型（1逗币）*/
	public Integer getAwardType(){
		 return this.awardType; 
	}
	public void setAwardType(Integer awardType){
		  this.awardType = awardType; 
	}
	/**/
	public Integer getAwardNum(){
		 return this.awardNum; 
	}
	public void setAwardNum(Integer awardNum){
		  this.awardNum = awardNum; 
	}
	/**/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

}
