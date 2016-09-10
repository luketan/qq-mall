package com.honglinktech.zbgj.api.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietyDiscuss4;
/**
*Dao
**/
@Component
public class TSocietyDiscuss4Dao extends BaseDao<TSocietyDiscuss4>{
	public enum DBMaping{
		tableName("t_society_discuss_4",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		societyNoteId("society_note_id",Types.INTEGER,false,false,true),
		userId("user_id",Types.INTEGER,false,false,true),
		userName("user_name",Types.VARCHAR,false,false,true),
		content("content",Types.VARCHAR,false,false,true),
		likeUser("like_user",Types.VARCHAR,false,false,true),
		parent("parent",Types.INTEGER,false,false,true),
		replyUserId("reply_user_id",Types.INTEGER,false,false,true),
		replyUserName("reply_user_name",Types.VARCHAR,false,false,true),
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
	
	public class TSocietyDiscuss4RowMapper implements RowMapper<TSocietyDiscuss4> {  
        @Override  
        public TSocietyDiscuss4 mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSocietyDiscuss4 tSocietyDiscuss4 = new TSocietyDiscuss4();
			tSocietyDiscuss4.setId(rs.getInt("id"));
			tSocietyDiscuss4.setSocietyNoteId(rs.getInt("society_note_id"));
			tSocietyDiscuss4.setUserId(rs.getInt("user_id"));
			tSocietyDiscuss4.setUserName(rs.getString("user_name"));
			tSocietyDiscuss4.setContent(rs.getString("content"));
			tSocietyDiscuss4.setLikeUser(rs.getString("like_user"));
			tSocietyDiscuss4.setParent(rs.getInt("parent"));
			tSocietyDiscuss4.setReplyUserId(rs.getInt("reply_user_id"));
			tSocietyDiscuss4.setReplyUserName(rs.getString("reply_user_name"));
			tSocietyDiscuss4.setCreateTime(rs.getTimestamp("create_time"));
			tSocietyDiscuss4.setUpdateTime(rs.getTimestamp("update_time"));
			return tSocietyDiscuss4; 
        }  
          
    }  
	@Override
	protected RowMapper<TSocietyDiscuss4> getRowMapper() {
		return new TSocietyDiscuss4RowMapper();
	}
}
