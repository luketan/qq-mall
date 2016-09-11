package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*提示语
**/
public class THint extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "内容",dbName = "content",length = 255,allowNull=false)
	private String content;
	@FieldMeta(primaryKey = false,fieldName = "论坛主题(不同的主题)",dbName = "sub_type",length = 10,allowNull=true)
	private Integer subType;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "remark",length = 20,allowNull=true)
	private String remark;
	@FieldMeta(primaryKey = true,fieldName = "类型(1下拉更新,2转圈,3发帖,4回帖)",dbName = "type",length = 10,allowNull=false)
	private Integer type;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	@FieldMeta(primaryKey = false,fieldName = "更新时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public THint(){
 	}
 	public THint(Integer id,String content,Integer subType,String remark,Integer type){
 		this.id = id;
		this.content = content;
		this.subType = subType;
		this.remark = remark;
		this.type = type;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*内容*/
	public String getContent(){
		 return this.content; 
	}
	public void setContent(String content){
		  this.content = content; 
	}
	/*论坛主题(不同的主题)*/
	public Integer getSubType(){
		 return this.subType; 
	}
	public void setSubType(Integer subType){
		  this.subType = subType; 
	}
	/**/
	public String getRemark(){
		 return this.remark; 
	}
	public void setRemark(String remark){
		  this.remark = remark; 
	}
	/*类型(1下拉更新,2转圈,3发帖,4回帖)*/
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
	/*更新时间*/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}

}
