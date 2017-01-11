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
*用户关注
**/
public class TUserAtte extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "用户ID",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = true,fieldName = "好友ID",dbName = "atte_user_id",length = 10,allowNull=false)
	private Integer atteUserId=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserAtte(){
 	}
 	public TUserAtte(Integer userId,Integer atteUserId){
 		this.userId = userId;
		this.atteUserId = atteUserId;
		
 	}
 	
		/*用户ID*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*好友ID*/
	public Integer getAtteUserId(){
		 return this.atteUserId; 
	}
	public void setAtteUserId(Integer atteUserId){
		  this.atteUserId = atteUserId; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

	
	public enum DBMaping{
		tableName("t_user_atte",0,false,false,false),
		userId("user_id",Types.INTEGER,true,false,false),
		atteUserId("atte_user_id",Types.INTEGER,true,false,false),
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
	public static class TUserAtteRowMapper implements RowMapper<TUserAtte> {  
        @Override  
        public TUserAtte mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserAtte tUserAtte = new TUserAtte();
			tUserAtte.setUserId(rs.getInt("user_id"));
			tUserAtte.setAtteUserId(rs.getInt("atte_user_id"));
			tUserAtte.setCreateTime(rs.getTimestamp("create_time"));
			return tUserAtte; 
        }  
          
    }
}
