package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*变更变更日志[逗比、经验、vip]  注意分表
**/
public class TChangeLog extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "主键ID",dbName = "id",length = 10,allowNull=false)
	private Integer id;
	@FieldMeta(primaryKey = false,fieldName = "车队经理ID",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId;
	@FieldMeta(primaryKey = false,fieldName = "记录对象Id[商品Id，帖子Id]",dbName = "object_id",length = 10,allowNull=false)
	private Integer objectId;
	@FieldMeta(primaryKey = false,fieldName = "记录类型",dbName = "type",length = 10,allowNull=false)
	private Integer type;
	@FieldMeta(primaryKey = false,fieldName = "日志类型",dbName = "log_type",length = 10,allowNull=false)
	private Integer logType;
	@FieldMeta(primaryKey = false,fieldName = "变更前的数量",dbName = "before_num",length = 10,allowNull=false)
	private Integer beforeNum;
	@FieldMeta(primaryKey = false,fieldName = "变更数量数目",dbName = "num",length = 10,allowNull=false)
	private Integer num;
	@FieldMeta(primaryKey = false,fieldName = "变更后的数量",dbName = "curr_num",length = 10,allowNull=false)
	private Integer currNum;
	@FieldMeta(primaryKey = false,fieldName = "记录时经理的级别",dbName = "level",length = 10,allowNull=false)
	private Integer level;
	@FieldMeta(primaryKey = false,fieldName = "变更批注",dbName = "comments",length = 500,allowNull=false)
	private String comments;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TChangeLog(){
 	}
 	public TChangeLog(Integer id,Integer userId,Integer objectId,Integer type,Integer logType,Integer beforeNum,Integer num,Integer currNum,Integer level,String comments){
 		this.id = id;
		this.userId = userId;
		this.objectId = objectId;
		this.type = type;
		this.logType = logType;
		this.beforeNum = beforeNum;
		this.num = num;
		this.currNum = currNum;
		this.level = level;
		this.comments = comments;
		
 	}
 	
		/*主键ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*车队经理ID*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*记录对象Id[商品Id，帖子Id]*/
	public Integer getObjectId(){
		 return this.objectId; 
	}
	public void setObjectId(Integer objectId){
		  this.objectId = objectId; 
	}
	/*记录类型*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*日志类型*/
	public Integer getLogType(){
		 return this.logType; 
	}
	public void setLogType(Integer logType){
		  this.logType = logType; 
	}
	/*变更前的数量*/
	public Integer getBeforeNum(){
		 return this.beforeNum; 
	}
	public void setBeforeNum(Integer beforeNum){
		  this.beforeNum = beforeNum; 
	}
	/*变更数量数目*/
	public Integer getNum(){
		 return this.num; 
	}
	public void setNum(Integer num){
		  this.num = num; 
	}
	/*变更后的数量*/
	public Integer getCurrNum(){
		 return this.currNum; 
	}
	public void setCurrNum(Integer currNum){
		  this.currNum = currNum; 
	}
	/*记录时经理的级别*/
	public Integer getLevel(){
		 return this.level; 
	}
	public void setLevel(Integer level){
		  this.level = level; 
	}
	/*变更批注*/
	public String getComments(){
		 return this.comments; 
	}
	public void setComments(String comments){
		  this.comments = comments; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

}
