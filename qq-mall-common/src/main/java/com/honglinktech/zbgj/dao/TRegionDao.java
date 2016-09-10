package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TRegion;
/**
*Dao
**/
@Component
public class TRegionDao extends BaseDao<TRegion>{
	public enum DBMaping{
		tableName("t_region",0,false,false,false),
		regionId("region_id",Types.DOUBLE,true,false,false),
		regionCode("region_code",Types.VARCHAR,false,false,false),
		regionName("region_name",Types.VARCHAR,false,false,false),
		parentId("parent_id",Types.DOUBLE,false,false,false),
		regionLevel("region_level",Types.DOUBLE,false,false,false),
		regionOrder("region_order",Types.DOUBLE,false,false,false),
		regionNameEn("region_name_en",Types.VARCHAR,false,false,false),
		regionShortnameEn("region_shortname_en",Types.VARCHAR,false,false,false);
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
	
	public class TRegionRowMapper implements RowMapper<TRegion> {  
        @Override  
        public TRegion mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TRegion tRegion = new TRegion();
			tRegion.setRegionId(rs.getDouble("region_id"));
			tRegion.setRegionCode(rs.getString("region_code"));
			tRegion.setRegionName(rs.getString("region_name"));
			tRegion.setParentId(rs.getDouble("parent_id"));
			tRegion.setRegionLevel(rs.getDouble("region_level"));
			tRegion.setRegionOrder(rs.getDouble("region_order"));
			tRegion.setRegionNameEn(rs.getString("region_name_en"));
			tRegion.setRegionShortnameEn(rs.getString("region_shortname_en"));
			return tRegion; 
        }  
          
    }  
	@Override
	protected RowMapper<TRegion> getRowMapper() {
		return new TRegionRowMapper();
	}
}
