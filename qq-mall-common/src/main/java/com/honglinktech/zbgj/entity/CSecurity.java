package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;

/**
*系统权限表
**/
public class CSecurity extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "父节点ID",dbName = "parent_id",length = 10,allowNull=true)
	private Integer parentId;
	@FieldMeta(primaryKey = false,fieldName = "权限类型(1.后台管理,2.商户管理)",dbName = "type",length = 10,allowNull=true)
	private Integer type;
	@FieldMeta(primaryKey = false,fieldName = "权限名称",dbName = "name",length = 32,allowNull=true)
	private String name;
	@FieldMeta(primaryKey = false,fieldName = "权限编码",dbName = "code",length = 32,allowNull=true)
	private String code;
	@FieldMeta(primaryKey = false,fieldName = "权限说明",dbName = "description",length = 255,allowNull=true)
	private String description;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CSecurity(){
 	}
 	public CSecurity(Integer id,Integer parentId,Integer type,String name,String code,String description){
 		this.id = id;
		this.parentId = parentId;
		this.type = type;
		this.name = name;
		this.code = code;
		this.description = description;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*父节点ID*/
	public Integer getParentId(){
		 return this.parentId; 
	}
	public void setParentId(Integer parentId){
		  this.parentId = parentId; 
	}
	/*权限类型(1.后台管理,2.商户管理)*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*权限名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*权限编码*/
	public String getCode(){
		 return this.code; 
	}
	public void setCode(String code){
		  this.code = code; 
	}
	/*权限说明*/
	public String getDescription(){
		 return this.description; 
	}
	public void setDescription(String description){
		  this.description = description; 
	}

}
