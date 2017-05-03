package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.honglinktech.zbgj.entity.GoodsDis;


/**
*产品款式
**/
public class GoodsDisBean implements Serializable{

	private Integer id=null;
	private Integer goodsId=null;
	private Integer userId=null;
	private String userName=null;
	private Integer goodsFormatId=null;
	private String goodsFormat=null;
	private String content=null;
	private Date replyTime=null;
	private String reply=null;
	private String typeValue=null;
	private Integer disValue=null;
	private Integer img=null;
	private Integer good=null;
	private Integer low=null;
	private Date createTime=null;
	private Date updateTime=null;
	
	private List<PicBean> picBeanList;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GoodsDisBean(){
 	}
	
	public GoodsDisBean(GoodsDis tgoodsDis){
		this.content = tgoodsDis.getContent();
		this.createTime = tgoodsDis.getCreateTime();
		this.disValue = tgoodsDis.getDisValue();
		this.good = tgoodsDis.getGood();
		this.goodsFormat = tgoodsDis.getGoodsFormat();
		this.goodsFormatId = tgoodsDis.getGoodsFormatId();
		this.goodsId = tgoodsDis.getGoodsId();
		this.id = tgoodsDis.getId();
		this.img = tgoodsDis.getImg();
		this.low = tgoodsDis.getLow();
		this.reply = tgoodsDis.getReply();
		this.replyTime = tgoodsDis.getReplyTime();
		this.typeValue = tgoodsDis.getTypeValue();
		this.updateTime = tgoodsDis.getUpdateTime();
		this.userId = tgoodsDis.getUserId();
		this.userName = tgoodsDis.getUserName();
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
	public List<PicBean> getPicBeanList() {
		return picBeanList;
	}
	public void setPicBeanList(List<PicBean> picBeanList) {
		this.picBeanList = picBeanList;
	}

}
