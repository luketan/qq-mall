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
*用户关注的主题
**/
public class TSocietySubUser extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "society_subject_id",length = 10,allowNull=false)
	private Integer societySubjectId=null;
	@FieldMeta(primaryKey = true,fieldName = "",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "社区圈共享值",dbName = "val",length = 10,allowNull=true)
	private Integer val=null;
	@FieldMeta(primaryKey = false,fieldName = "用在在板块的身份，1是正常，2是版主",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TSocietySubUser(){
 	}
 	public TSocietySubUser(Integer societySubjectId,Integer userId,Integer val,Integer type){
 		this.societySubjectId = societySubjectId;
		this.userId = userId;
		this.val = val;
		this.type = type;
		
 	}
 	
		/**/
	public Integer getSocietySubjectId(){
		 return this.societySubjectId; 
	}
	public void setSocietySubjectId(Integer societySubjectId){
		  this.societySubjectId = societySubjectId; 
	}
	/**/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*社区圈共享值*/
	public Integer getVal(){
		 return this.val; 
	}
	public void setVal(Integer val){
		  this.val = val; 
	}
	/*用在在板块的身份，1是正常，2是版主*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}
	/*修改时间*/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}

	
	public enum DBMaping{
		tableName("t_society_sub_user",0,false,false,false),
		societySubjectId("society_subject_id",Types.INTEGER,true,true,false),
		userId("user_id",Types.INTEGER,true,false,false),
		val("val",Types.INTEGER,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		createTime("create_time",Types.TIMESTAMP,false,false,true),
		updateTime("update_time",Types.TIMESTAMP,false,false,true);
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
	public static class TSocietySubUserRowMapper implements RowMapper<TSocietySubUser> {  
        @Override  
        public TSocietySubUser mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSocietySubUser tSocietySubUser = new TSocietySubUser();
			tSocietySubUser.setSocietySubjectId(rs.getInt("society_subject_id"));
			tSocietySubUser.setUserId(rs.getInt("user_id"));
			tSocietySubUser.setVal(rs.getInt("val"));
			tSocietySubUser.setType(rs.getInt("type"));
			tSocietySubUser.setCreateTime(rs.getTimestamp("create_time"));
			tSocietySubUser.setUpdateTime(rs.getTimestamp("update_time"));
			return tSocietySubUser; 
        }  
          
    }
}
