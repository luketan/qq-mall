package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.util.List;


/**
*产品款式
**/
public class FormatBean implements Serializable{

	private Integer id=null;
	private String name=null;
	private Integer needPrice=null;
	
	private List<FormatSubBean> formatSubList;
	
	public FormatBean(){
 	}
 	public FormatBean(Integer id,Integer goodsId,String name,Integer needPrice,Integer sort,Boolean deleteFlag){
 		this.id = id;
		this.name = name;
		this.needPrice = needPrice;
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
	/*是否可选样式价格*/
	public Integer getNeedPrice(){
		 return this.needPrice; 
	}
	public void setNeedPrice(Integer needPrice){
		  this.needPrice = needPrice; 
	}
	public List<FormatSubBean> getFormatSubList() {
		return formatSubList;
	}
	public void setFormatSubList(List<FormatSubBean> formatSubList) {
		this.formatSubList = formatSubList;
	}
	/*@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("{");
		sb.append("\"id\":")
				.append(id);
		sb.append(",\"name\":\"")
				.append(name).append('\"');
		sb.append(",\"needPrice\":")
				.append(needPrice);
		sb.append(",\"formatSubBeanList\":")
				.append(formatSubBeanList);
		sb.append('}');
		return sb.toString();
	}*/
}
