package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserCollect;
/**
*用户的收藏Dao
**/
@Component
public class TUserCollectDao extends BaseDao<TUserCollect>{
	public enum DBMaping{
		tableName("t_user_collect",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userId("user_id",Types.INTEGER,false,false,true),
		objId("obj_id",Types.INTEGER,false,false,true),
		objType("obj_type",Types.INTEGER,false,false,true),
		objTypeName("obj_type_name",Types.VARCHAR,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		name("name",Types.VARCHAR,false,false,true),
		imgUrl("img_url",Types.VARCHAR,false,false,true),
		price("price",Types.DECIMAL,false,false,true),
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
	
	public class TUserCollectRowMapper implements RowMapper<TUserCollect> {  
        @Override  
        public TUserCollect mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserCollect tUserCollect = new TUserCollect();
			tUserCollect.setId(rs.getInt("id"));
			tUserCollect.setUserId(rs.getInt("user_id"));
			tUserCollect.setObjId(rs.getInt("obj_id"));
			tUserCollect.setObjType(rs.getInt("obj_type"));
			tUserCollect.setObjTypeName(rs.getString("obj_type_name"));
			tUserCollect.setType(rs.getInt("type"));
			tUserCollect.setName(rs.getString("name"));
			tUserCollect.setImgUrl(rs.getString("img_url"));
			tUserCollect.setPrice(rs.getBigDecimal("price"));
			tUserCollect.setCreateTime(rs.getTimestamp("create_time"));
			tUserCollect.setUpdateTime(rs.getTimestamp("update_time"));
			return tUserCollect; 
        }  
          
    }  
	@Override
	protected RowMapper<TUserCollect> getRowMapper() {
		return new TUserCollectRowMapper();
	}
}
