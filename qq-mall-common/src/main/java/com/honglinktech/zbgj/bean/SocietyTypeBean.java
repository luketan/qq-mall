package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;


/**
*社区类型
**/
public class SocietyTypeBean implements Serializable{

	private Integer id=null;
	private String name=null;
	private Integer sort=null;
	private Integer status=null;
	private Date createTime=null;
	private Date updateTime=null;
	
	private List<SocietySubTypeBean> societySubTypeBeanList;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SocietyTypeBean(){
 	}
	
 	public SocietyTypeBean(Integer id,String name,Integer sort,Integer status){
 		this.id = id;
		this.name = name;
		this.sort = sort;
		this.status = status;
		
 	}
	/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/**/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/**/
	public Integer getSort(){
		 return this.sort; 
	}
	public void setSort(Integer sort){
		  this.sort = sort; 
	}
	/*1正常*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}
	/*修改时间*/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}
	
	public List<SocietySubTypeBean> getSocietySubTypeBeanList() {
		return societySubTypeBeanList;
	}

	public void setSocietySubTypeBeanList(List<SocietySubTypeBean> societySubTypeBeanList) {
		this.societySubTypeBeanList = societySubTypeBeanList;
	}

}
