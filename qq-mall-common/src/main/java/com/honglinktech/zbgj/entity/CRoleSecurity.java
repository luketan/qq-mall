package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;

/**
*角色权限关联表
**/
public class CRoleSecurity extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "角色ID",dbName = "role_id",length = 10,allowNull=true)
	private Integer roleId;
	@FieldMeta(primaryKey = false,fieldName = "权限ID",dbName = "security_id",length = 10,allowNull=true)
	private Integer securityId;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CRoleSecurity(){
 	}
 	public CRoleSecurity(Integer id,Integer roleId,Integer securityId){
 		this.id = id;
		this.roleId = roleId;
		this.securityId = securityId;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*角色ID*/
	public Integer getRoleId(){
		 return this.roleId; 
	}
	public void setRoleId(Integer roleId){
		  this.roleId = roleId; 
	}
	/*权限ID*/
	public Integer getSecurityId(){
		 return this.securityId; 
	}
	public void setSecurityId(Integer securityId){
		  this.securityId = securityId; 
	}

}
