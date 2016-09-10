package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGoodsDiscuss;
/**
*商品评论表Dao
**/
@Component
public class TGoodsDiscussDao extends BaseDao<TGoodsDiscuss>{
	public enum DBMaping{
		tableName("t_goods_discuss",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		goodsId("goods_id",Types.INTEGER,false,false,false),
		userId("user_id",Types.INTEGER,false,false,false),
		userName("user_name",Types.VARCHAR,false,false,true),
		goodsFormatId("goods_format_id",Types.INTEGER,false,false,true),
		goodsFormat("goods_format",Types.VARCHAR,false,false,true),
		content("content",Types.VARCHAR,false,false,true),
		typeValue("type_value",Types.VARCHAR,false,false,true),
		discussValue("discuss_value",Types.INTEGER,false,false,true),
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
	
	public class TGoodsDiscussRowMapper implements RowMapper<TGoodsDiscuss> {  
        @Override  
        public TGoodsDiscuss mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TGoodsDiscuss tGoodsDiscuss = new TGoodsDiscuss();
			tGoodsDiscuss.setId(rs.getInt("id"));
			tGoodsDiscuss.setGoodsId(rs.getInt("goods_id"));
			tGoodsDiscuss.setUserId(rs.getInt("user_id"));
			tGoodsDiscuss.setUserName(rs.getString("user_name"));
			tGoodsDiscuss.setGoodsFormatId(rs.getInt("goods_format_id"));
			tGoodsDiscuss.setGoodsFormat(rs.getString("goods_format"));
			tGoodsDiscuss.setContent(rs.getString("content"));
			tGoodsDiscuss.setTypeValue(rs.getString("type_value"));
			tGoodsDiscuss.setDiscussValue(rs.getInt("discuss_value"));
			tGoodsDiscuss.setCreateTime(rs.getTimestamp("create_time"));
			tGoodsDiscuss.setUpdateTime(rs.getTimestamp("update_time"));
			return tGoodsDiscuss; 
        }  
          
    }  
	@Override
	protected RowMapper<TGoodsDiscuss> getRowMapper() {
		return new TGoodsDiscussRowMapper();
	}
}
