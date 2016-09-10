package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserSocMsg;
/**
*用户社区消息Dao
**/
@Component
public class TUserSocMsgDao extends BaseDao<TUserSocMsg>{
	public enum DBMaping{
		tableName("t_user_soc_msg",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		societyNoteId("society_note_id",Types.INTEGER,false,false,true),
		userId("user_id",Types.INTEGER,false,false,false),
		type("type",Types.INTEGER,false,false,true),
		content("content",Types.VARCHAR,false,false,true),
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
	
	public class TUserSocMsgRowMapper implements RowMapper<TUserSocMsg> {  
        @Override  
        public TUserSocMsg mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserSocMsg tUserSocMsg = new TUserSocMsg();
			tUserSocMsg.setId(rs.getInt("id"));
			tUserSocMsg.setSocietyNoteId(rs.getInt("society_note_id"));
			tUserSocMsg.setUserId(rs.getInt("user_id"));
			tUserSocMsg.setType(rs.getInt("type"));
			tUserSocMsg.setContent(rs.getString("content"));
			tUserSocMsg.setCreateTime(rs.getTimestamp("create_time"));
			tUserSocMsg.setUpdateTime(rs.getTimestamp("update_time"));
			return tUserSocMsg; 
        }  
          
    }  
	@Override
	protected RowMapper<TUserSocMsg> getRowMapper() {
		return new TUserSocMsgRowMapper();
	}
}
