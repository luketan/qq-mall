package com.honglinktech.zbgj.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*用户地址
**/
public class TUserAddress extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "用户地址ID",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "用户ID",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_name",length = 64,allowNull=true)
	private String userName=null;
	@FieldMeta(primaryKey = false,fieldName = "电话号码",dbName = "phone",length = 15,allowNull=false)
	private String phone=null;
	@FieldMeta(primaryKey = false,fieldName = "省名称",dbName = "province_name",length = 50,allowNull=true)
	private String provinceName=null;
	@FieldMeta(primaryKey = false,fieldName = "省ID",dbName = "province_code",length = 50,allowNull=true)
	private String provinceCode=null;
	@FieldMeta(primaryKey = false,fieldName = "市名称",dbName = "city_name",length = 50,allowNull=true)
	private String cityName=null;
	@FieldMeta(primaryKey = false,fieldName = "市ID",dbName = "city_code",length = 50,allowNull=true)
	private String cityCode=null;
	@FieldMeta(primaryKey = false,fieldName = "区ID",dbName = "region_code",length = 50,allowNull=true)
	private String regionCode=null;
	@FieldMeta(primaryKey = false,fieldName = "区名称",dbName = "region_name",length = 50,allowNull=true)
	private String regionName=null;
	@FieldMeta(primaryKey = false,fieldName = "街道",dbName = "road",length = 255,allowNull=true)
	private String road=null;
	@FieldMeta(primaryKey = false,fieldName = "邮编",dbName = "zipcode",length = 10,allowNull=true)
	private Integer zipcode=null;
	@FieldMeta(primaryKey = false,fieldName = "是否是默认地址",dbName = "default_is",length = 10,allowNull=true)
	private Integer defaultIs=null;
	@FieldMeta(primaryKey = false,fieldName = "状态(1正常，2删除)",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserAddress(){
 	}
 	public TUserAddress(Integer id,Integer userId,String userName,String phone,String provinceName,String provinceCode,String cityName,String cityCode,String regionCode,String regionName,String road,Integer zipcode,Integer defaultIs,Integer status){
 		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.phone = phone;
		this.provinceName = provinceName;
		this.provinceCode = provinceCode;
		this.cityName = cityName;
		this.cityCode = cityCode;
		this.regionCode = regionCode;
		this.regionName = regionName;
		this.road = road;
		this.zipcode = zipcode;
		this.defaultIs = defaultIs;
		this.status = status;
		
 	}
 	
		/*用户地址ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*用户ID*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/**/
	public String getUserName(){
		 return this.userName; 
	}
	public void setUserName(String userName){
		  this.userName = userName; 
	}
	/*电话号码*/
	public String getPhone(){
		 return this.phone; 
	}
	public void setPhone(String phone){
		  this.phone = phone; 
	}
	/*省名称*/
	public String getProvinceName(){
		 return this.provinceName; 
	}
	public void setProvinceName(String provinceName){
		  this.provinceName = provinceName; 
	}
	/*省ID*/
	public String getProvinceCode(){
		 return this.provinceCode; 
	}
	public void setProvinceCode(String provinceCode){
		  this.provinceCode = provinceCode; 
	}
	/*市名称*/
	public String getCityName(){
		 return this.cityName; 
	}
	public void setCityName(String cityName){
		  this.cityName = cityName; 
	}
	/*市ID*/
	public String getCityCode(){
		 return this.cityCode; 
	}
	public void setCityCode(String cityCode){
		  this.cityCode = cityCode; 
	}
	/*区ID*/
	public String getRegionCode(){
		 return this.regionCode; 
	}
	public void setRegionCode(String regionCode){
		  this.regionCode = regionCode; 
	}
	/*区名称*/
	public String getRegionName(){
		 return this.regionName; 
	}
	public void setRegionName(String regionName){
		  this.regionName = regionName; 
	}
	/*街道*/
	public String getRoad(){
		 return this.road; 
	}
	public void setRoad(String road){
		  this.road = road; 
	}
	/*邮编*/
	public Integer getZipcode(){
		 return this.zipcode; 
	}
	public void setZipcode(Integer zipcode){
		  this.zipcode = zipcode; 
	}
	/*是否是默认地址*/
	public Integer getDefaultIs(){
		 return this.defaultIs; 
	}
	public void setDefaultIs(Integer defaultIs){
		  this.defaultIs = defaultIs; 
	}
	/*状态(1正常，2删除)*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}
	/*修改时间*/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

	
	public enum DBMaping{
		tableName("t_user_address",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userId("user_id",Types.INTEGER,false,false,false),
		userName("user_name",Types.VARCHAR,false,false,true),
		phone("phone",Types.VARCHAR,false,false,false),
		provinceName("province_name",Types.VARCHAR,false,false,true),
		provinceCode("province_code",Types.VARCHAR,false,false,true),
		cityName("city_name",Types.VARCHAR,false,false,true),
		cityCode("city_code",Types.VARCHAR,false,false,true),
		regionCode("region_code",Types.VARCHAR,false,false,true),
		regionName("region_name",Types.VARCHAR,false,false,true),
		road("road",Types.VARCHAR,false,false,true),
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
	public static class TUserAddressRowMapper implements RowMapper<TUserAddress> {  
        @Override  
        public TUserAddress mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserAddress tUserAddress = new TUserAddress();
			tUserAddress.setId(rs.getInt("id"));
			tUserAddress.setUserId(rs.getInt("user_id"));
			tUserAddress.setUserName(rs.getString("user_name"));
			tUserAddress.setPhone(rs.getString("phone"));
			tUserAddress.setProvinceName(rs.getString("province_name"));
			tUserAddress.setProvinceCode(rs.getString("province_code"));
			tUserAddress.setCityName(rs.getString("city_name"));
			tUserAddress.setCityCode(rs.getString("city_code"));
			tUserAddress.setRegionCode(rs.getString("region_code"));
			tUserAddress.setRegionName(rs.getString("region_name"));
			tUserAddress.setRoad(rs.getString("road"));
			tUserAddress.setZipcode(rs.getInt("zipcode"));
			tUserAddress.setDefaultIs(rs.getInt("default_is"));
			tUserAddress.setStatus(rs.getInt("status"));
			tUserAddress.setUpdateTime(rs.getTimestamp("update_time"));
			tUserAddress.setCreateTime(rs.getTimestamp("create_time"));
			return tUserAddress; 
        }  
          
    }
}
