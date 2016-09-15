package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*注册用户推荐奖励
**/
public class TUserRec extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "用户id",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "rec_user_id",length = 10,allowNull=false)
	private Integer recUserId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "rec_user_name",length = 20,allowNull=true)
	private String recUserName=null;
	@FieldMeta(primaryKey = false,fieldName = "奖励类型（1逗币）",dbName = "award_type",length = 10,allowNull=true)
	private Integer awardType=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "award_num",length = 10,allowNull=true)
	private Integer awardNum=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserRec(){
 	}
 	public TUserRec(Integer id,Integer userId,Integer recUserId,String recUserName,Integer awardType,Integer awardNum){
 		this.id = id;
		this.userId = userId;
		this.recUserId = recUserId;
		this.recUserName = recUserName;
		this.awardType = awardType;
		this.awardNum = awardNum;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
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
