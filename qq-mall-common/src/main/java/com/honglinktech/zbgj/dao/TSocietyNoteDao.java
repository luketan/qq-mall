package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietyNote;
/**
*帖子Dao
**/
@Component
public class TSocietyNoteDao extends BaseDao<TSocietyNote>{
	public enum DBMaping{
		tableName("t_society_note",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		societySubjectId("society_subject_id",Types.INTEGER,false,false,false),
		userId("user_id",Types.INTEGER,false,false,false),
		userName("user_name",Types.VARCHAR,false,false,true),
		title("title",Types.VARCHAR,false,false,true),
		detail("detail",Types.VARCHAR,false,false,true),
		address("address",Types.VARCHAR,false,false,true),
		lookNum("look_num",Types.INTEGER,false,false,true),
		disNum("dis_num",Types.INTEGER,false,false,true),
		topIs("top_is",Types.INTEGER,false,false,true),
		recIs("rec_is",Types.INTEGER,false,false,true),
		giftsIs("gifts_is",Types.INTEGER,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
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
	
	public class TSocietyNoteRowMapper implements RowMapper<TSocietyNote> {  
        @Override  
        public TSocietyNote mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSocietyNote tSocietyNote = new TSocietyNote();
			tSocietyNote.setId(rs.getInt("id"));
			tSocietyNote.setSocietySubjectId(rs.getInt("society_subject_id"));
			tSocietyNote.setUserId(rs.getInt("user_id"));
			tSocietyNote.setUserName(rs.getString("user_name"));
			tSocietyNote.setTitle(rs.getString("title"));
			tSocietyNote.setDetail(rs.getString("detail"));
			tSocietyNote.setAddress(rs.getString("address"));
			tSocietyNote.setLookNum(rs.getInt("look_num"));
			tSocietyNote.setDisNum(rs.getInt("dis_num"));
			tSocietyNote.setTopIs(rs.getInt("top_is"));
			tSocietyNote.setRecIs(rs.getInt("rec_is"));
			tSocietyNote.setGiftsIs(rs.getInt("gifts_is"));
			tSocietyNote.setType(rs.getInt("type"));
			tSocietyNote.setStatus(rs.getInt("status"));
			tSocietyNote.setCreateTime(rs.getTimestamp("create_time"));
			tSocietyNote.setUpdateTime(rs.getTimestamp("update_time"));
			return tSocietyNote; 
        }  
          
    }  
	@Override
	protected RowMapper<TSocietyNote> getRowMapper() {
		return new TSocietyNoteRowMapper();
	}
}
