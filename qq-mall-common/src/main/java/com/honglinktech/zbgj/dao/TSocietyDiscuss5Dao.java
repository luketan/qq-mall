package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietyDiscuss5;
/**
*Dao
**/
@Component
public class TSocietyDiscuss5Dao extends BaseDao<TSocietyDiscuss5>{
	public enum DBMaping{
		tableName("t_society_discuss_5",0,false,false,false),
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
	
	public class TSocietyDiscuss5RowMapper implements RowMapper<TSocietyDiscuss5> {  
        @Override  
        public TSocietyDiscuss5 mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSocietyDiscuss5 tSocietyDiscuss5 = new TSocietyDiscuss5();
			tSocietyDiscuss5.setId(rs.getInt("id"));
			tSocietyDiscuss5.setSocietyNoteId(rs.getInt("society_note_id"));
			tSocietyDiscuss5.setUserId(rs.getInt("user_id"));
			tSocietyDiscuss5.setUserName(rs.getString("user_name"));
			tSocietyDiscuss5.setContent(rs.getString("content"));
			tSocietyDiscuss5.setLikeUser(rs.getString("like_user"));
			tSocietyDiscuss5.setParent(rs.getInt("parent"));
			tSocietyDiscuss5.setReplyUserId(rs.getInt("reply_user_id"));
			tSocietyDiscuss5.setReplyUserName(rs.getString("reply_user_name"));
			tSocietyDiscuss5.setCreateTime(rs.getTimestamp("create_time"));
			tSocietyDiscuss5.setUpdateTime(rs.getTimestamp("update_time"));
			return tSocietyDiscuss5; 
        }  
          
    }  
	@Override
	protected RowMapper<TSocietyDiscuss5> getRowMapper() {
		return new TSocietyDiscuss5RowMapper();
	}
}
