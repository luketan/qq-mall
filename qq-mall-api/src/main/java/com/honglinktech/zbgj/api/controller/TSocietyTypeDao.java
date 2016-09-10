package com.honglinktech.zbgj.api.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietyType;
/**
*社区类型Dao
**/
@Component
public class TSocietyTypeDao extends BaseDao<TSocietyType>{
	public enum DBMaping{
		tableName("t_society_type",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,true),
		sort("sort",Types.INTEGER,false,false,true),
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
	
	public class TSocietyTypeRowMapper implements RowMapper<TSocietyType> {  
        @Override  
        public TSocietyType mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSocietyType tSocietyType = new TSocietyType();
			tSocietyType.setId(rs.getInt("id"));
			tSocietyType.setName(rs.getString("name"));
			tSocietyType.setSort(rs.getInt("sort"));
			tSocietyType.setStatus(rs.getInt("status"));
			tSocietyType.setCreateTime(rs.getTimestamp("create_time"));
			tSocietyType.setUpdateTime(rs.getTimestamp("update_time"));
			return tSocietyType; 
        }  
          
    }  
	@Override
	protected RowMapper<TSocietyType> getRowMapper() {
		return new TSocietyTypeRowMapper();
	}
}
