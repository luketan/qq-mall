package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.util.Date;


/**
*帖子
**/
public class SocietyNoteRewardBean implements Serializable{

	private Integer id=null;
	private Integer societyNoteId=null;
	private Integer userId=null;
	private Integer busUserId=null;
	private Integer type=null;
	private Integer valNum=null;
	private Date createTime=null;
	
	private String nickName=null;
	private int sex;
	private int level;
	private String head;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SocietyNoteRewardBean(){
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	
}
