package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*管理员表
**/
public class CAdmin extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "管理员ID",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "用户名",dbName = "user_name",length = 20,allowNull=false)
	private String userName;
	@FieldMeta(primaryKey = false,fieldName = "账户名",dbName = "account",length = 20,allowNull=false)
	private String account;
	@FieldMeta(primaryKey = false,fieldName = "密码",dbName = "password",length = 20,allowNull=false)
	private String password;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "email",length = 50,allowNull=true)
	private String email;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "phone",length = 20,allowNull=true)
	private String phone;
	@FieldMeta(primaryKey = false,fieldName = "管理员状态",dbName = "status",length = 10,allowNull=true)
	private Integer status;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CAdmin(){
 	}
 	public CAdmin(Integer id,String userName,String account,String password,String email,String phone,Integer status){
 		this.id = id;
		this.userName = userName;
		this.account = account;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.status = status;
		
 	}
 	
		/*管理员ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*用户名*/
	public String getUserName(){
		 return this.userName; 
	}
	public void setUserName(String userName){
		  this.userName = userName; 
	}
	/*账户名*/
	public String getAccount(){
		 return this.account; 
	}
	public void setAccount(String account){
		  this.account = account; 
	}
	/*密码*/
	public String getPassword(){
		 return this.password; 
	}
	public void setPassword(String password){
		  this.password = password; 
	}
	/**/
	public String getEmail(){
		 return this.email; 
	}
	public void setEmail(String email){
		  this.email = email; 
	}
	/**/
	public String getPhone(){
		 return this.phone; 
	}
	public void setPhone(String phone){
		  this.phone = phone; 
	}
	/*管理员状态*/
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
