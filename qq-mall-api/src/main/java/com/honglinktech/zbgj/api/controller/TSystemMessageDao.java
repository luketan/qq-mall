package com.honglinktech.zbgj.api.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSystemMessage;
/**
*系统消息Dao
**/
@Component
public class TSystemMessageDao extends BaseDao<TSystemMessage>{
	public enum DBMaping{
		tableName("t_system_message",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userId("user_id",Types.INTEGER,false,false,false),
		content("content",Types.VARCHAR,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		readIs("read_is",Types.INTEGER,false,false,true),
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
	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		super.jdbcTemplate = jdbcTemplate;
	}
	public JdbcTemplate jdbcTemplate(){
		return jdbcTemplate;
	}
	
	public class TSystemMessageRowMapper implements RowMapper<TSystemMessage> {  
        @Override  
        public TSystemMessage mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSystemMessage tSystemMessage = new TSystemMessage();
			tSystemMessage.setId(rs.getInt("id"));
			tSystemMessage.setUserId(rs.getInt("user_id"));
			tSystemMessage.setContent(rs.getString("content"));
			tSystemMessage.setType(rs.getInt("type"));
			tSystemMessage.setReadIs(rs.getInt("read_is"));
			tSystemMessage.setCreateTime(rs.getTimestamp("create_time"));
			tSystemMessage.setUpdateTime(rs.getTimestamp("update_time"));
			return tSystemMessage; 
        }  
          
    }  
	@Override
	protected RowMapper<TSystemMessage> getRowMapper() {
		return new TSystemMessageRowMapper();
	}
}
