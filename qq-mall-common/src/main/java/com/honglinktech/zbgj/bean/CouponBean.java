package com.honglinktech.zbgj.bean;

import java.io.Serializable;

import com.honglinktech.zbgj.entity.Coupon;


/**
*优惠券
**/
public class CouponBean implements Serializable{

	private static final long serialVersionUID = -150409919921870331L;

	private Integer id=null;
	private String name=null;
	private Integer goodsType=null;
	private String typeName=null;
	private Integer max=null;
	private Integer value=null;
	private Integer num;
	
	private boolean select;

	
	public CouponBean(){
 	}
		/*ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*条件商品类型(1优惠券）*/

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	/*商品类型名称*/
	public String getTypeName(){
		 return this.typeName; 
	}
	public void setTypeName(String typeName){
		  this.typeName = typeName; 
	}
	/*条件满多少可以用*/
	public Integer getMax(){
		 return this.max; 
	}
	public void setMax(Integer max){
		  this.max = max; 
	}
	/**/
	public Integer getValue(){
		 return this.value; 
	}
	public void setValue(Integer value){
		  this.value = value; 
	}
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}
