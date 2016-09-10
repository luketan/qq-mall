package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*商品规格
**/
public class TGoodsFormat extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "商品ID",dbName = "goods_id",length = 10,allowNull=false)
	private Integer goodsId;
	@FieldMeta(primaryKey = true,fieldName = "规格ID",dbName = "format_id",length = 10,allowNull=false)
	private Integer formatId;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TGoodsFormat(){
 	}
 	public TGoodsFormat(Integer goodsId,Integer formatId){
 		this.goodsId = goodsId;
		this.formatId = formatId;
		
 	}
 	
		/*商品ID*/
	public Integer getGoodsId(){
		 return this.goodsId; 
	}
	public void setGoodsId(Integer goodsId){
		  this.goodsId = goodsId; 
	}
	/*规格ID*/
	public Integer getFormatId(){
		 return this.formatId; 
	}
	public void setFormatId(Integer formatId){
		  this.formatId = formatId; 
	}
	/**/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}
	/**/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}

}
