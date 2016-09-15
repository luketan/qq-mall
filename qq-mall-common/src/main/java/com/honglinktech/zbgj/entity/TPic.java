package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*商品图片
**/
public class TPic extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "商品类型",dbName = "obj_id",length = 10,allowNull=true)
	private Integer objId=null;
	@FieldMeta(primaryKey = false,fieldName = "图片类型(1是商品图，10是评论图片,11是论坛评论图片)",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "图片标题",dbName = "pic_title",length = 50,allowNull=true)
	private String picTitle=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "pic_url",length = 225,allowNull=true)
	private String picUrl=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TPic(){
 	}
 	public TPic(Integer id,Integer objId,Integer type,String picTitle,String picUrl){
 		this.id = id;
		this.objId = objId;
		this.type = type;
		this.picTitle = picTitle;
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
	/*图片标题*/
	public String getPicTitle(){
		 return this.picTitle; 
	}
	public void setPicTitle(String picTitle){
		  this.picTitle = picTitle; 
	}
	/**/
	public String getPicUrl(){
		 return this.picUrl; 
	}
	public void setPicUrl(String picUrl){
		  this.picUrl = picUrl; 
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
