package com.honglinktech.zbgj.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.bean.FormatSubBean;
import org.springframework.jdbc.core.RowMapper;


/**
*
**/
public class ShoppingCartVO implements Serializable{

	private static final long serialVersionUID = 9164880634127781560L;

	private Integer id=null;
	private Integer userId=null;
	private Integer goodsId=null;
	private String goodsName=null;
	private String imgUrl=null;
	private BigDecimal price=null;
	private BigDecimal markPrice=null;
	private Integer num=null;
	private Integer goodsStatus;
	
	private boolean checkbox = true;
	
	private int goodsTypeId;
	private String goodsTypeName;
	
	private List<FormatSubBean> formatSubList;
	private List<ActivityBean> activityList;
	
	public ShoppingCartVO(){
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
	/**/
	public Integer getNum(){
		 return this.num; 
	}
	public void setNum(Integer num){
		  this.num = num; 
	}
	public boolean isCheckbox() {
		return checkbox;
	}
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
	public String getGoodsTypeName() {
		return goodsTypeName;
	}
	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}
	public int getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(int goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Integer getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(Integer goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	public List<FormatSubBean> getFormatSubList() {
		return formatSubList;
	}

	public void setFormatSubList(List<FormatSubBean> formatSubList) {
		this.formatSubList = formatSubList;
	}

	public List<ActivityBean> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<ActivityBean> activityList) {
		this.activityList = activityList;
	}
}
