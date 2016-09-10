package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.CAdminRole;
/**
*用户角色关联表Dao
**/
@Component
public class CAdminRoleDao extends BaseDao<CAdminRole>{
	public enum DBMaping{
		tableName("c_admin_role",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		adminId("admin_id",Types.INTEGER,false,false,true),
		roleId("role_id",Types.INTEGER,false,false,true);
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
	
	public class CAdminRoleRowMapper implements RowMapper<CAdminRole> {  
        @Override  
        public CAdminRole mapRow(ResultSet rs, int rowNum) throws SQLException {  

			CAdminRole cAdminRole = new CAdminRole();
			cAdminRole.setId(rs.getInt("id"));
			cAdminRole.setAdminId(rs.getInt("admin_id"));
			cAdminRole.setRoleId(rs.getInt("role_id"));
			return cAdminRole; 
        }  
          
    }  
	@Override
	protected RowMapper<CAdminRole> getRowMapper() {
		return new CAdminRoleRowMapper();
	}
}
