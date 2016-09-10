package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserFriend;
/**
*经理的朋友Dao
**/
@Component
public class TUserFriendDao extends BaseDao<TUserFriend>{
	public enum DBMaping{
		tableName("t_user_friend",0,false,false,false),
		userId("user_id",Types.INTEGER,true,false,false),
		friendUserId("friend_user_id",Types.INTEGER,true,false,false),
		type("type",Types.INTEGER,false,false,false),
		friendUserName("friend_user_name",Types.VARCHAR,false,false,true),
		friendUserHead("friend_user_head",Types.VARCHAR,false,false,true),
		friendUserLevel("friend_user_level",Types.INTEGER,false,false,true),
		friendMoney("friend_money",Types.INTEGER,false,false,true),
		updateTime("update_time",Types.TIMESTAMP,false,false,false),
		createTime("create_time",Types.TIMESTAMP,false,false,false);
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
	
	public class TUserFriendRowMapper implements RowMapper<TUserFriend> {  
        @Override  
        public TUserFriend mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserFriend tUserFriend = new TUserFriend();
			tUserFriend.setUserId(rs.getInt("user_id"));
			tUserFriend.setFriendUserId(rs.getInt("friend_user_id"));
			tUserFriend.setType(rs.getInt("type"));
			tUserFriend.setFriendUserName(rs.getString("friend_user_name"));
			tUserFriend.setFriendUserHead(rs.getString("friend_user_head"));
			tUserFriend.setFriendUserLevel(rs.getInt("friend_user_level"));
			tUserFriend.setFriendMoney(rs.getInt("friend_money"));
			tUserFriend.setUpdateTime(rs.getTimestamp("update_time"));
			tUserFriend.setCreateTime(rs.getTimestamp("create_time"));
			return tUserFriend; 
        }  
          
    }  
	@Override
	protected RowMapper<TUserFriend> getRowMapper() {
		return new TUserFriendRowMapper();
	}
}
