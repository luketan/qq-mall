package com.honglinktech.zbgj.api.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserRec;
/**
*注册用户推荐奖励Dao
**/
@Component
public class TUserRecDao extends BaseDao<TUserRec>{
	public enum DBMaping{
		tableName("t_user_rec",0,false,false,false),
		userId("user_id",Types.INTEGER,false,false,true),
		recUserId("rec_user_id",Types.INTEGER,false,false,true),
		recUserName("rec_user_name",Types.VARCHAR,false,false,true),
		awardType("award_type",Types.INTEGER,false,false,true),
		awardNum("award_num",Types.INTEGER,false,false,true),
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
	
	public class TUserRecRowMapper implements RowMapper<TUserRec> {  
        @Override  
        public TUserRec mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserRec tUserRec = new TUserRec();
			tUserRec.setUserId(rs.getInt("user_id"));
			tUserRec.setRecUserId(rs.getInt("rec_user_id"));
			tUserRec.setRecUserName(rs.getString("rec_user_name"));
			tUserRec.setAwardType(rs.getInt("award_type"));
			tUserRec.setAwardNum(rs.getInt("award_num"));
			tUserRec.setCreateTime(rs.getTimestamp("create_time"));
			return tUserRec; 
        }  
          
    }  
	@Override
	protected RowMapper<TUserRec> getRowMapper() {
		return new TUserRecRowMapper();
	}
}
