package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TCoupon;
/**
*优惠券Dao
**/
@Component
public class TCouponDao extends BaseDao<TCoupon>{
	public enum DBMaping{
		tableName("t_coupon",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		value("value",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		startDate("start_date",Types.TIMESTAMP,false,false,true),
		endDate("end_date",Types.TIMESTAMP,false,false,true),
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
	
	public class TCouponRowMapper implements RowMapper<TCoupon> {  
        @Override  
        public TCoupon mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TCoupon tCoupon = new TCoupon();
			tCoupon.setId(rs.getInt("id"));
			tCoupon.setName(rs.getString("name"));
			tCoupon.setType(rs.getInt("type"));
			tCoupon.setValue(rs.getInt("value"));
			tCoupon.setStatus(rs.getInt("status"));
			tCoupon.setStartDate(rs.getTimestamp("start_date"));
			tCoupon.setEndDate(rs.getTimestamp("end_date"));
			tCoupon.setCreateTime(rs.getTimestamp("create_time"));
			tCoupon.setUpdateTime(rs.getTimestamp("update_time"));
			return tCoupon; 
        }  
          
    }  
	@Override
	protected RowMapper<TCoupon> getRowMapper() {
		return new TCouponRowMapper();
	}
}
