package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;

/**
*系统角色表
**/
public class CRole extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "角色ID",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "关联系统",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "角色名称",dbName = "name",length = 32,allowNull=true)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "角色描述",dbName = "desc",length = 255,allowNull=true)
	private String desc=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CRole(){
 	}
 	public CRole(Integer id,Integer type,String name,String desc){
 		this.id = id;
		this.type = type;
		this.name = name;
		this.desc = desc;
		
 	}
 	
		/*角色ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*关联系统*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*角色名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*角色描述*/
	public String getDesc(){
		 return this.desc; 
	}
	public void setDesc(String desc){
		  this.desc = desc; 
	}

}
