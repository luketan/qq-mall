package com.honglinktech.zbgj.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

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
	@FieldMeta(primaryKey = false,fieldName = "回复时间",dbName = "reply_time",length = 19,allowNull=true)
	private Date replyTime=null;
	@FieldMeta(primaryKey = false,fieldName = "系统回复",dbName = "reply",length = 65535,allowNull=true)
	private String reply=null;
	@FieldMeta(primaryKey = false,fieldName = "评论值(掩码处理：物流，客服，质量）",dbName = "type_value",length = 5,allowNull=true)
	private String typeValue=null;
	@FieldMeta(primaryKey = false,fieldName = "评论值(1满意，2一般，4不满意,8，16)",dbName = "dis_value",length = 10,allowNull=true)
	private Integer disValue=null;
	@FieldMeta(primaryKey = false,fieldName = "是否有图片",dbName = "img",length = 10,allowNull=true)
	private Integer img=null;
	@FieldMeta(primaryKey = false,fieldName = "点赞",dbName = "good",length = 10,allowNull=true)
	private Integer good=null;
	@FieldMeta(primaryKey = false,fieldName = "低级评论",dbName = "low",length = 10,allowNull=true)
	private Integer low=null;
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
 	public TGoodsDis(Integer id,Integer goodsId,Integer userId,String userName,Integer goodsFormatId,String goodsFormat,String content,Date replyTime,String reply,String typeValue,Integer disValue,Integer img,Integer good,Integer low){
 		this.id = id;
		this.goodsId = goodsId;
		this.userId = userId;
		this.userName = userName;
		this.goodsFormatId = goodsFormatId;
		this.goodsFormat = goodsFormat;
		this.content = content;
		this.replyTime = replyTime;
		this.reply = reply;
		this.typeValue = typeValue;
		this.disValue = disValue;
		this.img = img;
		this.good = good;
		this.low = low;
		
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
	/*回复时间*/
	public Date getReplyTime(){
		 return this.replyTime; 
	}
	public void setReplyTime(Date replyTime){
		  this.replyTime = replyTime; 
	}
	/*系统回复*/
	public String getReply(){
		 return this.reply; 
	}
	public void setReply(String reply){
		  this.reply = reply; 
	}
	/*评论值(掩码处理：物流，客服，质量）*/
	public String getTypeValue(){
		 return this.typeValue; 
	}
	public void setTypeValue(String typeValue){
		  this.typeValue = typeValue; 
	}
	/*评论值(1满意，2一般，4不满意,8，16)*/
	public Integer getDisValue(){
		 return this.disValue; 
	}
	public void setDisValue(Integer disValue){
		  this.disValue = disValue; 
	}
	/*是否有图片*/
	public Integer getImg(){
		 return this.img; 
	}
	public void setImg(Integer img){
		  this.img = img; 
	}
	/*点赞*/
	public Integer getGood(){
		 return this.good; 
	}
	public void setGood(Integer good){
		  this.good = good; 
	}
	/*低级评论*/
	public Integer getLow(){
		 return this.low; 
	}
	public void setLow(Integer low){
		  this.low = low; 
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

	
	public enum DBMaping{
		tableName("t_goods_dis",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		goodsId("goods_id",Types.INTEGER,false,false,false),
		userId("user_id",Types.INTEGER,false,false,false),
		userName("user_name",Types.VARCHAR,false,false,true),
		goodsFormatId("goods_format_id",Types.INTEGER,false,false,true),
		goodsFormat("goods_format",Types.VARCHAR,false,false,true),
		content("content",Types.VARCHAR,false,false,true),
		replyTime("reply_time",Types.TIMESTAMP,false,false,true),
		reply("reply",Types.LONGVARCHAR,false,false,true),
		typeValue("type_value",Types.VARCHAR,false,false,true),
		disValue("dis_value",Types.INTEGER,false,false,true),
		img("img",Types.INTEGER,false,false,true),
		good("good",Types.INTEGER,false,false,true),
		low("low",Types.INTEGER,false,false,true),
		createTime("create_time",Types.TIMESTAMP,false,false,true),
		updateTime("update_time",Types.TIMESTAMP,false,false,true);
		private String dbName;
		private int dbType;
		private boolean primaryKey;
		private boolean isAotuIn;
		private boolean isAllowNull;
	    public String getDbName(){
	    	 return this.dbName;
	    }
	    public int getDbType(){
	    	 return this.dbType;
	    }
	    public boolean getPrimaryKey(){
	    	 return this.primaryKey;
	    }
	    public boolean isAotuIn(){
	    	 return this.isAotuIn;
	    }
	    public boolean isAllowNull(){
	    	 return this.isAllowNull;
	    }
	    private DBMaping(String dbName,int dbType,boolean primaryKey,boolean isAotuIn,boolean isAllowNull){
	    	 this.dbName = dbName;
	    	 this.dbType = dbType;
	    	 this.primaryKey = primaryKey;
	    	 this.isAotuIn = isAotuIn;
	    	 this.isAllowNull = isAllowNull;
	    }
	}
	public Object[] getDBMapping(String filedName){
		for(DBMaping d:DBMaping.values()){
			if(d.toString().equals(filedName)){
				DBMaping dbMaping = DBMaping.valueOf(filedName);
				Object[] values = {dbMaping.dbName,dbMaping.dbType,dbMaping.primaryKey,dbMaping.isAotuIn,dbMaping.isAllowNull};
				return values;
			}
		}
		return null;
	}
	public static class TGoodsDisRowMapper implements RowMapper<TGoodsDis> {  
        @Override  
        public TGoodsDis mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TGoodsDis tGoodsDis = new TGoodsDis();
			tGoodsDis.setId(rs.getInt("id"));
			tGoodsDis.setGoodsId(rs.getInt("goods_id"));
			tGoodsDis.setUserId(rs.getInt("user_id"));
			tGoodsDis.setUserName(rs.getString("user_name"));
			tGoodsDis.setGoodsFormatId(rs.getInt("goods_format_id"));
			tGoodsDis.setGoodsFormat(rs.getString("goods_format"));
			tGoodsDis.setContent(rs.getString("content"));
			tGoodsDis.setReplyTime(rs.getTimestamp("reply_time"));
			tGoodsDis.setReply(rs.getString("reply"));
			tGoodsDis.setTypeValue(rs.getString("type_value"));
			tGoodsDis.setDisValue(rs.getInt("dis_value"));
			tGoodsDis.setImg(rs.getInt("img"));
			tGoodsDis.setGood(rs.getInt("good"));
			tGoodsDis.setLow(rs.getInt("low"));
			tGoodsDis.setCreateTime(rs.getTimestamp("create_time"));
			tGoodsDis.setUpdateTime(rs.getTimestamp("update_time"));
			return tGoodsDis; 
        }  
          
    }
}
