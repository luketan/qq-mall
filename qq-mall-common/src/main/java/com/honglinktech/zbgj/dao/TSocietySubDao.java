package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietySub;
/**
*Dao
**/
@Component
public class TSocietySubDao extends BaseDao<TSocietySub>{
	public enum DBMaping{
		tableName("t_society_sub",0,false,false,false),
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
	
	public class TSocietySubRowMapper implements RowMapper<TSocietySub> {  
        @Override  
        public TSocietySub mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSocietySub tSocietySub = new TSocietySub();
			tSocietySub.setId(rs.getInt("id"));
			tSocietySub.setName(rs.getString("name"));
			tSocietySub.setIcon(rs.getString("icon"));
			tSocietySub.setSynopsis(rs.getString("synopsis"));
			tSocietySub.setType(rs.getInt("type"));
			tSocietySub.setStatus(rs.getInt("status"));
			tSocietySub.setSort(rs.getInt("sort"));
			tSocietySub.setHotNum(rs.getInt("hot_num"));
			tSocietySub.setAwardType(rs.getInt("award_type"));
			tSocietySub.setAwardNum(rs.getInt("award_num"));
			tSocietySub.setCreateTime(rs.getTimestamp("create_time"));
			tSocietySub.setUpdateTime(rs.getTimestamp("update_time"));
			return tSocietySub; 
        }  
          
    }  
	@Override
	protected RowMapper<TSocietySub> getRowMapper() {
		return new TSocietySubRowMapper();
	}
}
