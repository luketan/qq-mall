package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*登录日志表
**/
public class TUserSessionLog extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "用户Id",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId;
	@FieldMeta(primaryKey = false,fieldName = "访问标识",dbName = "token",length = 128,allowNull=false)
	private String token;
	@FieldMeta(primaryKey = false,fieldName = "IP",dbName = "login_ip",length = 64,allowNull=true)
	private String loginIp;
	@FieldMeta(primaryKey = false,fieldName = "1是ios，2是Android，3是微信，4是pc",dbName = "form",length = 10,allowNull=true)
	private Integer form;
	@FieldMeta(primaryKey = false,fieldName = "类型[登入：1，登出：2]",dbName = "type",length = 10,allowNull=true)
	private Integer type;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "unique",length = 64,allowNull=true)
	private String unique;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserSessionLog(){
 	}
 	public TUserSessionLog(Integer id,Integer userId,String token,String loginIp,Integer form,Integer type,String unique){
 		this.id = id;
		this.userId = userId;
		this.token = token;
		this.loginIp = loginIp;
		this.form = form;
		this.type = type;
		this.unique = unique;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*用户Id*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*访问标识*/
	public String getToken(){
		 return this.token; 
	}
	public void setToken(String token){
		  this.token = token; 
	}
	/*IP*/
	public String getLoginIp(){
		 return this.loginIp; 
	}
	public void setLoginIp(String loginIp){
		  this.loginIp = loginIp; 
	}
	/*1是ios，2是Android，3是微信，4是pc*/
	public Integer getForm(){
		 return this.form; 
	}
	public void setForm(Integer form){
		  this.form = form; 
	}
	/*类型[登入：1，登出：2]*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/**/
	public String getUnique(){
		 return this.unique; 
	}
	public void setUnique(String unique){
		  this.unique = unique; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

}
