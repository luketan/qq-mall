package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGoodsTag;
/**
*商品活动Dao
**/
@Component
public class TGoodsTagDao extends BaseDao<TGoodsTag>{
	public enum DBMaping{
		tableName("t_goods_tag",0,false,false,false),
		goodsId("goods_id",Types.INTEGER,true,false,false),
		tagId("tag_id",Types.INTEGER,true,false,false),
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
	
	public class TGoodsTagRowMapper implements RowMapper<TGoodsTag> {  
        @Override  
        public TGoodsTag mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TGoodsTag tGoodsTag = new TGoodsTag();
			tGoodsTag.setGoodsId(rs.getInt("goods_id"));
			tGoodsTag.setTagId(rs.getInt("tag_id"));
			tGoodsTag.setCreateTime(rs.getTimestamp("create_time"));
			tGoodsTag.setUpdateTime(rs.getTimestamp("update_time"));
			return tGoodsTag; 
        }  
          
    }  
	@Override
	protected RowMapper<TGoodsTag> getRowMapper() {
		return new TGoodsTagRowMapper();
	}
}
