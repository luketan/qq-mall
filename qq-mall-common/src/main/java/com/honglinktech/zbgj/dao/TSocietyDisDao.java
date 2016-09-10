package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietyDis;
/**
*回帖内容，根据帖子id，分表 注意分表Dao
**/
@Component
public class TSocietyDisDao extends BaseDao<TSocietyDis>{
	public enum DBMaping{
		tableName("t_society_dis",0,false,false,false),
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
	
	public class TSocietyDisRowMapper implements RowMapper<TSocietyDis> {  
        @Override  
        public TSocietyDis mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSocietyDis tSocietyDis = new TSocietyDis();
			tSocietyDis.setId(rs.getInt("id"));
			tSocietyDis.setSocietyNoteId(rs.getInt("society_note_id"));
			tSocietyDis.setUserId(rs.getInt("user_id"));
			tSocietyDis.setUserName(rs.getString("user_name"));
			tSocietyDis.setContent(rs.getString("content"));
			tSocietyDis.setLikeUser(rs.getString("like_user"));
			tSocietyDis.setParent(rs.getInt("parent"));
			tSocietyDis.setReplyUserId(rs.getInt("reply_user_id"));
			tSocietyDis.setReplyUserName(rs.getString("reply_user_name"));
			tSocietyDis.setCreateTime(rs.getTimestamp("create_time"));
			tSocietyDis.setUpdateTime(rs.getTimestamp("update_time"));
			return tSocietyDis; 
        }  
          
    }  
	@Override
	protected RowMapper<TSocietyDis> getRowMapper() {
		return new TSocietyDisRowMapper();
	}
}
