package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*商品类别表
**/
public class TGType extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "类别名称",dbName = "name",length = 200,allowNull=false)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "类型图标",dbName = "ico",length = 100,allowNull=true)
	private String ico=null;
	@FieldMeta(primaryKey = false,fieldName = "类型图片",dbName = "img",length = 100,allowNull=true)
	private String img=null;
	@FieldMeta(primaryKey = false,fieldName = "是否首页l栏(0不是，1是)",dbName = "top_is",length = 10,allowNull=true)
	private Integer topIs=null;
	@FieldMeta(primaryKey = false,fieldName = "状态(1正常，2删除，3下架)",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TGType(){
 	}
 	public TGType(Integer id,String name,String ico,String img,Integer topIs,Integer status){
 		this.id = id;
		this.name = name;
		this.ico = ico;
		this.img = img;
		this.topIs = topIs;
		this.status = status;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*类别名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*类型图标*/
	public String getIco(){
		 return this.ico; 
	}
	public void setIco(String ico){
		  this.ico = ico; 
	}
	/*类型图片*/
	public String getImg(){
		 return this.img; 
	}
	public void setImg(String img){
		  this.img = img; 
	}
	/*是否首页l栏(0不是，1是)*/
	public Integer getTopIs(){
		 return this.topIs; 
	}
	public void setTopIs(Integer topIs){
		  this.topIs = topIs; 
	}
	/*状态(1正常，2删除，3下架)*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}
	/**/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}
	/**/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

}
