package com.honglinktech.zbgj.bean;

import java.io.Serializable;


/**
*产品款式
**/
public class GoodsDisCountBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5372785209505066777L;
	private int totalCount;
	private int imgCount;//有图片评论
	private int goodCount;//4-5星评论
	private int generalCount;//2,3星评论
	private int errorCount;//1星评论
	private float avgDisValue;
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getImgCount() {
		return imgCount;
	}
	public void setImgCount(int imgCount) {
		this.imgCount = imgCount;
	}
	public int getGoodCount() {
		return goodCount;
	}
	public void setGoodCount(int goodCount) {
		this.goodCount = goodCount;
	}
	public int getGeneralCount() {
		return generalCount;
	}
	public void setGeneralCount(int generalCount) {
		this.generalCount = generalCount;
	}
	public int getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}
	public float getAvgDisValue() {
		return avgDisValue;
	}
	public void setAvgDisValue(float avgDisValue) {
		this.avgDisValue = avgDisValue;
	}
	
}
