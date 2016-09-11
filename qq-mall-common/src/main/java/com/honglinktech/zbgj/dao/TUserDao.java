package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUser;
/**
*Dao
**/
public class TUserDao extends BaseDao<TUser>{
	public enum DBMaping{
		tableName("t_user",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		nickName("nick_name",Types.VARCHAR,false,false,true),
		account("account",Types.VARCHAR,false,false,false),
		password("password",Types.VARCHAR,false,false,false),
		sign("sign",Types.VARCHAR,false,false,true),
		head("head",Types.VARCHAR,false,false,true),
		virtualMoney("virtual_money",Types.DECIMAL,false,false,true),
		money("money",Types.DECIMAL,false,false,true),
		point("point",Types.INTEGER,false,false,true),
		exp("exp",Types.INTEGER,false,false,true),
		level("level",Types.INTEGER,false,false,true),
		email("email",Types.VARCHAR,false,false,true),
		isEmail("is_email",Types.INTEGER,false,false,true),
		phone("phone",Types.VARCHAR,false,false,true),
		phoneIs("phone_is",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		from("from",Types.VARCHAR,false,false,true),
		sex("sex",Types.INTEGER,false,false,true),
		sexu("sexu",Types.INTEGER,false,false,true),
		tryIs("try_is",Types.INTEGER,false,false,true),
		type("type",Types.INTEGER,false,false,true),
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
	
	public class TUserRowMapper implements RowMapper<TUser> {  
        @Override  
        public TUser mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUser tUser = new TUser();
			tUser.setId(rs.getInt("id"));
			tUser.setNickName(rs.getString("nick_name"));
			tUser.setAccount(rs.getString("account"));
			tUser.setPassword(rs.getString("password"));
			tUser.setSign(rs.getString("sign"));
			tUser.setHead(rs.getString("head"));
			tUser.setVirtualMoney(rs.getBigDecimal("virtual_money"));
			tUser.setMoney(rs.getBigDecimal("money"));
			tUser.setPoint(rs.getInt("point"));
			tUser.setExp(rs.getInt("exp"));
			tUser.setLevel(rs.getInt("level"));
			tUser.setEmail(rs.getString("email"));
			tUser.setIsEmail(rs.getInt("is_email"));
			tUser.setPhone(rs.getString("phone"));
			tUser.setPhoneIs(rs.getInt("phone_is"));
			tUser.setStatus(rs.getInt("status"));
			tUser.setFrom(rs.getString("from"));
			tUser.setSex(rs.getInt("sex"));
			tUser.setSexu(rs.getInt("sexu"));
			tUser.setTryIs(rs.getInt("try_is"));
			tUser.setType(rs.getInt("type"));
			tUser.setUpdateTime(rs.getTimestamp("update_time"));
			tUser.setCreateTime(rs.getTimestamp("create_time"));
			return tUser; 
        }  
          
    }  
	@Override
	protected RowMapper<TUser> getRowMapper() {
		return new TUserRowMapper();
	}
}
