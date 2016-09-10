package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.CAdminSessionLog;
/**
*登录日志表Dao
**/
@Component
public class CAdminSessionLogDao extends BaseDao<CAdminSessionLog>{
	public enum DBMaping{
		tableName("c_admin_session_log",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		adminId("admin_id",Types.INTEGER,false,false,false),
		token("token",Types.VARCHAR,false,false,false),
		loginIp("login_ip",Types.VARCHAR,false,false,true),
		form("form",Types.INTEGER,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		unique("unique",Types.VARCHAR,false,false,true),
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
	
	public class CAdminSessionLogRowMapper implements RowMapper<CAdminSessionLog> {  
        @Override  
        public CAdminSessionLog mapRow(ResultSet rs, int rowNum) throws SQLException {  

			CAdminSessionLog cAdminSessionLog = new CAdminSessionLog();
			cAdminSessionLog.setId(rs.getInt("id"));
			cAdminSessionLog.setAdminId(rs.getInt("admin_id"));
			cAdminSessionLog.setToken(rs.getString("token"));
			cAdminSessionLog.setLoginIp(rs.getString("login_ip"));
			cAdminSessionLog.setForm(rs.getInt("form"));
			cAdminSessionLog.setType(rs.getInt("type"));
			cAdminSessionLog.setUnique(rs.getString("unique"));
			cAdminSessionLog.setCreateTime(rs.getTimestamp("create_time"));
			return cAdminSessionLog; 
        }  
          
    }  
	@Override
	protected RowMapper<CAdminSessionLog> getRowMapper() {
		return new CAdminSessionLogRowMapper();
	}
}
