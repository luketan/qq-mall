package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.THint;
/**
*提示语Dao
**/
@Component
public class THintDao extends BaseDao<THint>{
	public enum DBMaping{
		tableName("t_hint",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		content("content",Types.VARCHAR,false,false,false),
		subType("sub_type",Types.INTEGER,false,false,true),
		remark("remark",Types.VARCHAR,false,false,true),
		type("type",Types.INTEGER,true,false,false),
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
	
	public class THintRowMapper implements RowMapper<THint> {  
        @Override  
        public THint mapRow(ResultSet rs, int rowNum) throws SQLException {  

			THint tHint = new THint();
			tHint.setId(rs.getInt("id"));
			tHint.setContent(rs.getString("content"));
			tHint.setSubType(rs.getInt("sub_type"));
			tHint.setRemark(rs.getString("remark"));
			tHint.setType(rs.getInt("type"));
			tHint.setCreateTime(rs.getTimestamp("create_time"));
			tHint.setUpdateTime(rs.getTimestamp("update_time"));
			return tHint; 
        }  
          
    }  
	@Override
	protected RowMapper<THint> getRowMapper() {
		return new THintRowMapper();
	}
}
