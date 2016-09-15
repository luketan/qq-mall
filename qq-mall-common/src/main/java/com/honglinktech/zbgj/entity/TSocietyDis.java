package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*回帖内容，根据帖子id，分表 注意分表
**/
public class TSocietyDis extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "society_note_id",length = 10,allowNull=true)
	private Integer societyNoteId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_id",length = 10,allowNull=true)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_name",length = 50,allowNull=true)
	private String userName=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "content",length = 225,allowNull=true)
	private String content=null;
	@FieldMeta(primaryKey = false,fieldName = "评论被点赞用户",dbName = "like_user",length = 500,allowNull=true)
	private String likeUser=null;
	@FieldMeta(primaryKey = false,fieldName = "跟帖的上级（0表示回复帖子）",dbName = "parent",length = 10,allowNull=true)
	private Integer parent=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "reply_user_id",length = 10,allowNull=true)
	private Integer replyUserId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "reply_user_name",length = 50,allowNull=true)
	private String replyUserName=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TSocietyDis(){
 	}
 	public TSocietyDis(Integer id,Integer societyNoteId,Integer userId,String userName,String content,String likeUser,Integer parent,Integer replyUserId,String replyUserName){
 		this.id = id;
		this.societyNoteId = societyNoteId;
		this.userId = userId;
		this.userName = userName;
		this.content = content;
		this.likeUser = likeUser;
		this.parent = parent;
		this.replyUserId = replyUserId;
		this.replyUserName = replyUserName;
		
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
	/**/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/**/
	public String getUserName(){
		 return this.userName; 
	}
	public void setUserName(String userName){
		  this.userName = userName; 
	}
	/**/
	public String getContent(){
		 return this.content; 
	}
	public void setContent(String content){
		  this.content = content; 
	}
	/*评论被点赞用户*/
	public String getLikeUser(){
		 return this.likeUser; 
	}
	public void setLikeUser(String likeUser){
		  this.likeUser = likeUser; 
	}
	/*跟帖的上级（0表示回复帖子）*/
	public Integer getParent(){
		 return this.parent; 
	}
	public void setParent(Integer parent){
		  this.parent = parent; 
	}
	/**/
	public Integer getReplyUserId(){
		 return this.replyUserId; 
	}
	public void setReplyUserId(Integer replyUserId){
		  this.replyUserId = replyUserId; 
	}
	/**/
	public String getReplyUserName(){
		 return this.replyUserName; 
	}
	public void setReplyUserName(String replyUserName){
		  this.replyUserName = replyUserName; 
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
