package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.math.BigDecimal;


/**
*规格种类
**/
public class FormatSubBean implements Serializable{

	private Integer id=null;
	private String name=null;
	private BigDecimal price=null;
	private BigDecimal vipPrice=null;
	private Integer select=null;
	private String args=null;
	private Boolean deleteFlag=null;
	
	private String formatName;
	private Boolean needPrice;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FormatSubBean(){
 	}
 	public FormatSubBean(Integer id,Integer formatId,String name,BigDecimal price,BigDecimal vipPrice,Integer select,Integer deleteFlag,String args,Integer sort){
 		this.id = id;
		this.name = name;
		this.price = price;
		this.vipPrice = vipPrice;
		this.select = select;
		this.args = args;
		
 	}
		/**/
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
	/*费用*/
	public BigDecimal getPrice(){
		 return this.price; 
	}
	public void setPrice(BigDecimal price){
		  this.price = price; 
	}
	/*vip费用*/
	public BigDecimal getVipPrice(){
		 return this.vipPrice; 
	}
	public void setVipPrice(BigDecimal vipPrice){
		  this.vipPrice = vipPrice; 
	}
	/*是否可选*/
	public Integer getSelect(){
		 return this.select; 
	}
	public void setSelect(Integer select){
		  this.select = select; 
	}
	/*系数*/
	public String getArgs(){
		 return this.args; 
	}
	public void setArgs(String args){
		  this.args = args; 
	}
	public String getFormatName() {
		return formatName;
	}
	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Boolean getNeedPrice() {
		return needPrice;
	}
	public void setNeedPrice(Boolean needPrice) {
		this.needPrice = needPrice;
	}
}
