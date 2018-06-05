package com.honglinktech.zbgj.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.honglinktech.zbgj.common.Constants;


/**
*
**/
public class GoodsActivityArgsBean implements Serializable{

	private Integer id;
	private String name;
	@JsonIgnore
	private Integer type;
	private String typeName;
	private String args;
	private String detail;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GoodsActivityArgsBean(){
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
		return Constants.goodsActivityTypeName(type);
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
