package com.honglinktech.zbgj.api.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TCouponUser;
/**
*Dao
**/
@Component
public class TCouponUserDao extends BaseDao<TCouponUser>{
	public enum DBMaping{
		tableName("t_coupon_user",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		couponId("coupon_id",Types.INTEGER,false,false,false),
		couponName("coupon_name",Types.VARCHAR,false,false,true),
		value("value",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		startDate("start_date",Types.TIMESTAMP,false,false,true),
		endDate("end_date",Types.TIMESTAMP,false,false,true),
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
	
	public class TCouponUserRowMapper implements RowMapper<TCouponUser> {  
        @Override  
        public TCouponUser mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TCouponUser tCouponUser = new TCouponUser();
			tCouponUser.setId(rs.getInt("id"));
			tCouponUser.setCouponId(rs.getInt("coupon_id"));
			tCouponUser.setCouponName(rs.getString("coupon_name"));
			tCouponUser.setValue(rs.getInt("value"));
			tCouponUser.setStatus(rs.getInt("status"));
			tCouponUser.setStartDate(rs.getTimestamp("start_date"));
			tCouponUser.setEndDate(rs.getTimestamp("end_date"));
			tCouponUser.setUpdateTime(rs.getTimestamp("update_time"));
			tCouponUser.setCreateTime(rs.getTimestamp("create_time"));
			return tCouponUser; 
        }  
          
    }  
	@Override
	protected RowMapper<TCouponUser> getRowMapper() {
		return new TCouponUserRowMapper();
	}
}
