package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.honglinktech.zbgj.common.Constants;


/**
*规格种类
**/
public class ActivityArgsBean implements Serializable{

	private Integer id;
	private String name;
	@JsonIgnore
	private Integer type;
	private String typeName;
	private String args;
	private String detail;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ActivityArgsBean(){
 	}
 	
		/*活动ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*活动名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*活动类型(1打折,2包邮,3赠送)*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*活动系数*/
	public String getArgs(){
		 return this.args; 
	}
	public void setArgs(String args){
		  this.args = args; 
	}
	/*活动详情*/
	public String getDetail(){
		 return this.detail; 
	}
	public void setDetail(String detail){
		  this.detail = detail; 
	}
	
	public String getTypeName() {
		return Constants.goodsActivityTypeName(type);
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public enum DBMaping{
		tableName("t_g_activity",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,false),
		type("type",Types.INTEGER,false,false,true),
		args("args",Types.VARCHAR,false,false,true),
		detail("detail",Types.VARCHAR,false,false,true),
		available("available",Types.INTEGER,false,false,true),
		startTime("start_time",Types.TIMESTAMP,false,false,true),
		endTime("end_time",Types.TIMESTAMP,false,false,true),
		status("status",Types.INTEGER,false,false,true),
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
	public static class ActivityBeanRowMapper implements RowMapper<ActivityArgsBean> {  
        @Override  
        public ActivityArgsBean mapRow(ResultSet rs, int rowNum) throws SQLException {  

        	ActivityArgsBean tGActivity = new ActivityArgsBean();
			tGActivity.setId(rs.getInt("id"));
			tGActivity.setName(rs.getString("name"));
			tGActivity.setType(rs.getInt("type"));
			tGActivity.setArgs(rs.getString("args"));
			tGActivity.setDetail(rs.getString("detail"));
			return tGActivity; 
        }  
          
    }
}
