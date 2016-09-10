package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*活动
**/
public class TProblem extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "商品类型",dbName = "goods_id",length = 10,allowNull=false)
	private Integer goodsId;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_name",length = 50,allowNull=true)
	private String userName;
	@FieldMeta(primaryKey = false,fieldName = "活动详情",dbName = "question",length = 225,allowNull=true)
	private String question;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "answer",length = 225,allowNull=true)
	private String answer;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "admin_id",length = 10,allowNull=true)
	private Integer adminId;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "admin_name",length = 50,allowNull=true)
	private String adminName;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TProblem(){
 	}
 	public TProblem(Integer id,Integer goodsId,Integer userId,String userName,String question,String answer,Integer adminId,String adminName){
 		this.id = id;
		this.goodsId = goodsId;
		this.userId = userId;
		this.userName = userName;
		this.question = question;
		this.answer = answer;
		this.adminId = adminId;
		this.adminName = adminName;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*商品类型*/
	public Integer getGoodsId(){
		 return this.goodsId; 
	}
	public void setGoodsId(Integer goodsId){
		  this.goodsId = goodsId; 
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
	/*活动详情*/
	public String getQuestion(){
		 return this.question; 
	}
	public void setQuestion(String question){
		  this.question = question; 
	}
	/**/
	public String getAnswer(){
		 return this.answer; 
	}
	public void setAnswer(String answer){
		  this.answer = answer; 
	}
	/**/
	public Integer getAdminId(){
		 return this.adminId; 
	}
	public void setAdminId(Integer adminId){
		  this.adminId = adminId; 
	}
	/**/
	public String getAdminName(){
		 return this.adminName; 
	}
	public void setAdminName(String adminName){
		  this.adminName = adminName; 
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
