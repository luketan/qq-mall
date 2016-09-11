package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TModule;
/**
*api端模块管理Dao
**/
@Component
public class TModuleDao extends BaseDao<TModule>{
	public enum DBMaping{
		tableName("t_module",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,true),
		title("title",Types.VARCHAR,false,false,true),
		url("url",Types.VARCHAR,false,false,true),
		content("content",Types.LONGVARCHAR,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		mainType("main_type",Types.INTEGER,false,false,true),
		sort("sort",Types.INTEGER,false,false,true),
		remark("remark",Types.VARCHAR,false,false,true),
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
	
	public class TModuleRowMapper implements RowMapper<TModule> {  
        @Override  
        public TModule mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TModule tModule = new TModule();
			tModule.setId(rs.getInt("id"));
			tModule.setName(rs.getString("name"));
			tModule.setTitle(rs.getString("title"));
			tModule.setUrl(rs.getString("url"));
			tModule.setContent(rs.getString("content"));
			tModule.setType(rs.getInt("type"));
			tModule.setMainType(rs.getInt("main_type"));
			tModule.setSort(rs.getInt("sort"));
			tModule.setRemark(rs.getString("remark"));
			tModule.setCreateTime(rs.getTimestamp("create_time"));
			tModule.setUpdateTime(rs.getTimestamp("update_time"));
			return tModule; 
        }  
          
    }  
	@Override
	protected RowMapper<TModule> getRowMapper() {
		return new TModuleRowMapper();
	}
}
