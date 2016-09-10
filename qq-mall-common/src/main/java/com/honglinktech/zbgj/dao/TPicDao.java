package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TPic;
/**
*商品图片Dao
**/
@Component
public class TPicDao extends BaseDao<TPic>{
	public enum DBMaping{
		tableName("t_pic",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		objId("obj_id",Types.INTEGER,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		picName("pic_name",Types.VARCHAR,false,false,true),
		picUrl("pic_url",Types.VARCHAR,false,false,true),
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
	
	public class TPicRowMapper implements RowMapper<TPic> {  
        @Override  
        public TPic mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TPic tPic = new TPic();
			tPic.setId(rs.getInt("id"));
			tPic.setObjId(rs.getInt("obj_id"));
			tPic.setType(rs.getInt("type"));
			tPic.setPicName(rs.getString("pic_name"));
			tPic.setPicUrl(rs.getString("pic_url"));
			tPic.setCreateTime(rs.getTimestamp("create_time"));
			tPic.setUpdateTime(rs.getTimestamp("update_time"));
			return tPic; 
        }  
          
    }  
	@Override
	protected RowMapper<TPic> getRowMapper() {
		return new TPicRowMapper();
	}
}
