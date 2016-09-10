package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*帖子
**/
public class TSocietyNote extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "社区主题id",dbName = "society_subject_id",length = 10,allowNull=false)
	private Integer societySubjectId;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_name",length = 50,allowNull=true)
	private String userName;
	@FieldMeta(primaryKey = false,fieldName = "标题",dbName = "title",length = 50,allowNull=true)
	private String title;
	@FieldMeta(primaryKey = false,fieldName = "帖子详情",dbName = "detail",length = 500,allowNull=true)
	private String detail;
	@FieldMeta(primaryKey = false,fieldName = "发表地址",dbName = "address",length = 50,allowNull=true)
	private String address;
	@FieldMeta(primaryKey = false,fieldName = "查看数量",dbName = "look_num",length = 10,allowNull=true)
	private Integer lookNum;
	@FieldMeta(primaryKey = false,fieldName = "评论数量",dbName = "dis_num",length = 10,allowNull=true)
	private Integer disNum;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "top_is",length = 10,allowNull=true)
	private Integer topIs;
	@FieldMeta(primaryKey = false,fieldName = "是否推荐",dbName = "rec_is",length = 10,allowNull=true)
	private Integer recIs;
	@FieldMeta(primaryKey = false,fieldName = "是否是精品",dbName = "gifts_is",length = 10,allowNull=true)
	private Integer giftsIs;
	@FieldMeta(primaryKey = false,fieldName = "1是社区讨论帖子，2是体验贴",dbName = "type",length = 10,allowNull=true)
	private Integer type;
	@FieldMeta(primaryKey = false,fieldName = "1是待审核，2是已经审核通过",dbName = "status",length = 10,allowNull=true)
	private Integer status;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TSocietyNote(){
 	}
 	public TSocietyNote(Integer id,Integer societySubjectId,Integer userId,String userName,String title,String detail,String address,Integer lookNum,Integer disNum,Integer topIs,Integer recIs,Integer giftsIs,Integer type,Integer status){
 		this.id = id;
		this.societySubjectId = societySubjectId;
		this.userId = userId;
		this.userName = userName;
		this.title = title;
		this.detail = detail;
		this.address = address;
		this.lookNum = lookNum;
		this.disNum = disNum;
		this.topIs = topIs;
		this.recIs = recIs;
		this.giftsIs = giftsIs;
		this.type = type;
		this.status = status;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*社区主题id*/
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
	/**/
	public String getUserName(){
		 return this.userName; 
	}
	public void setUserName(String userName){
		  this.userName = userName; 
	}
	/*标题*/
	public String getTitle(){
		 return this.title; 
	}
	public void setTitle(String title){
		  this.title = title; 
	}
	/*帖子详情*/
	public String getDetail(){
		 return this.detail; 
	}
	public void setDetail(String detail){
		  this.detail = detail; 
	}
	/*发表地址*/
	public String getAddress(){
		 return this.address; 
	}
	public void setAddress(String address){
		  this.address = address; 
	}
	/*查看数量*/
	public Integer getLookNum(){
		 return this.lookNum; 
	}
	public void setLookNum(Integer lookNum){
		  this.lookNum = lookNum; 
	}
	/*评论数量*/
	public Integer getDisNum(){
		 return this.disNum; 
	}
	public void setDisNum(Integer disNum){
		  this.disNum = disNum; 
	}
	/**/
	public Integer getTopIs(){
		 return this.topIs; 
	}
	public void setTopIs(Integer topIs){
		  this.topIs = topIs; 
	}
	/*是否推荐*/
	public Integer getRecIs(){
		 return this.recIs; 
	}
	public void setRecIs(Integer recIs){
		  this.recIs = recIs; 
	}
	/*是否是精品*/
	public Integer getGiftsIs(){
		 return this.giftsIs; 
	}
	public void setGiftsIs(Integer giftsIs){
		  this.giftsIs = giftsIs; 
	}
	/*1是社区讨论帖子，2是体验贴*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*1是待审核，2是已经审核通过*/
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
