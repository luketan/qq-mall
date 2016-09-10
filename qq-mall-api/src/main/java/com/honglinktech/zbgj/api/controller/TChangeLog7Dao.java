package com.honglinktech.zbgj.api.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TChangeLog7;
/**
*变更变更日志[饭卡、饭票、经验、成长点、声望、道具、联盟]Dao
**/
@Component
public class TChangeLog7Dao extends BaseDao<TChangeLog7>{
	public enum DBMaping{
		tableName("t_change_log_7",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		teamId("team_id",Types.INTEGER,false,false,false),
		objectId("object_id",Types.INTEGER,false,false,false),
		type("type",Types.SMALLINT,false,false,false),
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
	
	public class TChangeLog7RowMapper implements RowMapper<TChangeLog7> {  
        @Override  
        public TChangeLog7 mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TChangeLog7 tChangeLog7 = new TChangeLog7();
			tChangeLog7.setId(rs.getInt("id"));
			tChangeLog7.setTeamId(rs.getInt("team_id"));
			tChangeLog7.setObjectId(rs.getInt("object_id"));
			tChangeLog7.setType(rs.getInt("type"));
			tChangeLog7.setLogType(rs.getInt("log_type"));
			tChangeLog7.setBeforeNum(rs.getInt("before_num"));
			tChangeLog7.setNum(rs.getInt("num"));
			tChangeLog7.setCurrNum(rs.getInt("curr_num"));
			tChangeLog7.setLevel(rs.getInt("level"));
			tChangeLog7.setComments(rs.getString("comments"));
			tChangeLog7.setCreateTime(rs.getTimestamp("create_time"));
			return tChangeLog7; 
        }  
          
    }  
	@Override
	protected RowMapper<TChangeLog7> getRowMapper() {
		return new TChangeLog7RowMapper();
	}
}
