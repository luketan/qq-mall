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
*登录日志表
**/
public class TUserSessionLog extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "用户Id",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "访问标识",dbName = "token",length = 128,allowNull=false)
	private String token=null;
	@FieldMeta(primaryKey = false,fieldName = "IP",dbName = "login_ip",length = 64,allowNull=true)
	private String loginIp=null;
	@FieldMeta(primaryKey = false,fieldName = "1是ios，2是Android，3是微信，4是pc",dbName = "form",length = 10,allowNull=true)
	private Integer form=null;
	@FieldMeta(primaryKey = false,fieldName = "类型[登入：1，登出：2]",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "unique",length = 64,allowNull=true)
	private String unique=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
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

	
	public enum DBMaping{
		tableName("t_user_session_log",0,false,false,false),
		id("id",Types.INTEGER,true,false,false),
		userId("user_id",Types.INTEGER,false,false,false),
		token("token",Types.VARCHAR,false,false,false),
		loginIp("login_ip",Types.VARCHAR,false,false,true),
		form("form",Types.INTEGER,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		unique("unique",Types.VARCHAR,false,false,true),
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
	public static class TUserSessionLogRowMapper implements RowMapper<TUserSessionLog> {  
        @Override  
        public TUserSessionLog mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserSessionLog tUserSessionLog = new TUserSessionLog();
			tUserSessionLog.setId(rs.getInt("id"));
			tUserSessionLog.setUserId(rs.getInt("user_id"));
			tUserSessionLog.setToken(rs.getString("token"));
			tUserSessionLog.setLoginIp(rs.getString("login_ip"));
			tUserSessionLog.setForm(rs.getInt("form"));
			tUserSessionLog.setType(rs.getInt("type"));
			tUserSessionLog.setUnique(rs.getString("unique"));
			tUserSessionLog.setCreateTime(rs.getTimestamp("create_time"));
			return tUserSessionLog; 
        }  
          
    }
}
