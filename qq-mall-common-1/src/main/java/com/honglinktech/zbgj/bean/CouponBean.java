package com.honglinktech.zbgj.bean;

import java.io.Serializable;

import com.honglinktech.zbgj.entity.Coupon;


/**
*优惠券
**/
public class CouponBean	 implements Serializable{

	private Integer id=null;
	private String name=null;
	private Integer type=null;
	private String typeName=null;
	private Integer max=null;
	private Integer value=null;
	
	private boolean select;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CouponBean(){
 	}
 	public CouponBean(Coupon tcoupon){
 		this.id = tcoupon.getId();
		this.name = tcoupon.getName();
		this.type = tcoupon.getType();
		this.typeName = tcoupon.getTypeName();
		this.max = tcoupon.getMax();
		this.value = tcoupon.getValue();
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
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
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
}
