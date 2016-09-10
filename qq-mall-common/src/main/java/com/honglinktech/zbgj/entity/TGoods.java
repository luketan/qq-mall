package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.math.BigDecimal; 

import java.util.Date; 


/**
*
**/
public class TGoods extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "商品名称",dbName = "name",length = 255,allowNull=false)
	private String name;
	@FieldMeta(primaryKey = false,fieldName = "子标题（提醒）",dbName = "sub_name",length = 255,allowNull=true)
	private String subName;
	@FieldMeta(primaryKey = false,fieldName = "商品详情",dbName = "detail",length = 65535,allowNull=true)
	private String detail;
	@FieldMeta(primaryKey = false,fieldName = "售出数量",dbName = "sales_num",length = 10,allowNull=true)
	private Integer salesNum;
	@FieldMeta(primaryKey = false,fieldName = "库存数量",dbName = "keep_num",length = 10,allowNull=true)
	private Integer keepNum;
	@FieldMeta(primaryKey = false,fieldName = "市场价",dbName = "mark_price",length = 10,allowNull=true)
	private BigDecimal markPrice;
	@FieldMeta(primaryKey = false,fieldName = "原价",dbName = "former_price",length = 10,allowNull=true)
	private BigDecimal formerPrice;
	@FieldMeta(primaryKey = false,fieldName = "现在价格",dbName = "price",length = 10,allowNull=true)
	private BigDecimal price;
	@FieldMeta(primaryKey = false,fieldName = "评论数量",dbName = "discuss_num",length = 10,allowNull=true)
	private Integer discussNum;
	@FieldMeta(primaryKey = false,fieldName = "促销名字",dbName = "promo_name",length = 225,allowNull=true)
	private String promoName;
	@FieldMeta(primaryKey = false,fieldName = "促销价",dbName = "promo_price",length = 10,allowNull=true)
	private Float promoPrice;
	@FieldMeta(primaryKey = false,fieldName = "是否促销",dbName = "promo_is",length = 10,allowNull=true)
	private Integer promoIs;
	@FieldMeta(primaryKey = false,fieldName = "是否热卖",dbName = "hot_is",length = 10,allowNull=true)
	private Integer hotIs;
	@FieldMeta(primaryKey = false,fieldName = "是否是精品",dbName = "gifts_is",length = 10,allowNull=true)
	private Integer giftsIs;
	@FieldMeta(primaryKey = false,fieldName = "品牌ID",dbName = "brand_id",length = 10,allowNull=true)
	private Integer brandId;
	@FieldMeta(primaryKey = false,fieldName = "品牌名称",dbName = "brand_name",length = 128,allowNull=true)
	private String brandName;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "type_id",length = 10,allowNull=true)
	private Integer typeId;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "type_name",length = 128,allowNull=true)
	private String typeName;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "style_id",length = 10,allowNull=true)
	private Integer styleId;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "style_name",length = 128,allowNull=true)
	private String styleName;
	@FieldMeta(primaryKey = false,fieldName = "收藏数量",dbName = "collect_num",length = 10,allowNull=true)
	private Integer collectNum;
	@FieldMeta(primaryKey = false,fieldName = "商品状态（1正常,2已售完，3已下架,4删除，5待审核）",dbName = "status",length = 10,allowNull=true)
	private Integer status;
	@FieldMeta(primaryKey = false,fieldName = "主图路径",dbName = "img_url",length = 225,allowNull=true)
	private String imgUrl;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TGoods(){
 	}
 	public TGoods(Integer id,String name,String subName,String detail,Integer salesNum,Integer keepNum,BigDecimal markPrice,BigDecimal formerPrice,BigDecimal price,Integer discussNum,String promoName,Float promoPrice,Integer promoIs,Integer hotIs,Integer giftsIs,Integer brandId,String brandName,Integer typeId,String typeName,Integer styleId,String styleName,Integer collectNum,Integer status,String imgUrl){
 		this.id = id;
		this.name = name;
		this.subName = subName;
		this.detail = detail;
		this.salesNum = salesNum;
		this.keepNum = keepNum;
		this.markPrice = markPrice;
		this.formerPrice = formerPrice;
		this.price = price;
		this.discussNum = discussNum;
		this.promoName = promoName;
		this.promoPrice = promoPrice;
		this.promoIs = promoIs;
		this.hotIs = hotIs;
		this.giftsIs = giftsIs;
		this.brandId = brandId;
		this.brandName = brandName;
		this.typeId = typeId;
		this.typeName = typeName;
		this.styleId = styleId;
		this.styleName = styleName;
		this.collectNum = collectNum;
		this.status = status;
		this.imgUrl = imgUrl;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*商品名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*子标题（提醒）*/
	public String getSubName(){
		 return this.subName; 
	}
	public void setSubName(String subName){
		  this.subName = subName; 
	}
	/*商品详情*/
	public String getDetail(){
		 return this.detail; 
	}
	public void setDetail(String detail){
		  this.detail = detail; 
	}
	/*售出数量*/
	public Integer getSalesNum(){
		 return this.salesNum; 
	}
	public void setSalesNum(Integer salesNum){
		  this.salesNum = salesNum; 
	}
	/*库存数量*/
	public Integer getKeepNum(){
		 return this.keepNum; 
	}
	public void setKeepNum(Integer keepNum){
		  this.keepNum = keepNum; 
	}
	/*市场价*/
	public BigDecimal getMarkPrice(){
		 return this.markPrice; 
	}
	public void setMarkPrice(BigDecimal markPrice){
		  this.markPrice = markPrice; 
	}
	/*原价*/
	public BigDecimal getFormerPrice(){
		 return this.formerPrice; 
	}
	public void setFormerPrice(BigDecimal formerPrice){
		  this.formerPrice = formerPrice; 
	}
	/*现在价格*/
	public BigDecimal getPrice(){
		 return this.price; 
	}
	public void setPrice(BigDecimal price){
		  this.price = price; 
	}
	/*评论数量*/
	public Integer getDiscussNum(){
		 return this.discussNum; 
	}
	public void setDiscussNum(Integer discussNum){
		  this.discussNum = discussNum; 
	}
	/*促销名字*/
	public String getPromoName(){
		 return this.promoName; 
	}
	public void setPromoName(String promoName){
		  this.promoName = promoName; 
	}
	/*促销价*/
	public Float getPromoPrice(){
		 return this.promoPrice; 
	}
	public void setPromoPrice(Float promoPrice){
		  this.promoPrice = promoPrice; 
	}
	/*是否促销*/
	public Integer getPromoIs(){
		 return this.promoIs; 
	}
	public void setPromoIs(Integer promoIs){
		  this.promoIs = promoIs; 
	}
	/*是否热卖*/
	public Integer getHotIs(){
		 return this.hotIs; 
	}
	public void setHotIs(Integer hotIs){
		  this.hotIs = hotIs; 
	}
	/*是否是精品*/
	public Integer getGiftsIs(){
		 return this.giftsIs; 
	}
	public void setGiftsIs(Integer giftsIs){
		  this.giftsIs = giftsIs; 
	}
	/*品牌ID*/
	public Integer getBrandId(){
		 return this.brandId; 
	}
	public void setBrandId(Integer brandId){
		  this.brandId = brandId; 
	}
	/*品牌名称*/
	public String getBrandName(){
		 return this.brandName; 
	}
	public void setBrandName(String brandName){
		  this.brandName = brandName; 
	}
	/**/
	public Integer getTypeId(){
		 return this.typeId; 
	}
	public void setTypeId(Integer typeId){
		  this.typeId = typeId; 
	}
	/**/
	public String getTypeName(){
		 return this.typeName; 
	}
	public void setTypeName(String typeName){
		  this.typeName = typeName; 
	}
	/**/
	public Integer getStyleId(){
		 return this.styleId; 
	}
	public void setStyleId(Integer styleId){
		  this.styleId = styleId; 
	}
	/**/
	public String getStyleName(){
		 return this.styleName; 
	}
	public void setStyleName(String styleName){
		  this.styleName = styleName; 
	}
	/*收藏数量*/
	public Integer getCollectNum(){
		 return this.collectNum; 
	}
	public void setCollectNum(Integer collectNum){
		  this.collectNum = collectNum; 
	}
	/*商品状态（1正常,2已售完，3已下架,4删除，5待审核）*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}
	/*主图路径*/
	public String getImgUrl(){
		 return this.imgUrl; 
	}
	public void setImgUrl(String imgUrl){
		  this.imgUrl = imgUrl; 
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
