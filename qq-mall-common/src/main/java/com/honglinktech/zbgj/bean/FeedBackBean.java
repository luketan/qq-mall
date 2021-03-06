package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.honglinktech.zbgj.entity.FeedBack;
import com.honglinktech.zbgj.entity.Pic;


/**
*用户反馈表
**/
public class FeedBackBean implements Serializable{

	private Integer id=null;
	private Integer userId=null;
	private String detail=null;
	private Integer readIs=null;
	private Date createTime=null;
	private Date replyTime;
	private String reply;
	private List<PicBean> picBeanList;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FeedBackBean(){
 	}
	
	public FeedBackBean(FeedBack feedBack){
 		this.id = feedBack.getId();
		this.userId = feedBack.getUserId();
		this.detail = feedBack.getDetail();
		this.readIs = feedBack.getReadIs();
		this.replyTime = feedBack.getReplyTime();
		this.reply = feedBack.getReply();
		this.createTime = feedBack.getCreateTime();
 	}
	
	public FeedBackBean(Integer id,Integer userId,String detail,String reply,Date replyTime,Integer readIs){
 		this.id = id;
		this.userId = userId;
		this.detail = detail;
		this.reply = reply;
		this.replyTime = replyTime;
		this.readIs = readIs;
 	}
 	
		/*反馈ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*用户ID*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*反馈详情*/
	public String getDetail(){
		 return this.detail; 
	}
	public void setDetail(String detail){
		  this.detail = detail; 
	}
	/*是否已读*/
	public Integer getReadIs(){
		 return this.readIs; 
	}
	public void setReadIs(Integer readIs){
		  this.readIs = readIs; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}

	public List<PicBean> getPicBeanList() {
		return picBeanList;
	}

	public void setPicBeanList(List<PicBean> picBeanList) {
		this.picBeanList = picBeanList;
	}
}
