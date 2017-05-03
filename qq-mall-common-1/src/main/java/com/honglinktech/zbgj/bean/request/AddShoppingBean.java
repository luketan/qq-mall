package com.honglinktech.zbgj.bean.request;

import java.io.Serializable;


/**
*
**/
public class AddShoppingBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer goodsId;
	private Integer num;
	private int[] formatSubIds;
	
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public int[] getFormatSubIds() {
		return formatSubIds;
	}
	public void setFormatSubIds(int[] formatSubIds) {
		this.formatSubIds = formatSubIds;
	}
	
}
