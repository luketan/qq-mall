package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*社区打赏
**/
public class TSocietyReward extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "society_note_id",length = 10,allowNull=false)
	private Integer societyNoteId;
	@FieldMeta(primaryKey = false,fieldName = "收的",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId;
	@FieldMeta(primaryKey = false,fieldName = "出的",dbName = "bus_user_id",length = 10,allowNull=true)
	private Integer busUserId;
	@FieldMeta(primaryKey = false,fieldName = "1打赏类型逗币，",dbName = "type",length = 10,allowNull=true)
	private Integer type;
	@FieldMeta(primaryKey = false,fieldName = "价值数量",dbName = "val_num",length = 10,allowNull=true)
	private Integer valNum;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TSocietyReward(){
 	}
 	public TSocietyReward(Integer id,Integer societyNoteId,Integer userId,Integer busUserId,Integer type,Integer valNum){
 		this.id = id;
		this.societyNoteId = societyNoteId;
		this.userId = userId;
		this.busUserId = busUserId;
		this.type = type;
		this.valNum = valNum;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/**/
	public Integer getSocietyNoteId(){
		 return this.societyNoteId; 
	}
	public void setSocietyNoteId(Integer societyNoteId){
		  this.societyNoteId = societyNoteId; 
	}
	/*收的*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*出的*/
	public Integer getBusUserId(){
		 return this.busUserId; 
	}
	public void setBusUserId(Integer busUserId){
		  this.busUserId = busUserId; 
	}
	/*1打赏类型逗币，*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*价值数量*/
	public Integer getValNum(){
		 return this.valNum; 
	}
	public void setValNum(Integer valNum){
		  this.valNum = valNum; 
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
