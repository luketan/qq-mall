package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*
**/
public class TUserSocMessage6 extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "society_note_id",length = 10,allowNull=true)
	private Integer societyNoteId;
	@FieldMeta(primaryKey = false,fieldName = "收的",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId;
	@FieldMeta(primaryKey = false,fieldName = "消息类型（1正在审核帖子，2是t帖子审核通过，3是回帖消息）",dbName = "type",length = 10,allowNull=true)
	private Integer type;
	@FieldMeta(primaryKey = false,fieldName = "内容",dbName = "content",length = 225,allowNull=true)
	private String content;
	@FieldMeta(primaryKey = false,fieldName = "发表时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserSocMessage6(){
 	}
 	public TUserSocMessage6(Integer id,Integer societyNoteId,Integer userId,Integer type,String content){
 		this.id = id;
		this.societyNoteId = societyNoteId;
		this.userId = userId;
		this.type = type;
		this.content = content;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/**/
	public Integer getSocietyNoteId(){
		 return this.societyNoteId; 
	}
	public void setSocietyNoteId(Integer societyNoteId){
		  this.societyNoteId = societyNoteId; 
	}
	/*收的*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*消息类型（1正在审核帖子，2是t帖子审核通过，3是回帖消息）*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*内容*/
	public String getContent(){
		 return this.content; 
	}
	public void setContent(String content){
		  this.content = content; 
	}
	/*发表时间*/
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
