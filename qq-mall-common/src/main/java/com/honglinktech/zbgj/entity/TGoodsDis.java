package com.honglinktech.zbgj.entity;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.util.Date; 


/**
*商品评论表
**/
public class TGoodsDis extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "商品ID",dbName = "goods_id",length = 10,allowNull=false)
	private Integer goodsId=null;
	@FieldMeta(primaryKey = false,fieldName = "用户ID",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "用户名称",dbName = "user_name",length = 50,allowNull=true)
	private String userName=null;
	@FieldMeta(primaryKey = false,fieldName = "商品规格ID",dbName = "goods_format_id",length = 10,allowNull=true)
	private Integer goodsFormatId=null;
	@FieldMeta(primaryKey = false,fieldName = "商品规格",dbName = "goods_format",length = 50,allowNull=true)
	private String goodsFormat=null;
	@FieldMeta(primaryKey = false,fieldName = "评价内容",dbName = "content",length = 225,allowNull=true)
	private String content=null;
	@FieldMeta(primaryKey = false,fieldName = "评论值(掩码处理：物流，客服，质量）",dbName = "type_value",length = 5,allowNull=true)
	private String typeValue=null;
	@FieldMeta(primaryKey = false,fieldName = "评论值(1满意，2一般，3不满意)",dbName = "discuss_value",length = 10,allowNull=true)
	private Integer discussValue=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TGoodsDis(){
 	}
 	public TGoodsDis(Integer id,Integer goodsId,Integer userId,String userName,Integer goodsFormatId,String goodsFormat,String content,String typeValue,Integer discussValue){
 		this.id = id;
		this.goodsId = goodsId;
		this.userId = userId;
		this.userName = userName;
		this.goodsFormatId = goodsFormatId;
		this.goodsFormat = goodsFormat;
		this.content = content;
		this.typeValue = typeValue;
		this.discussValue = discussValue;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*商品ID*/
	public Integer getGoodsId(){
		 return this.goodsId; 
	}
	public void setGoodsId(Integer goodsId){
		  this.goodsId = goodsId; 
	}
	/*用户ID*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*用户名称*/
	public String getUserName(){
		 return this.userName; 
	}
	public void setUserName(String userName){
		  this.userName = userName; 
	}
	/*商品规格ID*/
	public Integer getGoodsFormatId(){
		 return this.goodsFormatId; 
	}
	public void setGoodsFormatId(Integer goodsFormatId){
		  this.goodsFormatId = goodsFormatId; 
	}
	/*商品规格*/
	public String getGoodsFormat(){
		 return this.goodsFormat; 
	}
	public void setGoodsFormat(String goodsFormat){
		  this.goodsFormat = goodsFormat; 
	}
	/*评价内容*/
	public String getContent(){
		 return this.content; 
	}
	public void setContent(String content){
		  this.content = content; 
	}
	/*评论值(掩码处理：物流，客服，质量）*/
	public String getTypeValue(){
		 return this.typeValue; 
	}
	public void setTypeValue(String typeValue){
		  this.typeValue = typeValue; 
	}
	/*评论值(1满意，2一般，3不满意)*/
	public Integer getDiscussValue(){
		 return this.discussValue; 
	}
	public void setDiscussValue(Integer discussValue){
		  this.discussValue = discussValue; 
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
