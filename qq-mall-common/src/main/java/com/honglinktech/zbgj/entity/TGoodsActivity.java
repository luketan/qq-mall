package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseModel;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*商品活动
**/
public class TGoodsActivity extends BaseModel implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "商品ID",dbName = "goods_id",length = 10,allowNull=false)
	private Integer goodsId;
	@FieldMeta(primaryKey = true,fieldName = "活动ID",dbName = "activity_id",length = 10,allowNull=false)
	private Integer activityId;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TGoodsActivity(){
 	}
 	public TGoodsActivity(Integer goodsId,Integer activityId){
 		this.goodsId = goodsId;
		this.activityId = activityId;
		
 	}
 	
		/*商品ID*/
	public Integer getGoodsId(){
		 return this.goodsId; 
	}
	public void setGoodsId(Integer goodsId){
		  this.goodsId = goodsId; 
	}
	/*活动ID*/
	public Integer getActivityId(){
		 return this.activityId; 
	}
	public void setActivityId(Integer activityId){
		  this.activityId = activityId; 
	}
	/**/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}
	/**/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}

}
