package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*
**/
public class TSocietySub extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "name",length = 50,allowNull=true)
	private String name;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "icon",length = 50,allowNull=true)
	private String icon;
	@FieldMeta(primaryKey = false,fieldName = "简介",dbName = "synopsis",length = 225,allowNull=true)
	private String synopsis;
	@FieldMeta(primaryKey = false,fieldName = "类型",dbName = "type",length = 10,allowNull=true)
	private Integer type;
	@FieldMeta(primaryKey = false,fieldName = "1正常",dbName = "status",length = 10,allowNull=true)
	private Integer status;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "sort",length = 10,allowNull=true)
	private Integer sort;
	@FieldMeta(primaryKey = false,fieldName = "热门度，就是帖子数",dbName = "hot_num",length = 10,allowNull=true)
	private Integer hotNum;
	@FieldMeta(primaryKey = false,fieldName = "奖励类型，（0没有奖励，1奖励逗币，2奖励积分，3是逗币和积分）",dbName = "award_type",length = 10,allowNull=true)
	private Integer awardType;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "award_num",length = 10,allowNull=true)
	private Integer awardNum;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TSocietySub(){
 	}
 	public TSocietySub(Integer id,String name,String icon,String synopsis,Integer type,Integer status,Integer sort,Integer hotNum,Integer awardType,Integer awardNum){
 		this.id = id;
		this.name = name;
		this.icon = icon;
		this.synopsis = synopsis;
		this.type = type;
		this.status = status;
		this.sort = sort;
		this.hotNum = hotNum;
		this.awardType = awardType;
		this.awardNum = awardNum;
		
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
	public String getIcon(){
		 return this.icon; 
	}
	public void setIcon(String icon){
		  this.icon = icon; 
	}
	/*简介*/
	public String getSynopsis(){
		 return this.synopsis; 
	}
	public void setSynopsis(String synopsis){
		  this.synopsis = synopsis; 
	}
	/*类型*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*1正常*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}
	/**/
	public Integer getSort(){
		 return this.sort; 
	}
	public void setSort(Integer sort){
		  this.sort = sort; 
	}
	/*热门度，就是帖子数*/
	public Integer getHotNum(){
		 return this.hotNum; 
	}
	public void setHotNum(Integer hotNum){
		  this.hotNum = hotNum; 
	}
	/*奖励类型，（0没有奖励，1奖励逗币，2奖励积分，3是逗币和积分）*/
	public Integer getAwardType(){
		 return this.awardType; 
	}
	public void setAwardType(Integer awardType){
		  this.awardType = awardType; 
	}
	/**/
	public Integer getAwardNum(){
		 return this.awardNum; 
	}
	public void setAwardNum(Integer awardNum){
		  this.awardNum = awardNum; 
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

}
