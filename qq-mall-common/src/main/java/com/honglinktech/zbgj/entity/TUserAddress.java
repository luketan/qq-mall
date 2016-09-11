package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*用户地址
**/
public class TUserAddress extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "用户地址ID",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "用户ID",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId;
	@FieldMeta(primaryKey = false,fieldName = "省名称",dbName = "province_name",length = 50,allowNull=true)
	private String provinceName;
	@FieldMeta(primaryKey = false,fieldName = "省ID",dbName = "province_code",length = 50,allowNull=true)
	private String provinceCode;
	@FieldMeta(primaryKey = false,fieldName = "市名称",dbName = "city_name",length = 50,allowNull=true)
	private String cityName;
	@FieldMeta(primaryKey = false,fieldName = "市ID",dbName = "city_code",length = 50,allowNull=true)
	private String cityCode;
	@FieldMeta(primaryKey = false,fieldName = "区ID",dbName = "region_code",length = 50,allowNull=true)
	private String regionCode;
	@FieldMeta(primaryKey = false,fieldName = "区名称",dbName = "region_name",length = 50,allowNull=true)
	private String regionName;
	@FieldMeta(primaryKey = false,fieldName = "街道",dbName = "road",length = 255,allowNull=true)
	private String road;
	@FieldMeta(primaryKey = false,fieldName = "电话号码",dbName = "phone",length = 15,allowNull=false)
	private String phone;
	@FieldMeta(primaryKey = false,fieldName = "邮编",dbName = "zipcode",length = 10,allowNull=true)
	private Integer zipcode;
	@FieldMeta(primaryKey = false,fieldName = "是否是默认地址",dbName = "default_is",length = 10,allowNull=true)
	private Integer defaultIs;
	@FieldMeta(primaryKey = false,fieldName = "状态(1正常，2删除)",dbName = "status",length = 10,allowNull=true)
	private Integer status;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserAddress(){
 	}
 	public TUserAddress(Integer id,Integer userId,String provinceName,String provinceCode,String cityName,String cityCode,String regionCode,String regionName,String road,String phone,Integer zipcode,Integer defaultIs,Integer status){
 		this.id = id;
		this.userId = userId;
		this.provinceName = provinceName;
		this.provinceCode = provinceCode;
		this.cityName = cityName;
		this.cityCode = cityCode;
		this.regionCode = regionCode;
		this.regionName = regionName;
		this.road = road;
		this.phone = phone;
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
	/*电话号码*/
	public String getPhone(){
		 return this.phone; 
	}
	public void setPhone(String phone){
		  this.phone = phone; 
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

}
