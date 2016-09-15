package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*商品品牌
**/
public class TGBrand extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "品牌ID",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "品牌名称",dbName = "name",length = 225,allowNull=true)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "商品类型",dbName = "goods_type",length = 10,allowNull=true)
	private Integer goodsType=null;
	@FieldMeta(primaryKey = false,fieldName = "类型名称",dbName = "type_name",length = 50,allowNull=true)
	private String typeName=null;
	@FieldMeta(primaryKey = false,fieldName = "状态(1正常，2删除)",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TGBrand(){
 	}
 	public TGBrand(Integer id,String name,Integer goodsType,String typeName,Integer status){
 		this.id = id;
		this.name = name;
		this.goodsType = goodsType;
		this.typeName = typeName;
		this.status = status;
		
 	}
 	
		/*品牌ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*品牌名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*商品类型*/
	public Integer getGoodsType(){
		 return this.goodsType; 
	}
	public void setGoodsType(Integer goodsType){
		  this.goodsType = goodsType; 
	}
	/*类型名称*/
	public String getTypeName(){
		 return this.typeName; 
	}
	public void setTypeName(String typeName){
		  this.typeName = typeName; 
	}
	/*状态(1正常，2删除)*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}
	/*修改时间*/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}

}
