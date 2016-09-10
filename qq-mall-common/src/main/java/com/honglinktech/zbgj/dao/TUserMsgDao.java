package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserMsg;
/**
*用户聊天记录，用户id分表 注意分表Dao
**/
@Component
public class TUserMsgDao extends BaseDao<TUserMsg>{
	public enum DBMaping{
		tableName("t_user_msg",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userId("user_id",Types.INTEGER,false,false,false),
		receiveUserId("receive_user_id",Types.INTEGER,false,false,false),
		content("content",Types.VARCHAR,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		valNum("val_num",Types.INTEGER,false,false,true),
		readIs("read_is",Types.INTEGER,false,false,true),
		createTime("create_time",Types.TIMESTAMP,false,false,true),
		updateTime("update_time",Types.TIMESTAMP,false,false,true);
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
	
	public class TUserMsgRowMapper implements RowMapper<TUserMsg> {  
        @Override  
        public TUserMsg mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserMsg tUserMsg = new TUserMsg();
			tUserMsg.setId(rs.getInt("id"));
			tUserMsg.setUserId(rs.getInt("user_id"));
			tUserMsg.setReceiveUserId(rs.getInt("receive_user_id"));
			tUserMsg.setContent(rs.getString("content"));
			tUserMsg.setType(rs.getInt("type"));
			tUserMsg.setValNum(rs.getInt("val_num"));
			tUserMsg.setReadIs(rs.getInt("read_is"));
			tUserMsg.setCreateTime(rs.getTimestamp("create_time"));
			tUserMsg.setUpdateTime(rs.getTimestamp("update_time"));
			return tUserMsg; 
        }  
          
    }  
	@Override
	protected RowMapper<TUserMsg> getRowMapper() {
		return new TUserMsgRowMapper();
	}
}
