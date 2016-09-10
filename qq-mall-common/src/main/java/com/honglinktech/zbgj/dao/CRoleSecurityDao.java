package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.CRoleSecurity;
/**
*角色权限关联表Dao
**/
@Component
public class CRoleSecurityDao extends BaseDao<CRoleSecurity>{
	public enum DBMaping{
		tableName("c_role_security",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		roleId("role_id",Types.INTEGER,false,false,true),
		securityId("security_id",Types.INTEGER,false,false,true);
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
	
	public class CRoleSecurityRowMapper implements RowMapper<CRoleSecurity> {  
        @Override  
        public CRoleSecurity mapRow(ResultSet rs, int rowNum) throws SQLException {  

			CRoleSecurity cRoleSecurity = new CRoleSecurity();
			cRoleSecurity.setId(rs.getInt("id"));
			cRoleSecurity.setRoleId(rs.getInt("role_id"));
			cRoleSecurity.setSecurityId(rs.getInt("security_id"));
			return cRoleSecurity; 
        }  
          
    }  
	@Override
	protected RowMapper<CRoleSecurity> getRowMapper() {
		return new CRoleSecurityRowMapper();
	}
}