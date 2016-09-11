package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*管理员回话信息
**/
public class CAdminSession extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "用户Id",dbName = "admin_id",length = 10,allowNull=false)
	private Integer adminId;
	@FieldMeta(primaryKey = false,fieldName = "访问标识",dbName = "token",length = 100,allowNull=false)
	private String token;
	@FieldMeta(primaryKey = false,fieldName = "更新时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CAdminSession(){
 	}
 	public CAdminSession(Integer adminId,String token){
 		this.adminId = adminId;
		this.token = token;
		
 	}
 	
		/*用户Id*/
	public Integer getAdminId(){
		 return this.adminId; 
	}
	public void setAdminId(Integer adminId){
		  this.adminId = adminId; 
	}
	/*访问标识*/
	public String getToken(){
		 return this.token; 
	}
	public void setToken(String token){
		  this.token = token; 
	}
	/*更新时间*/
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
