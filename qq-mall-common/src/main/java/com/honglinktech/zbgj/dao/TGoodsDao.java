package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGoods;
/**
*Dao
**/
@Component
public class TGoodsDao extends BaseDao<TGoods>{
	public enum DBMaping{
		tableName("t_goods",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,false),
		subName("sub_name",Types.VARCHAR,false,false,true),
		detail("detail",Types.LONGVARCHAR,false,false,true),
		salesNum("sales_num",Types.INTEGER,false,false,true),
		keepNum("keep_num",Types.INTEGER,false,false,true),
		markPrice("mark_price",Types.DECIMAL,false,false,true),
		formerPrice("former_price",Types.DECIMAL,false,false,true),
		price("price",Types.DECIMAL,false,false,true),
		discussNum("discuss_num",Types.INTEGER,false,false,true),
		promoName("promo_name",Types.VARCHAR,false,false,true),
		promoPrice("promo_price",Types.FLOAT,false,false,true),
		promoIs("promo_is",Types.INTEGER,false,false,true),
		hotIs("hot_is",Types.INTEGER,false,false,true),
		giftsIs("gifts_is",Types.INTEGER,false,false,true),
		brandId("brand_id",Types.INTEGER,false,false,true),
		brandName("brand_name",Types.VARCHAR,false,false,true),
		typeId("type_id",Types.INTEGER,false,false,true),
		typeName("type_name",Types.VARCHAR,false,false,true),
		styleId("style_id",Types.INTEGER,false,false,true),
		styleName("style_name",Types.VARCHAR,false,false,true),
		collectNum("collect_num",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		imgUrl("img_url",Types.VARCHAR,false,false,true),
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
	
	public class TGoodsRowMapper implements RowMapper<TGoods> {  
        @Override  
        public TGoods mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TGoods tGoods = new TGoods();
			tGoods.setId(rs.getInt("id"));
			tGoods.setName(rs.getString("name"));
			tGoods.setSubName(rs.getString("sub_name"));
			tGoods.setDetail(rs.getString("detail"));
			tGoods.setSalesNum(rs.getInt("sales_num"));
			tGoods.setKeepNum(rs.getInt("keep_num"));
			tGoods.setMarkPrice(rs.getBigDecimal("mark_price"));
			tGoods.setFormerPrice(rs.getBigDecimal("former_price"));
			tGoods.setPrice(rs.getBigDecimal("price"));
			tGoods.setDiscussNum(rs.getInt("discuss_num"));
			tGoods.setPromoName(rs.getString("promo_name"));
			tGoods.setPromoPrice(rs.getFloat("promo_price"));
			tGoods.setPromoIs(rs.getInt("promo_is"));
			tGoods.setHotIs(rs.getInt("hot_is"));
			tGoods.setGiftsIs(rs.getInt("gifts_is"));
			tGoods.setBrandId(rs.getInt("brand_id"));
			tGoods.setBrandName(rs.getString("brand_name"));
			tGoods.setTypeId(rs.getInt("type_id"));
			tGoods.setTypeName(rs.getString("type_name"));
			tGoods.setStyleId(rs.getInt("style_id"));
			tGoods.setStyleName(rs.getString("style_name"));
			tGoods.setCollectNum(rs.getInt("collect_num"));
			tGoods.setStatus(rs.getInt("status"));
			tGoods.setImgUrl(rs.getString("img_url"));
			tGoods.setUpdateTime(rs.getTimestamp("update_time"));
			tGoods.setCreateTime(rs.getTimestamp("create_time"));
			return tGoods; 
        }  
          
    }  
	@Override
	protected RowMapper<TGoods> getRowMapper() {
		return new TGoodsRowMapper();
	}
}
