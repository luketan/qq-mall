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
*管理员回话信息
**/
public class CAdminSession extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "用户Id",dbName = "admin_id",length = 10,allowNull=false)
	private Integer adminId=null;
	@FieldMeta(primaryKey = false,fieldName = "访问标识",dbName = "token",length = 100,allowNull=false)
	private String token=null;
	@FieldMeta(primaryKey = false,fieldName = "更新时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
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

	
	public enum DBMaping{
		tableName("c_admin_session",0,false,false,false),
		adminId("admin_id",Types.INTEGER,true,false,false),
		token("token",Types.VARCHAR,false,false,false),
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
	public static class CAdminSessionRowMapper implements RowMapper<CAdminSession> {  
        @Override  
        public CAdminSession mapRow(ResultSet rs, int rowNum) throws SQLException {  

			CAdminSession cAdminSession = new CAdminSession();
			cAdminSession.setAdminId(rs.getInt("admin_id"));
			cAdminSession.setToken(rs.getString("token"));
			cAdminSession.setUpdateTime(rs.getTimestamp("update_time"));
			cAdminSession.setCreateTime(rs.getTimestamp("create_time"));
			return cAdminSession; 
        }  
          
    }
}
