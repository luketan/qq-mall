package com.honglinktech.zbgj.api.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.CAdmin;
/**
*管理员表Dao
**/
@Component
public class CAdminDao extends BaseDao<CAdmin>{
	public enum DBMaping{
		tableName("c_admin",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userName("user_name",Types.VARCHAR,false,false,false),
		account("account",Types.VARCHAR,false,false,false),
		password("password",Types.VARCHAR,false,false,false),
		email("email",Types.VARCHAR,false,false,true),
		phone("phone",Types.VARCHAR,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		updateTime("update_time",Types.TIMESTAMP,false,false,true),
		createTime("create_time",Types.TIMESTAMP,false,false,true);
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
	
	public class CAdminRowMapper implements RowMapper<CAdmin> {  
        @Override  
        public CAdmin mapRow(ResultSet rs, int rowNum) throws SQLException {  

			CAdmin cAdmin = new CAdmin();
			cAdmin.setId(rs.getInt("id"));
			cAdmin.setUserName(rs.getString("user_name"));
			cAdmin.setAccount(rs.getString("account"));
			cAdmin.setPassword(rs.getString("password"));
			cAdmin.setEmail(rs.getString("email"));
			cAdmin.setPhone(rs.getString("phone"));
			cAdmin.setStatus(rs.getInt("status"));
			cAdmin.setUpdateTime(rs.getTimestamp("update_time"));
			cAdmin.setCreateTime(rs.getTimestamp("create_time"));
			return cAdmin; 
        }  
          
    }  
	@Override
	protected RowMapper<CAdmin> getRowMapper() {
		return new CAdminRowMapper();
	}
}
