package com.honglinktech.zbgj.vo;

import com.honglinktech.zbgj.bean.FormatSubBean;

import java.io.Serializable;
import java.util.List;


/**
*产品款式
**/
public class FormatVO implements Serializable{

	private Integer id=null;
	private String name=null;
	private Integer needPrice=null;

	private List<FormatSubVO> formatSubVOs;

	public FormatVO(){
 	}
 	public FormatVO(Integer id, Integer goodsId, String name, Integer needPrice, Integer sort, Boolean deleteFlag){
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

	public List<FormatSubVO> getFormatSubVOs() {
		return formatSubVOs;
	}

	public void setFormatSubVOs(List<FormatSubVO> formatSubVOs) {
		this.formatSubVOs = formatSubVOs;
	}
}
