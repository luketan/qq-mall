package com.honglinktech.zbgj.api.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGoodsActivity;
/**
*商品活动Dao
**/
@Component
public class TGoodsActivityDao extends BaseDao<TGoodsActivity>{
	public enum DBMaping{
		tableName("t_goods_activity",0,false,false,false),
		goodsId("goods_id",Types.INTEGER,true,false,false),
		activityId("activity_id",Types.INTEGER,true,false,false),
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
	
	public class TGoodsActivityRowMapper implements RowMapper<TGoodsActivity> {  
        @Override  
        public TGoodsActivity mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TGoodsActivity tGoodsActivity = new TGoodsActivity();
			tGoodsActivity.setGoodsId(rs.getInt("goods_id"));
			tGoodsActivity.setActivityId(rs.getInt("activity_id"));
			tGoodsActivity.setCreateTime(rs.getTimestamp("create_time"));
			tGoodsActivity.setUpdateTime(rs.getTimestamp("update_time"));
			return tGoodsActivity; 
        }  
          
    }  
	@Override
	protected RowMapper<TGoodsActivity> getRowMapper() {
		return new TGoodsActivityRowMapper();
	}
}
