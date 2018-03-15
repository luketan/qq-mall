package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.honglinktech.zbgj.entity.Goods;
import com.honglinktech.zbgj.entity.GoodsDis;


/**
*
**/
public class GoodsBean implements Serializable{

	private Integer id;
	private String name;
	private String subName;
	private String detail;
	private Integer salesNum;
	private BigDecimal markPrice;
	private BigDecimal formerPrice;
	private BigDecimal price;
	private String imgUrl;

	private boolean keep;//是否收藏了
	
	private List<ActivityBean> activityBeanList;
	private List<FormatBean> formatBeanList;
	private List<PicBean> picList;
	private List<GoodsDis> goodsDisList;
	
	private GoodsDisCountBean goodsDisCountBean;
	private List<GoodsDisBean> goodsDisBeanList;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GoodsBean(){
 	}
	public GoodsBean(Goods tGoods){
		this.detail = tGoods.getDetail();
		this.formerPrice = tGoods.getFormerPrice();
		this.id = tGoods.getId();
		this.markPrice = tGoods.getMarkPrice();
		this.name = tGoods.getName();
		this.price = tGoods.getPrice();
		this.salesNum = tGoods.getSalesNum();
		this.subName = tGoods.getSubName();
		this.imgUrl = tGoods.getImgUrl();
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
	/*主图路径*/
	public String getImgUrl(){
		 return this.imgUrl; 
	}
	public void setImgUrl(String imgUrl){
		  this.imgUrl = imgUrl; 
	}
	public List<FormatBean> getFormatBeanList() {
		return formatBeanList;
	}
	public void setFormatBeanList(List<FormatBean> formatBeanList) {
		this.formatBeanList = formatBeanList;
	}
	public List<PicBean> getPicList() {
		return picList;
	}
	public void setPicList(List<PicBean> picList) {
		this.picList = picList;
	}
	public List<GoodsDis> getGoodsDisList() {
		return goodsDisList;
	}
	public void setGoodsDisList(List<GoodsDis> goodsDisList) {
		this.goodsDisList = goodsDisList;
	}
	public boolean isKeep() {
		return keep;
	}
	public void setKeep(boolean keep) {
		this.keep = keep;
	}
	public List<ActivityBean> getActivityBeanList() {
		return activityBeanList;
	}
	public void setActivityBeanList(List<ActivityBean> activityBeanList) {
		this.activityBeanList = activityBeanList;
	}
	public GoodsDisCountBean getGoodsDisCountBean() {
		return goodsDisCountBean;
	}
	public void setGoodsDisCountBean(GoodsDisCountBean goodsDisCountBean) {
		this.goodsDisCountBean = goodsDisCountBean;
	}
	public List<GoodsDisBean> getGoodsDisBeanList() {
		return goodsDisBeanList;
	}
	public void setGoodsDisBeanList(List<GoodsDisBean> goodsDisBeanList) {
		this.goodsDisBeanList = goodsDisBeanList;
	}

}
