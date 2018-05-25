package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.util.List;

import com.honglinktech.zbgj.entity.GoodsType;
import com.honglinktech.zbgj.entity.GoodsTypeSub;


/**
*
**/
public class GoodsTypeBean implements Serializable{

	private Integer id;
	private String name;
	private String ico;
	private String img;
	private Boolean rec;
	private Boolean sale;
	private Integer sort;
	private String search;
	private String summary;
	
	private List<GoodsTypeSubBean> goodsTypeSubList;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GoodsTypeBean(){
 	}
 	/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*类别名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*类型图标*/
	public String getIco(){
		 return this.ico; 
	}
	public void setIco(String ico){
		  this.ico = ico; 
	}
	/*类型图片*/
	public String getImg(){
		 return this.img; 
	}
	public void setImg(String img){
		  this.img = img; 
	}
	/**/
	public String getSearch(){
		 return this.search; 
	}
	public void setSearch(String search){
		  this.search = search; 
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<GoodsTypeSubBean> getGoodsTypeSubList() {
		return goodsTypeSubList;
	}

	public void setGoodsTypeSubList(List<GoodsTypeSubBean> goodsTypeSubList) {
		this.goodsTypeSubList = goodsTypeSubList;
	}

	public Boolean getRec() {
		return rec;
	}

	public void setRec(Boolean rec) {
		this.rec = rec;
	}

	public Boolean getSale() {
		return sale;
	}

	public void setSale(Boolean sale) {
		this.sale = sale;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
