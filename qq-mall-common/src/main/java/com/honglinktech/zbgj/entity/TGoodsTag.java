package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*商品表情
**/
public class TGoodsTag extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "标签名称",dbName = "name",length = 255,allowNull=false)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "标签类型(1商品标签，2是帖子标签)",dbName = "type",length = 10,allowNull=false)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "img",length = 225,allowNull=true)
	private String img=null;
	@FieldMeta(primaryKey = false,fieldName = "状态",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "title",length = 225,allowNull=true)
	private String title=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "subtitle",length = 225,allowNull=true)
	private String subtitle=null;
	@FieldMeta(primaryKey = false,fieldName = "是否显示首页",dbName = "show_main",length = 10,allowNull=true)
	private Integer showMain=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TGoodsTag(){
 	}
 	public TGoodsTag(Integer id,String name,Integer type,String img,Integer status,String title,String subtitle,Integer showMain){
 		this.id = id;
		this.name = name;
		this.type = type;
		this.img = img;
		this.status = status;
		this.title = title;
		this.subtitle = subtitle;
		this.showMain = showMain;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*标签名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*标签类型(1商品标签，2是帖子标签)*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/**/
	public String getImg(){
		 return this.img; 
	}
	public void setImg(String img){
		  this.img = img; 
	}
	/*状态*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}
	/**/
	public String getTitle(){
		 return this.title; 
	}
	public void setTitle(String title){
		  this.title = title; 
	}
	/**/
	public String getSubtitle(){
		 return this.subtitle; 
	}
	public void setSubtitle(String subtitle){
		  this.subtitle = subtitle; 
	}
	/*是否显示首页*/
	public Integer getShowMain(){
		 return this.showMain; 
	}
	public void setShowMain(Integer showMain){
		  this.showMain = showMain; 
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
