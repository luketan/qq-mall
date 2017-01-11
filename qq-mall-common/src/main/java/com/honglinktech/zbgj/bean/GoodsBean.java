package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.entity.TGoods;
import com.honglinktech.zbgj.entity.TGoodsDis;


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
	private List<TGoodsDis> goodsDisList;
	
	private GoodsDisCountBean goodsDisCountBean;
	private List<GoodsDisBean> goodsDisBeanList;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GoodsBean(){
 	}
	public GoodsBean(TGoods tGoods){
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
	public List<TGoodsDis> getGoodsDisList() {
		return goodsDisList;
	}
	public void setGoodsDisList(List<TGoodsDis> goodsDisList) {
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


	public static class GoodsBeanRowMapper implements RowMapper<GoodsBean> {  
        @Override  
        public GoodsBean mapRow(ResultSet rs, int rowNum) throws SQLException {  
        	
        	GoodsBean goodsBean = new GoodsBean();
        	goodsBean.setId(rs.getInt("id"));
        	goodsBean.setImgUrl(rs.getString("img_url"));
        	goodsBean.setMarkPrice(rs.getBigDecimal("mark_price"));
        	goodsBean.setName(rs.getString("name"));
        	goodsBean.setDetail(rs.getString("detail"));
        	goodsBean.setPrice(rs.getBigDecimal("price"));
        	goodsBean.setSalesNum(rs.getInt("sales_num"));
        	goodsBean.setSubName(rs.getString("sub_name"));
        	goodsBean.setFormerPrice(rs.getBigDecimal("former_price"));
        	goodsBean.setKeep(rs.getBoolean("keep"));
        	return goodsBean;
        }
    }
	public static class GoodsSearchBeanRowMapper implements RowMapper<GoodsBean> {  
        @Override  
        public GoodsBean mapRow(ResultSet rs, int rowNum) throws SQLException {  
        	
        	GoodsBean goodBean = new GoodsBean();
        	goodBean.setId(rs.getInt("id"));
        	goodBean.setImgUrl(rs.getString("img_url"));
        	goodBean.setMarkPrice(rs.getBigDecimal("mark_price"));
        	goodBean.setName(rs.getString("name"));
        	goodBean.setPrice(rs.getBigDecimal("price"));
        	goodBean.setSalesNum(rs.getInt("sales_num"));
        	goodBean.setSubName(rs.getString("sub_name"));
        	
        	return goodBean;
        }
    }

}
