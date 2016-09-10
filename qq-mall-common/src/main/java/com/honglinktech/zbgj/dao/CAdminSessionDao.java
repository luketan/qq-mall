package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.CAdminSession;
/**
*管理员回话信息Dao
**/
@Component
public class CAdminSessionDao extends BaseDao<CAdminSession>{
	public enum DBMaping{
		tableName("c_admin_session",0,false,false,false),
		adminId("admin_id",Types.INTEGER,true,false,false),
		token("token",Types.VARCHAR,false,false,false),
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
	
	public class CAdminSessionRowMapper implements RowMapper<CAdminSession> {  
        @Override  
        public CAdminSession mapRow(ResultSet rs, int rowNum) throws SQLException {  

			CAdminSession cAdminSession = new CAdminSession();
			cAdminSession.setAdminId(rs.getInt("admin_id"));
			cAdminSession.setToken(rs.getString("token"));
			cAdminSession.setUpdateTime(rs.getTimestamp("update_time"));
			cAdminSession.setCreateTime(rs.getTimestamp("create_time"));
			return cAdminSession; 
        }  
          
    }  
	@Override
	protected RowMapper<CAdminSession> getRowMapper() {
		return new CAdminSessionRowMapper();
	}
}
