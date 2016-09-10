package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*商品款式
**/
public class TGStyle extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "规格名称",dbName = "name",length = 225,allowNull=false)
	private String name;
	@FieldMeta(primaryKey = false,fieldName = "商品类型",dbName = "goods_type",length = 10,allowNull=true)
	private Integer goodsType;
	@FieldMeta(primaryKey = false,fieldName = "类型名称",dbName = "type_name",length = 50,allowNull=true)
	private String typeName;
	@FieldMeta(primaryKey = false,fieldName = "状态(1正常，2删除）",dbName = "status",length = 10,allowNull=true)
	private Integer status;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TGStyle(){
 	}
 	public TGStyle(Integer id,String name,Integer goodsType,String typeName,Integer status){
 		this.id = id;
		this.name = name;
		this.goodsType = goodsType;
		this.typeName = typeName;
		this.status = status;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*规格名称*/
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
	/*状态(1正常，2删除）*/
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
