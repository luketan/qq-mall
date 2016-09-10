package com.honglinktech.zbgj.api.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TChangeLog;
/**
*变更变更日志[逗比、经验、vip]Dao
**/
@Component
public class TChangeLogDao extends BaseDao<TChangeLog>{
	public enum DBMaping{
		tableName("t_change_log",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userId("user_id",Types.INTEGER,false,false,false),
		objectId("object_id",Types.INTEGER,false,false,false),
		type("type",Types.INTEGER,false,false,false),
		logType("log_type",Types.INTEGER,false,false,false),
		beforeNum("before_num",Types.INTEGER,false,false,false),
		num("num",Types.INTEGER,false,false,false),
		currNum("curr_num",Types.INTEGER,false,false,false),
		level("level",Types.INTEGER,false,false,false),
		comments("comments",Types.VARCHAR,false,false,false),
		createTime("create_time",Types.TIMESTAMP,false,false,false);
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
	
	public class TChangeLogRowMapper implements RowMapper<TChangeLog> {  
        @Override  
        public TChangeLog mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TChangeLog tChangeLog = new TChangeLog();
			tChangeLog.setId(rs.getInt("id"));
			tChangeLog.setUserId(rs.getInt("user_id"));
			tChangeLog.setObjectId(rs.getInt("object_id"));
			tChangeLog.setType(rs.getInt("type"));
			tChangeLog.setLogType(rs.getInt("log_type"));
			tChangeLog.setBeforeNum(rs.getInt("before_num"));
			tChangeLog.setNum(rs.getInt("num"));
			tChangeLog.setCurrNum(rs.getInt("curr_num"));
			tChangeLog.setLevel(rs.getInt("level"));
			tChangeLog.setComments(rs.getString("comments"));
			tChangeLog.setCreateTime(rs.getTimestamp("create_time"));
			return tChangeLog; 
        }  
          
    }  
	@Override
	protected RowMapper<TChangeLog> getRowMapper() {
		return new TChangeLogRowMapper();
	}
}
