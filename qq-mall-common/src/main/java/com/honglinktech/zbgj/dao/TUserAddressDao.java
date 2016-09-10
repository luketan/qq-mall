package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserAddress;
/**
*用户地址Dao
**/
@Component
public class TUserAddressDao extends BaseDao<TUserAddress>{
	public enum DBMaping{
		tableName("t_user_address",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userId("user_id",Types.INTEGER,false,false,false),
		provinceName("province_name",Types.VARCHAR,false,false,true),
		provinceCode("province_code",Types.VARCHAR,false,false,true),
		cityName("city_name",Types.VARCHAR,false,false,true),
		cityCode("city_code",Types.VARCHAR,false,false,true),
		regionCode("region_code",Types.VARCHAR,false,false,true),
		regionName("region_name",Types.VARCHAR,false,false,true),
		road("road",Types.VARCHAR,false,false,true),
		phone("phone",Types.VARCHAR,false,false,false),
		zipcode("zipcode",Types.INTEGER,false,false,true),
		defaultIs("default_is",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
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
	
	public class TUserAddressRowMapper implements RowMapper<TUserAddress> {  
        @Override  
        public TUserAddress mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserAddress tUserAddress = new TUserAddress();
			tUserAddress.setId(rs.getInt("id"));
			tUserAddress.setUserId(rs.getInt("user_id"));
			tUserAddress.setProvinceName(rs.getString("province_name"));
			tUserAddress.setProvinceCode(rs.getString("province_code"));
			tUserAddress.setCityName(rs.getString("city_name"));
			tUserAddress.setCityCode(rs.getString("city_code"));
			tUserAddress.setRegionCode(rs.getString("region_code"));
			tUserAddress.setRegionName(rs.getString("region_name"));
			tUserAddress.setRoad(rs.getString("road"));
			tUserAddress.setPhone(rs.getString("phone"));
			tUserAddress.setZipcode(rs.getInt("zipcode"));
			tUserAddress.setDefaultIs(rs.getInt("default_is"));
			tUserAddress.setStatus(rs.getInt("status"));
			tUserAddress.setUpdateTime(rs.getTimestamp("update_time"));
			tUserAddress.setCreateTime(rs.getTimestamp("create_time"));
			return tUserAddress; 
        }  
          
    }  
	@Override
	protected RowMapper<TUserAddress> getRowMapper() {
		return new TUserAddressRowMapper();
	}
}
