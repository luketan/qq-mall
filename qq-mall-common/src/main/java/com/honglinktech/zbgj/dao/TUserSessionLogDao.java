package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserSessionLog;
/**
*登录日志表Dao
**/
@Component
public class TUserSessionLogDao extends BaseDao<TUserSessionLog>{
	public enum DBMaping{
		tableName("t_user_session_log",0,false,false,false),
		id("id",Types.INTEGER,true,false,false),
		userId("user_id",Types.INTEGER,false,false,false),
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
	
	public class TUserSessionLogRowMapper implements RowMapper<TUserSessionLog> {  
        @Override  
        public TUserSessionLog mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserSessionLog tUserSessionLog = new TUserSessionLog();
			tUserSessionLog.setId(rs.getInt("id"));
			tUserSessionLog.setUserId(rs.getInt("user_id"));
			tUserSessionLog.setToken(rs.getString("token"));
			tUserSessionLog.setLoginIp(rs.getString("login_ip"));
			tUserSessionLog.setForm(rs.getInt("form"));
			tUserSessionLog.setType(rs.getInt("type"));
			tUserSessionLog.setUnique(rs.getString("unique"));
			tUserSessionLog.setCreateTime(rs.getTimestamp("create_time"));
			return tUserSessionLog; 
        }  
          
    }  
	@Override
	protected RowMapper<TUserSessionLog> getRowMapper() {
		return new TUserSessionLogRowMapper();
	}
}
