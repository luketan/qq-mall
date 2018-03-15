package com.honglinktech.zbgj.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.honglinktech.zbgj.common.Constants;


/**
 * 活动
 * @author Administrator
 *
 */
public class ActivityBean implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	//活动名称
	private String name;
	//活动类型(1打折,2包邮,3赠送,4满减)
	@JsonIgnore
	private Integer type;
	//活动类型名称
	private String typeName;
	//活动参数(预留)
	private String args;
	//活动详情
	private String detail;
	//活动满足条件
	private Integer max;
	//活动值
	private Integer value;
	//活动链接
	private String url;
	//
	private Integer goodsId;
	
	public ActivityBean(){
 	}
 	
		/*活动ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*活动名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*活动类型(1打折,2包邮,3赠送)*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*活动系数*/
	public String getArgs(){
		 return this.args; 
	}
	public void setArgs(String args){
		  this.args = args; 
	}
	/*活动详情*/
	public String getDetail(){
		 return this.detail; 
	}
	public void setDetail(String detail){
		  this.detail = detail; 
	}
	
	public String getTypeName() {
		this.typeName = Constants.goodsActivityTypeName(type);
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
}
