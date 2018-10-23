package com.honglinktech.zbgj.vo;

import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.bean.FormatBean;
import com.honglinktech.zbgj.bean.GoodsDisBean;
import com.honglinktech.zbgj.bean.GoodsDisCountBean;
import com.honglinktech.zbgj.bean.PicBean;
import com.honglinktech.zbgj.entity.Goods;
import com.honglinktech.zbgj.entity.GoodsDis;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
*
**/
public class GoodsVO implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 2345940821764667532L;

	private Integer id;
	private String name;
	private String subName;
	private String detail;
	private Integer salesNum;
	private BigDecimal markPrice;
//	private BigDecimal formerPrice;
	private BigDecimal price;
	private String imgUrl;
	private Integer typeId;
	private Integer status;

	private boolean keep;//是否收藏了
	
	private List<ActivityBean> activityList;
	private List<FormatBean> formatList;
	private List<PicBean> picList;
	private List<GoodsDis> goodsDisList;

	private GoodsDisCountBean goodsDisCountBean;
	private List<GoodsDisBean> goodsDisBeanList;

	private GoodsPhoneVO goodsPhoneVO;
	
	public GoodsVO(){
 	}
	public GoodsVO(Goods goods){
		this.detail = goods.getDetail();
//		this.formerPrice = tGoods.getFormerPrice();
		this.id = goods.getId();
		this.markPrice = goods.getMarkPrice();
		this.name = goods.getName();
		this.price = goods.getPrice();
		this.salesNum = goods.getSalesNum();
		this.subName = goods.getSubName();
		this.imgUrl = goods.getImgUrl();
		this.typeId = goods.getTypeId();
		this.status = goods.getStatus();
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
//	public BigDecimal getFormerPrice(){
//		 return this.formerPrice;
//	}
//	public void setFormerPrice(BigDecimal formerPrice){
//		  this.formerPrice = formerPrice;
//	}
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
	public GoodsPhoneVO getGoodsPhoneVO() {
		return goodsPhoneVO;
	}
	public void setGoodsPhoneVO(GoodsPhoneVO goodsPhoneVO) {
		this.goodsPhoneVO = goodsPhoneVO;
	}
	public List<ActivityBean> getActivityList() {
		return activityList;
	}
	public void setActivityList(List<ActivityBean> activityList) {
		this.activityList = activityList;
	}
	public List<FormatBean> getFormatList() {
		return formatList;
	}
	public void setFormatList(List<FormatBean> formatList) {
		this.formatList = formatList;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
