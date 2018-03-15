package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;


/**
*
**/
public class PicBean implements Serializable{

	private Integer id=null;
	private Integer urlType=null;
	private String picTitle=null;
	private String picUrl=null;
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	public PicBean(){
 	}
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*地址类型(1.完整，2.系统路径)*/
	public Integer getUrlType(){
		 return this.urlType; 
	}
	public void setUrlType(Integer urlType){
		  this.urlType = urlType; 
	}
	/*图片标题*/
	public String getPicTitle(){
		 return this.picTitle; 
	}
	public void setPicTitle(String picTitle){
		  this.picTitle = picTitle; 
	}
	/*图片地址*/
	public String getPicUrl(){
		 return this.picUrl; 
	}
	public void setPicUrl(String picUrl){
		  this.picUrl = picUrl; 
	}

}
