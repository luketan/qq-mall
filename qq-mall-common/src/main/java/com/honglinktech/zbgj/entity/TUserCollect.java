package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*用户的收藏
**/
public class TUserCollect extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "goods_id",length = 10,allowNull=true)
	private Integer goodsId;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "goods_name",length = 225,allowNull=true)
	private String goodsName;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "goods_url",length = 225,allowNull=true)
	private String goodsUrl;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserCollect(){
 	}
 	public TUserCollect(Integer id,Integer goodsId,String goodsName,String goodsUrl){
 		this.id = id;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsUrl = goodsUrl;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/**/
	public Integer getGoodsId(){
		 return this.goodsId; 
	}
	public void setGoodsId(Integer goodsId){
		  this.goodsId = goodsId; 
	}
	/**/
	public String getGoodsName(){
		 return this.goodsName; 
	}
	public void setGoodsName(String goodsName){
		  this.goodsName = goodsName; 
	}
	/**/
	public String getGoodsUrl(){
		 return this.goodsUrl; 
	}
	public void setGoodsUrl(String goodsUrl){
		  this.goodsUrl = goodsUrl; 
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
