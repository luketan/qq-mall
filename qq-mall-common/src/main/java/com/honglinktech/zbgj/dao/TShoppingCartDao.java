package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TShoppingCart;
/**
*Dao
**/
@Component
public class TShoppingCartDao extends BaseDao<TShoppingCart>{
	public enum DBMaping{
		tableName("t_shopping_cart",0,false,false,false),
		id("id",Types.INTEGER,true,false,false),
		userId("user_id",Types.INTEGER,false,false,true),
		goodsId("goods_id",Types.INTEGER,false,false,true),
		goodsName("goods_name",Types.VARCHAR,false,false,true),
		imageUrl("image_url",Types.VARCHAR,false,false,true),
		price("price",Types.DECIMAL,false,false,true),
		markPrice("mark_price",Types.DECIMAL,false,false,true),
		formatId("format_id",Types.INTEGER,false,false,true),
		formatName("format_name",Types.VARCHAR,false,false,true),
		num("num",Types.INTEGER,false,false,true),
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
	
	public class TShoppingCartRowMapper implements RowMapper<TShoppingCart> {  
        @Override  
        public TShoppingCart mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TShoppingCart tShoppingCart = new TShoppingCart();
			tShoppingCart.setId(rs.getInt("id"));
			tShoppingCart.setUserId(rs.getInt("user_id"));
			tShoppingCart.setGoodsId(rs.getInt("goods_id"));
			tShoppingCart.setGoodsName(rs.getString("goods_name"));
			tShoppingCart.setImageUrl(rs.getString("image_url"));
			tShoppingCart.setPrice(rs.getBigDecimal("price"));
			tShoppingCart.setMarkPrice(rs.getBigDecimal("mark_price"));
			tShoppingCart.setFormatId(rs.getInt("format_id"));
			tShoppingCart.setFormatName(rs.getString("format_name"));
			tShoppingCart.setNum(rs.getInt("num"));
			tShoppingCart.setCreateTime(rs.getTimestamp("create_time"));
			tShoppingCart.setUpdateTime(rs.getTimestamp("update_time"));
			return tShoppingCart; 
        }  
          
    }  
	@Override
	protected RowMapper<TShoppingCart> getRowMapper() {
		return new TShoppingCartRowMapper();
	}
}
