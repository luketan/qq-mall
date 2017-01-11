package com.honglinktech.zbgj.bean.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.honglinktech.zbgj.annotation.FieldMeta;
import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.entity.TGoods;


/**
*
**/
public class GoodsItem extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "商品名称",dbName = "name",allowNull=false)
	private String name;
	@FieldMeta(primaryKey = false,fieldName = "子标题（提醒）",dbName = "sub_name",allowNull=true)
	private String subName;
	@FieldMeta(primaryKey = false,fieldName = "商品详情",dbName = "detail",allowNull=true)
	private String detail;
	@FieldMeta(primaryKey = false,fieldName = "售出数量",dbName = "sales_num",allowNull=true)
	private Integer salesNum;
	@FieldMeta(primaryKey = false,fieldName = "库存数量",dbName = "keep_num",allowNull=true)
	private Integer keepNum;
	@FieldMeta(primaryKey = false,fieldName = "市场价",dbName = "mark_price",allowNull=true)
	private BigDecimal markPrice;
	@FieldMeta(primaryKey = false,fieldName = "原价",dbName = "former_price",allowNull=true)
	private BigDecimal formerPrice;
	@FieldMeta(primaryKey = false,fieldName = "现在价格",dbName = "price",allowNull=true)
	private BigDecimal price;
	@FieldMeta(primaryKey = false,fieldName = "评论数量",dbName = "discuss_num",allowNull=true)
	private Integer discussNum;
	@FieldMeta(primaryKey = false,fieldName = "促销名字",dbName = "promo_name",allowNull=true)
	private String promoName;
	@FieldMeta(primaryKey = false,fieldName = "促销价",dbName = "promo_price",allowNull=true)
	private BigDecimal promoPrice;
	@FieldMeta(primaryKey = false,fieldName = "是否促销",dbName = "promo_is",allowNull=true)
	private Integer promoIs;
	@FieldMeta(primaryKey = false,fieldName = "是否热卖",dbName = "hot_is",allowNull=true)
	private Integer hotIs;
	@FieldMeta(primaryKey = false,fieldName = "是否是精品",dbName = "gifts_is",allowNull=true)
	private Integer giftsIs;
	@FieldMeta(primaryKey = false,fieldName = "品牌ID",dbName = "brand_id",allowNull=true)
	private Integer brandId;
	@FieldMeta(primaryKey = false,fieldName = "品牌名称",dbName = "brand_name",allowNull=true)
	private String brandName;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "type_id",allowNull=true)
	private Integer typeId;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "type_name",allowNull=true)
	private String typeName;
	@FieldMeta(primaryKey = false,fieldName = "收藏数量",dbName = "collect_num",allowNull=true)
	private Integer collectNum;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "style_id",allowNull=true)
	private Integer styleId;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "style_name",allowNull=true)
	private String styleName;
	@FieldMeta(primaryKey = false,fieldName = "商品状态（1正常,2已售完，3已下架,4删除，5待审核）",dbName = "status",allowNull=true)
	private Integer status;
	@FieldMeta(primaryKey = false,fieldName = "主图路径",dbName = "img_url",allowNull=true)
	private String imgUrl;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "update_time",allowNull=true)
	private Date updateTime;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "create_time",allowNull=true)
	private Date createTime;
	
	
	private Integer[] goodsActivitys;
	private Integer[] goodsFormats;
	private String[] goodsImgs;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GoodsItem(){
 	}
	public GoodsItem(TGoods tGoods){
//		this.styleId = tGoods.getStyleId();
//		this.styleName = tGoods.getStyleName();
		this.typeId = tGoods.getTypeId();
		this.typeName = tGoods.getTypeName();
		this.brandId = tGoods.getBrandId();
		this.brandName = tGoods.getBrandName();
		this.collectNum = tGoods.getCollectNum();
		this.createTime = tGoods.getCreateTime();
		this.detail = tGoods.getDetail();
		this.discussNum = tGoods.getDiscussNum();
		this.formerPrice = tGoods.getFormerPrice();
		this.giftsIs = tGoods.getGiftsIs();
		this.hotIs = tGoods.getHotIs();
		this.id = tGoods.getId();
		this.keepNum = tGoods.getKeepNum();
		this.markPrice = tGoods.getMarkPrice();
		this.name = tGoods.getName();
		this.price = tGoods.getPrice();
		this.promoIs = tGoods.getPromoIs();
		this.promoName = tGoods.getPromoName();
		this.promoPrice = tGoods.getPromoPrice();
		this.salesNum = tGoods.getSalesNum();
		this.status = tGoods.getStatus();
		this.subName = tGoods.getSubName();
		this.imgUrl = tGoods.getImgUrl();
 	}
	public TGoods getTGoods(){
		TGoods tGoods = new TGoods();
		
//		tGoods.setStyleId(this.styleId);
//		tGoods.setStyleName(this.styleName);
		tGoods.setTypeId(this.typeId);
		tGoods.setTypeName(this.typeName);
		tGoods.setBrandId(this.brandId);
		tGoods.setBrandName(this.brandName);
		tGoods.setCollectNum(this.collectNum);
		tGoods.setCreateTime(this.createTime);
		tGoods.setDetail(this.detail);
		tGoods.setDiscussNum(this.discussNum);
		tGoods.setFormerPrice(this.formerPrice);
		tGoods.setGiftsIs(this.giftsIs);
		tGoods.setHotIs(this.hotIs);
		tGoods.setId(this.id);
		tGoods.setKeepNum(this.keepNum);
		tGoods.setMarkPrice(this.markPrice);
		tGoods.setName(this.name);
		tGoods.setPrice(this.price);
		tGoods.setPromoIs(this.promoIs);
		tGoods.setPromoName(this.promoName);
		tGoods.setPromoPrice(this.promoPrice);
		tGoods.setSalesNum(this.salesNum);
		tGoods.setStatus(this.status);
		tGoods.setSubName(this.subName);
		tGoods.setImgUrl(this.imgUrl);
		
		return tGoods; 
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
	public BigDecimal getPromoPrice(){
		 return this.promoPrice; 
	}
	public void setPromoPrice(BigDecimal promoPrice){
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
	/*收藏数量*/
	public Integer getCollectNum(){
		 return this.collectNum; 
	}
	public void setCollectNum(Integer collectNum){
		  this.collectNum = collectNum; 
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
	/**/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}
	/**/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}
	public Integer[] getGoodsActivitys() {
		return goodsActivitys;
	}
	public void setGoodsActivitys(Integer[] goodsActivitys) {
		this.goodsActivitys = goodsActivitys;
	}
	public Integer[] getGoodsFormats() {
		return goodsFormats;
	}
	public void setGoodsFormats(Integer[] goodsFormats) {
		this.goodsFormats = goodsFormats;
	}
	public String[] getGoodsImgs() {
		return goodsImgs;
	}
	public void setGoodsImgs(String[] goodsImgs) {
		this.goodsImgs = goodsImgs;
	}
	

}
