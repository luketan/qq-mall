package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.CSecurity;
/**
*系统权限表Dao
**/
@Component
public class CSecurityDao extends BaseDao<CSecurity>{
	public enum DBMaping{
		tableName("c_security",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		parentId("parent_id",Types.INTEGER,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		name("name",Types.VARCHAR,false,false,true),
		code("code",Types.VARCHAR,false,false,true),
		desc("desc",Types.VARCHAR,false,false,true);
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
	
	public class CSecurityRowMapper implements RowMapper<CSecurity> {  
        @Override  
        public CSecurity mapRow(ResultSet rs, int rowNum) throws SQLException {  

			CSecurity cSecurity = new CSecurity();
			cSecurity.setId(rs.getInt("id"));
			cSecurity.setParentId(rs.getInt("parent_id"));
			cSecurity.setType(rs.getInt("type"));
			cSecurity.setName(rs.getString("name"));
			cSecurity.setCode(rs.getString("code"));
			cSecurity.setDesc(rs.getString("desc"));
			return cSecurity; 
        }  
          
    }  
	@Override
	protected RowMapper<CSecurity> getRowMapper() {
		return new CSecurityRowMapper();
	}
}
