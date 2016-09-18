package com.honglinktech.zbgj.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*管理员表
**/
public class CAdmin extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "管理员ID",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "用户名",dbName = "user_name",length = 20,allowNull=false)
	private String userName=null;
	@FieldMeta(primaryKey = false,fieldName = "账户名",dbName = "account",length = 20,allowNull=false)
	private String account=null;
	@FieldMeta(primaryKey = false,fieldName = "密码",dbName = "password",length = 20,allowNull=false)
	private String password=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "email",length = 50,allowNull=true)
	private String email=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "phone",length = 20,allowNull=true)
	private String phone=null;
	@FieldMeta(primaryKey = false,fieldName = "管理员状态",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "更新时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
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

	
	public enum DBMaping{
		tableName("c_admin",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userName("user_name",Types.VARCHAR,false,false,false),
		account("account",Types.VARCHAR,false,false,false),
		password("password",Types.VARCHAR,false,false,false),
		email("email",Types.VARCHAR,false,false,true),
		phone("phone",Types.VARCHAR,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		updateTime("update_time",Types.TIMESTAMP,false,false,true),
		createTime("create_time",Types.TIMESTAMP,false,false,true);
		private String dbName;
		private int dbType;
		private boolean primaryKey;
		private boolean isAotuIn;
		private boolean isAllowNull;
	    public String getDbName(){
	    	 return this.dbName;
	    }
	    public int getDbType(){
	    	 return this.dbType;
	    }
	    public boolean getPrimaryKey(){
	    	 return this.primaryKey;
	    }
	    public boolean isAotuIn(){
	    	 return this.isAotuIn;
	    }
	    public boolean isAllowNull(){
	    	 return this.isAllowNull;
	    }
	    private DBMaping(String dbName,int dbType,boolean primaryKey,boolean isAotuIn,boolean isAllowNull){
	    	 this.dbName = dbName;
	    	 this.dbType = dbType;
	    	 this.primaryKey = primaryKey;
	    	 this.isAotuIn = isAotuIn;
	    	 this.isAllowNull = isAllowNull;
	    }
	}
	public Object[] getDBMapping(String filedName){
		for(DBMaping d:DBMaping.values()){
			if(d.toString().equals(filedName)){
				DBMaping dbMaping = DBMaping.valueOf(filedName);
				Object[] values = {dbMaping.dbName,dbMaping.dbType,dbMaping.primaryKey,dbMaping.isAotuIn,dbMaping.isAllowNull};
				return values;
			}
		}
		return null;
	}
	public static class CAdminRowMapper implements RowMapper<CAdmin> {  
        @Override  
        public CAdmin mapRow(ResultSet rs, int rowNum) throws SQLException {  

			CAdmin cAdmin = new CAdmin();
			cAdmin.setId(rs.getInt("id"));
			cAdmin.setUserName(rs.getString("user_name"));
			cAdmin.setAccount(rs.getString("account"));
			cAdmin.setPassword(rs.getString("password"));
			cAdmin.setEmail(rs.getString("email"));
			cAdmin.setPhone(rs.getString("phone"));
			cAdmin.setStatus(rs.getInt("status"));
			cAdmin.setUpdateTime(rs.getTimestamp("update_time"));
			cAdmin.setCreateTime(rs.getTimestamp("create_time"));
			return cAdmin; 
        }  
          
    }
}
