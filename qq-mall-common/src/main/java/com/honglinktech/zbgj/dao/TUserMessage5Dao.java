package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserMessage5;
/**
*用户聊天记录，用户id分表Dao
**/
@Component
public class TUserMessage5Dao extends BaseDao<TUserMessage5>{
	public enum DBMaping{
		tableName("t_user_message_5",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userId("user_id",Types.INTEGER,false,false,false),
		receiveUserId("receive_user_id",Types.INTEGER,false,false,false),
		content("content",Types.VARCHAR,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		valNum("val_num",Types.INTEGER,false,false,true),
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
	
	public class TUserMessage5RowMapper implements RowMapper<TUserMessage5> {  
        @Override  
        public TUserMessage5 mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserMessage5 tUserMessage5 = new TUserMessage5();
			tUserMessage5.setId(rs.getInt("id"));
			tUserMessage5.setUserId(rs.getInt("user_id"));
			tUserMessage5.setReceiveUserId(rs.getInt("receive_user_id"));
			tUserMessage5.setContent(rs.getString("content"));
			tUserMessage5.setType(rs.getInt("type"));
			tUserMessage5.setValNum(rs.getInt("val_num"));
			tUserMessage5.setReadIs(rs.getInt("read_is"));
			tUserMessage5.setCreateTime(rs.getTimestamp("create_time"));
			tUserMessage5.setUpdateTime(rs.getTimestamp("update_time"));
			return tUserMessage5; 
        }  
          
    }  
	@Override
	protected RowMapper<TUserMessage5> getRowMapper() {
		return new TUserMessage5RowMapper();
	}
}
