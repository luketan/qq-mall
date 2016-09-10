package com.honglinktech.zbgj.api.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietyReward;
/**
*社区打赏Dao
**/
@Component
public class TSocietyRewardDao extends BaseDao<TSocietyReward>{
	public enum DBMaping{
		tableName("t_society_reward",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		societyNoteId("society_note_id",Types.INTEGER,false,false,false),
		userId("user_id",Types.INTEGER,false,false,false),
		busUserId("bus_user_id",Types.INTEGER,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		valNum("val_num",Types.INTEGER,false,false,true),
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
	
	public class TSocietyRewardRowMapper implements RowMapper<TSocietyReward> {  
        @Override  
        public TSocietyReward mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSocietyReward tSocietyReward = new TSocietyReward();
			tSocietyReward.setId(rs.getInt("id"));
			tSocietyReward.setSocietyNoteId(rs.getInt("society_note_id"));
			tSocietyReward.setUserId(rs.getInt("user_id"));
			tSocietyReward.setBusUserId(rs.getInt("bus_user_id"));
			tSocietyReward.setType(rs.getInt("type"));
			tSocietyReward.setValNum(rs.getInt("val_num"));
			tSocietyReward.setCreateTime(rs.getTimestamp("create_time"));
			tSocietyReward.setUpdateTime(rs.getTimestamp("update_time"));
			return tSocietyReward; 
        }  
          
    }  
	@Override
	protected RowMapper<TSocietyReward> getRowMapper() {
		return new TSocietyRewardRowMapper();
	}
}
