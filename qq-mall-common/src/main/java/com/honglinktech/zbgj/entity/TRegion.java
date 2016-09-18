package com.honglinktech.zbgj.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;

/**
*
**/
public class TRegion extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "region_id",length = 22,allowNull=false)
	private Double regionId=null;
	@FieldMeta(primaryKey = false,fieldName = "身份证码",dbName = "region_code",length = 100,allowNull=false)
	private String regionCode=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "region_name",length = 100,allowNull=false)
	private String regionName=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "parent_id",length = 22,allowNull=false)
	private Double parentId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "region_level",length = 22,allowNull=false)
	private Double regionLevel=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "region_order",length = 22,allowNull=false)
	private Double regionOrder=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "region_name_en",length = 100,allowNull=false)
	private String regionNameEn=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "region_shortname_en",length = 10,allowNull=false)
	private String regionShortnameEn=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TRegion(){
 	}
 	public TRegion(Double regionId,String regionCode,String regionName,Double parentId,Double regionLevel,Double regionOrder,String regionNameEn,String regionShortnameEn){
 		this.regionId = regionId;
		this.regionCode = regionCode;
		this.regionName = regionName;
		this.parentId = parentId;
		this.regionLevel = regionLevel;
		this.regionOrder = regionOrder;
		this.regionNameEn = regionNameEn;
		this.regionShortnameEn = regionShortnameEn;
		
 	}
 	
		/**/
	public Double getRegionId(){
		 return this.regionId; 
	}
	public void setRegionId(Double regionId){
		  this.regionId = regionId; 
	}
	/*身份证码*/
	public String getRegionCode(){
		 return this.regionCode; 
	}
	public void setRegionCode(String regionCode){
		  this.regionCode = regionCode; 
	}
	/**/
	public String getRegionName(){
		 return this.regionName; 
	}
	public void setRegionName(String regionName){
		  this.regionName = regionName; 
	}
	/**/
	public Double getParentId(){
		 return this.parentId; 
	}
	public void setParentId(Double parentId){
		  this.parentId = parentId; 
	}
	/**/
	public Double getRegionLevel(){
		 return this.regionLevel; 
	}
	public void setRegionLevel(Double regionLevel){
		  this.regionLevel = regionLevel; 
	}
	/**/
	public Double getRegionOrder(){
		 return this.regionOrder; 
	}
	public void setRegionOrder(Double regionOrder){
		  this.regionOrder = regionOrder; 
	}
	/**/
	public String getRegionNameEn(){
		 return this.regionNameEn; 
	}
	public void setRegionNameEn(String regionNameEn){
		  this.regionNameEn = regionNameEn; 
	}
	/**/
	public String getRegionShortnameEn(){
		 return this.regionShortnameEn; 
	}
	public void setRegionShortnameEn(String regionShortnameEn){
		  this.regionShortnameEn = regionShortnameEn; 
	}

	
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
	public static class TRegionRowMapper implements RowMapper<TRegion> {  
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
}
