package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserAtte;
/**
*用户关注Dao
**/
@Component
public class TUserAtteDao extends BaseDao<TUserAtte>{
	public enum DBMaping{
		tableName("t_user_atte",0,false,false,false),
		userId("user_id",Types.INTEGER,true,false,false),
		atteUserId("atte_user_id",Types.INTEGER,true,false,false),
		type("type",Types.INTEGER,false,false,false),
		atteUserName("atte_user_name",Types.VARCHAR,false,false,true),
		atteUserHead("atte_user_head",Types.VARCHAR,false,false,true),
		atteUserLevel("atte_user_level",Types.INTEGER,false,false,true),
		atteMoney("atte_money",Types.INTEGER,false,false,true),
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
	
	public class TUserAtteRowMapper implements RowMapper<TUserAtte> {  
        @Override  
        public TUserAtte mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserAtte tUserAtte = new TUserAtte();
			tUserAtte.setUserId(rs.getInt("user_id"));
			tUserAtte.setAtteUserId(rs.getInt("atte_user_id"));
			tUserAtte.setType(rs.getInt("type"));
			tUserAtte.setAtteUserName(rs.getString("atte_user_name"));
			tUserAtte.setAtteUserHead(rs.getString("atte_user_head"));
			tUserAtte.setAtteUserLevel(rs.getInt("atte_user_level"));
			tUserAtte.setAtteMoney(rs.getInt("atte_money"));
			tUserAtte.setUpdateTime(rs.getTimestamp("update_time"));
			tUserAtte.setCreateTime(rs.getTimestamp("create_time"));
			return tUserAtte; 
        }  
          
    }  
	@Override
	protected RowMapper<TUserAtte> getRowMapper() {
		return new TUserAtteRowMapper();
	}
}
