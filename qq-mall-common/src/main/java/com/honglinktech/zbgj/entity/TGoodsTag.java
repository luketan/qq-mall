package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*商品活动
**/
public class TGoodsTag extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "商品ID",dbName = "goods_id",length = 10,allowNull=false)
	private Integer goodsId=null;
	@FieldMeta(primaryKey = true,fieldName = "标签ID",dbName = "tag_id",length = 10,allowNull=false)
	private Integer tagId=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TGoodsTag(){
 	}
 	public TGoodsTag(Integer goodsId,Integer tagId){
 		this.goodsId = goodsId;
		this.tagId = tagId;
		
 	}
 	
		/*商品ID*/
	public Integer getGoodsId(){
		 return this.goodsId; 
	}
	public void setGoodsId(Integer goodsId){
		  this.goodsId = goodsId; 
	}
	/*标签ID*/
	public Integer getTagId(){
		 return this.tagId; 
	}
	public void setTagId(Integer tagId){
		  this.tagId = tagId; 
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
