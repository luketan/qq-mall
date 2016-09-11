package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;

/**
*用户角色关联表
**/
public class CAdminRole extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "用户ID",dbName = "admin_id",length = 10,allowNull=true)
	private Integer adminId;
	@FieldMeta(primaryKey = false,fieldName = "角色ID",dbName = "role_id",length = 10,allowNull=true)
	private Integer roleId;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CAdminRole(){
 	}
 	public CAdminRole(Integer id,Integer adminId,Integer roleId){
 		this.id = id;
		this.adminId = adminId;
		this.roleId = roleId;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*用户ID*/
	public Integer getAdminId(){
		 return this.adminId; 
	}
	public void setAdminId(Integer adminId){
		  this.adminId = adminId; 
	}
	/*角色ID*/
	public Integer getRoleId(){
		 return this.roleId; 
	}
	public void setRoleId(Integer roleId){
		  this.roleId = roleId; 
	}

}
