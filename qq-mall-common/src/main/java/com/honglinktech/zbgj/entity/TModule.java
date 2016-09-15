package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*api端模块管理
**/
public class TModule extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "ID",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "模块名称（管理后台可见）",dbName = "name",length = 32,allowNull=true)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "标题",dbName = "title",length = 64,allowNull=true)
	private String title=null;
	@FieldMeta(primaryKey = false,fieldName = "模块跳转",dbName = "url",length = 128,allowNull=true)
	private String url=null;
	@FieldMeta(primaryKey = false,fieldName = "内容（）",dbName = "content",length = 65535,allowNull=true)
	private String content=null;
	@FieldMeta(primaryKey = false,fieldName = "类型(1.首页)",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "主题类型(1首页)",dbName = "main_type",length = 10,allowNull=true)
	private Integer mainType=null;
	@FieldMeta(primaryKey = false,fieldName = "排序",dbName = "sort",length = 10,allowNull=true)
	private Integer sort=null;
	@FieldMeta(primaryKey = false,fieldName = "备注",dbName = "remark",length = 255,allowNull=true)
	private String remark=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TModule(){
 	}
 	public TModule(Integer id,String name,String title,String url,String content,Integer type,Integer mainType,Integer sort,String remark){
 		this.id = id;
		this.name = name;
		this.title = title;
		this.url = url;
		this.content = content;
		this.type = type;
		this.mainType = mainType;
		this.sort = sort;
		this.remark = remark;
		
 	}
 	
		/*ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*模块名称（管理后台可见）*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*标题*/
	public String getTitle(){
		 return this.title; 
	}
	public void setTitle(String title){
		  this.title = title; 
	}
	/*模块跳转*/
	public String getUrl(){
		 return this.url; 
	}
	public void setUrl(String url){
		  this.url = url; 
	}
	/*内容（）*/
	public String getContent(){
		 return this.content; 
	}
	public void setContent(String content){
		  this.content = content; 
	}
	/*类型(1.首页)*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*主题类型(1首页)*/
	public Integer getMainType(){
		 return this.mainType; 
	}
	public void setMainType(Integer mainType){
		  this.mainType = mainType; 
	}
	/*排序*/
	public Integer getSort(){
		 return this.sort; 
	}
	public void setSort(Integer sort){
		  this.sort = sort; 
	}
	/*备注*/
	public String getRemark(){
		 return this.remark; 
	}
	public void setRemark(String remark){
		  this.remark = remark; 
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
