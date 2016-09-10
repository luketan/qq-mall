package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*商品图片
**/
public class TPic extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "商品类型",dbName = "obj_id",length = 10,allowNull=true)
	private Integer objId;
	@FieldMeta(primaryKey = false,fieldName = "图片类型(1是商品图，10是评论图片,11是论坛评论图片)",dbName = "type",length = 10,allowNull=true)
	private Integer type;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "pic_name",length = 50,allowNull=true)
	private String picName;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "pic_url",length = 225,allowNull=true)
	private String picUrl;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TPic(){
 	}
 	public TPic(Integer id,Integer objId,Integer type,String picName,String picUrl){
 		this.id = id;
		this.objId = objId;
		this.type = type;
		this.picName = picName;
		this.picUrl = picUrl;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*商品类型*/
	public Integer getObjId(){
		 return this.objId; 
	}
	public void setObjId(Integer objId){
		  this.objId = objId; 
	}
	/*图片类型(1是商品图，10是评论图片,11是论坛评论图片)*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/**/
	public String getPicName(){
		 return this.picName; 
	}
	public void setPicName(String picName){
		  this.picName = picName; 
	}
	/**/
	public String getPicUrl(){
		 return this.picUrl; 
	}
	public void setPicUrl(String picUrl){
		  this.picUrl = picUrl; 
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
