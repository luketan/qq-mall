package com.honglinktech.zbgj.api.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietySubject;
/**
*Dao
**/
@Component
public class TSocietySubjectDao extends BaseDao<TSocietySubject>{
	public enum DBMaping{
		tableName("t_society_subject",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,true),
		icon("icon",Types.VARCHAR,false,false,true),
		synopsis("synopsis",Types.VARCHAR,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		sort("sort",Types.INTEGER,false,false,true),
		hotNum("hot_num",Types.INTEGER,false,false,true),
		awardType("award_type",Types.INTEGER,false,false,true),
		awardNum("award_num",Types.INTEGER,false,false,true),
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
	
	public class TSocietySubjectRowMapper implements RowMapper<TSocietySubject> {  
        @Override  
        public TSocietySubject mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSocietySubject tSocietySubject = new TSocietySubject();
			tSocietySubject.setId(rs.getInt("id"));
			tSocietySubject.setName(rs.getString("name"));
			tSocietySubject.setIcon(rs.getString("icon"));
			tSocietySubject.setSynopsis(rs.getString("synopsis"));
			tSocietySubject.setType(rs.getInt("type"));
			tSocietySubject.setStatus(rs.getInt("status"));
			tSocietySubject.setSort(rs.getInt("sort"));
			tSocietySubject.setHotNum(rs.getInt("hot_num"));
			tSocietySubject.setAwardType(rs.getInt("award_type"));
			tSocietySubject.setAwardNum(rs.getInt("award_num"));
			tSocietySubject.setCreateTime(rs.getTimestamp("create_time"));
			tSocietySubject.setUpdateTime(rs.getTimestamp("update_time"));
			return tSocietySubject; 
        }  
          
    }  
	@Override
	protected RowMapper<TSocietySubject> getRowMapper() {
		return new TSocietySubjectRowMapper();
	}
}
