package com.honglinktech.zbgj.api.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGType;
/**
*商品类别表Dao
**/
@Component
public class TGTypeDao extends BaseDao<TGType>{
	public enum DBMaping{
		tableName("t_g_type",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,false),
		ico("ico",Types.VARCHAR,false,false,true),
		img("img",Types.VARCHAR,false,false,true),
		topIs("top_is",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		updateTime("update_time",Types.TIMESTAMP,false,false,true),
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
	
	public class TGTypeRowMapper implements RowMapper<TGType> {  
        @Override  
        public TGType mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TGType tGType = new TGType();
			tGType.setId(rs.getInt("id"));
			tGType.setName(rs.getString("name"));
			tGType.setIco(rs.getString("ico"));
			tGType.setImg(rs.getString("img"));
			tGType.setTopIs(rs.getInt("top_is"));
			tGType.setStatus(rs.getInt("status"));
			tGType.setUpdateTime(rs.getTimestamp("update_time"));
			tGType.setCreateTime(rs.getTimestamp("create_time"));
			return tGType; 
        }  
          
    }  
	@Override
	protected RowMapper<TGType> getRowMapper() {
		return new TGTypeRowMapper();
	}
}
