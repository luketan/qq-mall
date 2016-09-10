package com.honglinktech.zbgj.api.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGActivity;
/**
*活动Dao
**/
@Component
public class TGActivityDao extends BaseDao<TGActivity>{
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
	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		super.jdbcTemplate = jdbcTemplate;
	}
	public JdbcTemplate jdbcTemplate(){
		return jdbcTemplate;
	}
	
	public class TGActivityRowMapper implements RowMapper<TGActivity> {  
        @Override  
        public TGActivity mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TGActivity tGActivity = new TGActivity();
			tGActivity.setId(rs.getInt("id"));
			tGActivity.setName(rs.getString("name"));
			tGActivity.setType(rs.getInt("type"));
			tGActivity.setArgs(rs.getString("args"));
			tGActivity.setDetail(rs.getString("detail"));
			tGActivity.setAvailable(rs.getInt("available"));
			tGActivity.setStartTime(rs.getTimestamp("start_time"));
			tGActivity.setEndTime(rs.getTimestamp("end_time"));
			tGActivity.setStatus(rs.getInt("status"));
			tGActivity.setCreateTime(rs.getTimestamp("create_time"));
			tGActivity.setUpdateTime(rs.getTimestamp("update_time"));
			return tGActivity; 
        }  
          
    }  
	@Override
	protected RowMapper<TGActivity> getRowMapper() {
		return new TGActivityRowMapper();
	}
}
