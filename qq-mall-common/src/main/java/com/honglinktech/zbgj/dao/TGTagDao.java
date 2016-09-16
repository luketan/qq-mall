package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGTag;
/**
*商品表情Dao
**/
@Component
public class TGTagDao extends BaseDao<TGTag>{
	public enum DBMaping{
		tableName("t_g_tag",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,false),
		type("type",Types.INTEGER,false,false,false),
		img("img",Types.VARCHAR,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		title("title",Types.VARCHAR,false,false,true),
		subtitle("subtitle",Types.VARCHAR,false,false,true),
		showMain("show_main",Types.INTEGER,false,false,true),
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
	
	public class TGTagRowMapper implements RowMapper<TGTag> {  
        @Override  
        public TGTag mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TGTag tGTag = new TGTag();
			tGTag.setId(rs.getInt("id"));
			tGTag.setName(rs.getString("name"));
			tGTag.setType(rs.getInt("type"));
			tGTag.setImg(rs.getString("img"));
			tGTag.setStatus(rs.getInt("status"));
			tGTag.setTitle(rs.getString("title"));
			tGTag.setSubtitle(rs.getString("subtitle"));
			tGTag.setShowMain(rs.getInt("show_main"));
			tGTag.setUpdateTime(rs.getTimestamp("update_time"));
			tGTag.setCreateTime(rs.getTimestamp("create_time"));
			return tGTag; 
        }  
          
    }  
	@Override
	protected RowMapper<TGTag> getRowMapper() {
		return new TGTagRowMapper();
	}
}
