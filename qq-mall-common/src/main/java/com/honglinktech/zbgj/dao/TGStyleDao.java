package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGStyle;
/**
*商品款式Dao
**/
@Component
public class TGStyleDao extends BaseDao<TGStyle>{
	public enum DBMaping{
		tableName("t_g_style",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,false),
		goodsType("goods_type",Types.INTEGER,false,false,true),
		typeName("type_name",Types.VARCHAR,false,false,true),
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
	
	public class TGStyleRowMapper implements RowMapper<TGStyle> {  
        @Override  
        public TGStyle mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TGStyle tGStyle = new TGStyle();
			tGStyle.setId(rs.getInt("id"));
			tGStyle.setName(rs.getString("name"));
			tGStyle.setGoodsType(rs.getInt("goods_type"));
			tGStyle.setTypeName(rs.getString("type_name"));
			tGStyle.setStatus(rs.getInt("status"));
			tGStyle.setCreateTime(rs.getTimestamp("create_time"));
			tGStyle.setUpdateTime(rs.getTimestamp("update_time"));
			return tGStyle; 
        }  
          
    }  
	@Override
	protected RowMapper<TGStyle> getRowMapper() {
		return new TGStyleRowMapper();
	}
}
