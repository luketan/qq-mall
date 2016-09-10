package com.honglinktech.zbgj.api.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TOrderItem;
/**
*订单详情Dao
**/
@Component
public class TOrderItemDao extends BaseDao<TOrderItem>{
	public enum DBMaping{
		tableName("t_order_item",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		orderId("order_id",Types.INTEGER,false,false,false),
		goodsId("goods_id",Types.INTEGER,false,false,false),
		goodsName("goods_name",Types.VARCHAR,false,false,false),
		formatId("format_id",Types.INTEGER,false,false,false),
		goodsFormat("goods_format",Types.VARCHAR,false,false,true),
		number("number",Types.INTEGER,false,false,false),
		marketPrice("market_price",Types.DECIMAL,false,false,true),
		price("price",Types.DECIMAL,false,false,true),
		remark("remark",Types.VARCHAR,false,false,true),
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
	
	public class TOrderItemRowMapper implements RowMapper<TOrderItem> {  
        @Override  
        public TOrderItem mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TOrderItem tOrderItem = new TOrderItem();
			tOrderItem.setId(rs.getInt("id"));
			tOrderItem.setOrderId(rs.getInt("order_id"));
			tOrderItem.setGoodsId(rs.getInt("goods_id"));
			tOrderItem.setGoodsName(rs.getString("goods_name"));
			tOrderItem.setFormatId(rs.getInt("format_id"));
			tOrderItem.setGoodsFormat(rs.getString("goods_format"));
			tOrderItem.setNumber(rs.getInt("number"));
			tOrderItem.setMarketPrice(rs.getBigDecimal("market_price"));
			tOrderItem.setPrice(rs.getBigDecimal("price"));
			tOrderItem.setRemark(rs.getString("remark"));
			tOrderItem.setUpdateTime(rs.getTimestamp("update_time"));
			tOrderItem.setCreateTime(rs.getTimestamp("create_time"));
			return tOrderItem; 
        }  
          
    }  
	@Override
	protected RowMapper<TOrderItem> getRowMapper() {
		return new TOrderItemRowMapper();
	}
}
