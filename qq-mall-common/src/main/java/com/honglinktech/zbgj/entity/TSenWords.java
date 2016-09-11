package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;

/**
*
**/
public class TSenWords extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "word",length = 25,allowNull=false)
	private String word;
	@FieldMeta(primaryKey = false,fieldName = "1政治类，2",dbName = "type",length = 10,allowNull=true)
	private Integer type;
	@FieldMeta(primaryKey = false,fieldName = "状态(1可用)",dbName = "status",length = 10,allowNull=true)
	private Integer status;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TSenWords(){
 	}
 	public TSenWords(Integer id,String word,Integer type,Integer status){
 		this.id = id;
		this.word = word;
		this.type = type;
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
	public String getWord(){
		 return this.word; 
	}
	public void setWord(String word){
		  this.word = word; 
	}
	/*1政治类，2*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*状态(1可用)*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}

}
