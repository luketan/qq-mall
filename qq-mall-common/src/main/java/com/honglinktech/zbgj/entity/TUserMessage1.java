package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*用户聊天记录，用户id分表
**/
public class TUserMessage1 extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "发送方0是客服",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId;
	@FieldMeta(primaryKey = false,fieldName = "接收消息放",dbName = "receive_user_id",length = 10,allowNull=false)
	private Integer receiveUserId;
	@FieldMeta(primaryKey = false,fieldName = "内容",dbName = "content",length = 225,allowNull=true)
	private String content;
	@FieldMeta(primaryKey = false,fieldName = "消息类型1聊天，2礼物，3逗币",dbName = "type",length = 10,allowNull=true)
	private Integer type;
	@FieldMeta(primaryKey = false,fieldName = "价值数量",dbName = "val_num",length = 10,allowNull=true)
	private Integer valNum;
	@FieldMeta(primaryKey = false,fieldName = "是否已读(0未读，1已读)",dbName = "read_is",length = 10,allowNull=true)
	private Integer readIs;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserMessage1(){
 	}
 	public TUserMessage1(Integer id,Integer userId,Integer receiveUserId,String content,Integer type,Integer valNum,Integer readIs){
 		this.id = id;
		this.userId = userId;
		this.receiveUserId = receiveUserId;
		this.content = content;
		this.type = type;
		this.valNum = valNum;
		this.readIs = readIs;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*发送方0是客服*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*接收消息放*/
	public Integer getReceiveUserId(){
		 return this.receiveUserId; 
	}
	public void setReceiveUserId(Integer receiveUserId){
		  this.receiveUserId = receiveUserId; 
	}
	/*内容*/
	public String getContent(){
		 return this.content; 
	}
	public void setContent(String content){
		  this.content = content; 
	}
	/*消息类型1聊天，2礼物，3逗币*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*价值数量*/
	public Integer getValNum(){
		 return this.valNum; 
	}
	public void setValNum(Integer valNum){
		  this.valNum = valNum; 
	}
	/*是否已读(0未读，1已读)*/
	public Integer getReadIs(){
		 return this.readIs; 
	}
	public void setReadIs(Integer readIs){
		  this.readIs = readIs; 
	}
	/**/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}
	/**/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}

}
