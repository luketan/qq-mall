package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.math.BigDecimal; 

import java.util.Date; 


/**
*
**/
public class TShoppingCart extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_id",length = 10,allowNull=true)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "goods_id",length = 10,allowNull=true)
	private Integer goodsId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "goods_name",length = 225,allowNull=true)
	private String goodsName=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "image_url",length = 225,allowNull=true)
	private String imageUrl=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "price",length = 10,allowNull=true)
	private BigDecimal price=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "mark_price",length = 10,allowNull=true)
	private BigDecimal markPrice=null;
	@FieldMeta(primaryKey = false,fieldName = "商品规格id",dbName = "format_id",length = 10,allowNull=true)
	private Integer formatId=null;
	@FieldMeta(primaryKey = false,fieldName = "商品规格名字",dbName = "format_name",length = 225,allowNull=true)
	private String formatName=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "num",length = 10,allowNull=true)
	private Integer num=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TShoppingCart(){
 	}
 	public TShoppingCart(Integer id,Integer userId,Integer goodsId,String goodsName,String imageUrl,BigDecimal price,BigDecimal markPrice,Integer formatId,String formatName,Integer num){
 		this.id = id;
		this.userId = userId;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.imageUrl = imageUrl;
		this.price = price;
		this.markPrice = markPrice;
		this.formatId = formatId;
		this.formatName = formatName;
		this.num = num;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/**/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
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
	public String getImageUrl(){
		 return this.imageUrl; 
	}
	public void setImageUrl(String imageUrl){
		  this.imageUrl = imageUrl; 
	}
	/**/
	public BigDecimal getPrice(){
		 return this.price; 
	}
	public void setPrice(BigDecimal price){
		  this.price = price; 
	}
	/**/
	public BigDecimal getMarkPrice(){
		 return this.markPrice; 
	}
	public void setMarkPrice(BigDecimal markPrice){
		  this.markPrice = markPrice; 
	}
	/*商品规格id*/
	public Integer getFormatId(){
		 return this.formatId; 
	}
	public void setFormatId(Integer formatId){
		  this.formatId = formatId; 
	}
	/*商品规格名字*/
	public String getFormatName(){
		 return this.formatName; 
	}
	public void setFormatName(String formatName){
		  this.formatName = formatName; 
	}
	/**/
	public Integer getNum(){
		 return this.num; 
	}
	public void setNum(Integer num){
		  this.num = num; 
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
