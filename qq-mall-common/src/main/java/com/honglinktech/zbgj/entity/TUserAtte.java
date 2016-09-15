package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*用户关注
**/
public class TUserAtte extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "用户ID",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = true,fieldName = "好友ID",dbName = "atte_user_id",length = 10,allowNull=false)
	private Integer atteUserId=null;
	@FieldMeta(primaryKey = false,fieldName = "类型（1：好友申请，2：好友，3陌生人）",dbName = "type",length = 10,allowNull=false)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "好友名字",dbName = "atte_user_name",length = 50,allowNull=true)
	private String atteUserName=null;
	@FieldMeta(primaryKey = false,fieldName = "好友经理头像",dbName = "atte_user_head",length = 300,allowNull=true)
	private String atteUserHead=null;
	@FieldMeta(primaryKey = false,fieldName = "好友等级",dbName = "atte_user_level",length = 10,allowNull=true)
	private Integer atteUserLevel=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "atte_money",length = 10,allowNull=true)
	private Integer atteMoney=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserAtte(){
 	}
 	public TUserAtte(Integer userId,Integer atteUserId,Integer type,String atteUserName,String atteUserHead,Integer atteUserLevel,Integer atteMoney){
 		this.userId = userId;
		this.atteUserId = atteUserId;
		this.type = type;
		this.atteUserName = atteUserName;
		this.atteUserHead = atteUserHead;
		this.atteUserLevel = atteUserLevel;
		this.atteMoney = atteMoney;
		
 	}
 	
		/*用户ID*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*好友ID*/
	public Integer getAtteUserId(){
		 return this.atteUserId; 
	}
	public void setAtteUserId(Integer atteUserId){
		  this.atteUserId = atteUserId; 
	}
	/*类型（1：好友申请，2：好友，3陌生人）*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*好友名字*/
	public String getAtteUserName(){
		 return this.atteUserName; 
	}
	public void setAtteUserName(String atteUserName){
		  this.atteUserName = atteUserName; 
	}
	/*好友经理头像*/
	public String getAtteUserHead(){
		 return this.atteUserHead; 
	}
	public void setAtteUserHead(String atteUserHead){
		  this.atteUserHead = atteUserHead; 
	}
	/*好友等级*/
	public Integer getAtteUserLevel(){
		 return this.atteUserLevel; 
	}
	public void setAtteUserLevel(Integer atteUserLevel){
		  this.atteUserLevel = atteUserLevel; 
	}
	/**/
	public Integer getAtteMoney(){
		 return this.atteMoney; 
	}
	public void setAtteMoney(Integer atteMoney){
		  this.atteMoney = atteMoney; 
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
