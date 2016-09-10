package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;

/**
*
**/
public class TRegion extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "region_id",length = 22,allowNull=false)
	private Double regionId;
	@FieldMeta(primaryKey = false,fieldName = "身份证码",dbName = "region_code",length = 100,allowNull=false)
	private String regionCode;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "region_name",length = 100,allowNull=false)
	private String regionName;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "parent_id",length = 22,allowNull=false)
	private Double parentId;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "region_level",length = 22,allowNull=false)
	private Double regionLevel;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "region_order",length = 22,allowNull=false)
	private Double regionOrder;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "region_name_en",length = 100,allowNull=false)
	private String regionNameEn;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "region_shortname_en",length = 10,allowNull=false)
	private String regionShortnameEn;
	
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

}
