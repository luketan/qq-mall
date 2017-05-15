package com.honglinktech.zbgj.bean;

import com.honglinktech.zbgj.entity.User;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
*
**/
public class UserBean implements Serializable{

	private Integer id=null;
	private String nickName=null;
	private String account=null;
	private String password=null;
	private String sign=null;
	private String head=null;
	private BigDecimal virtualMoney=null;
	private BigDecimal money=null;
	private Integer point=null;
	private Integer exp=null;
	private Integer level=null;
	private String email=null;
	private Integer emailIs=null;
	private String phone=null;
	private Integer phoneIs=null;
	private String age=null;
	private Integer sex=null;
	private Integer sexu=null;
	private Integer marr=null;
	private Integer tryIs=null;
	private Integer type=null;
	private Integer status=null;
	private String from=null;
	private Date updateTime=null;
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserBean(){
 	}
	public UserBean(User user){
		this.id = user.getId();
		this.nickName = user.getNickName();
		this.account = user.getAccount();
		this.sign = user.getSign();
		this.head = user.getHead();

		this.exp = user.getExp();
		this.level = user.getLevel();
		this.email = user.getEmail();
		this.emailIs = user.getEmailIs();
		this.phone = user.getPhone();
		this.phoneIs = user.getPhoneIs();
		this.age = user.getAge();
		this.sex = user.getSex();
		this.sexu = user.getSexu();
		this.marr = user.getMarr();
		this.tryIs = user.getTryIs();
		this.type = user.getType();
		this.status = user.getStatus();
		this.from = user.getFrom();
		this.updateTime = user.getUpdateTime();
		this.createTime = user.getCreateTime();
	}
 	public UserBean(Integer id,String nickName,String account,String password,String sign,String head,BigDecimal virtualMoney,BigDecimal money,Integer point,Integer exp,Integer level,String email,Integer emailIs,String phone,Integer phoneIs,String age,Integer sex,Integer sexu,Integer marr,Integer tryIs,Integer type,Integer status,String from){
 		this.id = id;
		this.nickName = nickName;
		this.account = account;
		this.password = password;
		this.sign = sign;
		this.head = head;
		this.virtualMoney = virtualMoney;
		this.money = money;
		this.point = point;
		this.exp = exp;
		this.level = level;
		this.email = email;
		this.emailIs = emailIs;
		this.phone = phone;
		this.phoneIs = phoneIs;
		this.age = age;
		this.sex = sex;
		this.sexu = sexu;
		this.marr = marr;
		this.tryIs = tryIs;
		this.type = type;
		this.status = status;
		this.from = from;
		
 	}
 	
		/*用户ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*昵称*/
	public String getNickName(){
		 return this.nickName; 
	}
	public void setNickName(String nickName){
		  this.nickName = nickName; 
	}
	/*账号*/
	public String getAccount(){
		 return this.account; 
	}
	public void setAccount(String account){
		  this.account = account; 
	}
	/*密码*/
	public String getPassword(){
		 return this.password; 
	}
	public void setPassword(String password){
		  this.password = password; 
	}
	/*个性签名*/
	public String getSign(){
		 return this.sign; 
	}
	public void setSign(String sign){
		  this.sign = sign; 
	}
	/*头像*/
	public String getHead(){
		 return this.head; 
	}
	public void setHead(String head){
		  this.head = head; 
	}
	/*虚拟币(逗币)*/
	public BigDecimal getVirtualMoney(){
		 return this.virtualMoney; 
	}
	public void setVirtualMoney(BigDecimal virtualMoney){
		  this.virtualMoney = virtualMoney; 
	}
	/*账户余额*/
	public BigDecimal getMoney(){
		 return this.money; 
	}
	public void setMoney(BigDecimal money){
		  this.money = money; 
	}
	/*商城积分*/
	public Integer getPoint(){
		 return this.point; 
	}
	public void setPoint(Integer point){
		  this.point = point; 
	}
	/*社区经验*/
	public Integer getExp(){
		 return this.exp; 
	}
	public void setExp(Integer exp){
		  this.exp = exp; 
	}
	/*社区级别*/
	public Integer getLevel(){
		 return this.level; 
	}
	public void setLevel(Integer level){
		  this.level = level; 
	}
	/*邮箱*/
	public String getEmail(){
		 return this.email; 
	}
	public void setEmail(String email){
		  this.email = email; 
	}
	/*是否已认证(0否,1是)*/
	public Integer getEmailIs(){
		 return this.emailIs; 
	}
	public void setEmailIs(Integer emailIs){
		  this.emailIs = emailIs; 
	}
	/*手机号码*/
	public String getPhone(){
		 return this.phone; 
	}
	public void setPhone(String phone){
		  this.phone = phone; 
	}
	/*是否已认证(0否,1是)*/
	public Integer getPhoneIs(){
		 return this.phoneIs; 
	}
	public void setPhoneIs(Integer phoneIs){
		  this.phoneIs = phoneIs; 
	}
	/*年龄（出生年月）*/
	public String getAge(){
		 return this.age; 
	}
	public void setAge(String age){
		  this.age = age; 
	}
	/*性别(1男，2女)*/
	public Integer getSex(){
		 return this.sex; 
	}
	public void setSex(Integer sex){
		  this.sex = sex; 
	}
	/*性取向(1爱好男，2爱好女，3双性恋，4无性恋，5保密)*/
	public Integer getSexu(){
		 return this.sexu; 
	}
	public void setSexu(Integer sexu){
		  this.sexu = sexu; 
	}
	/*婚恋状态(1单身，2恋爱中，3已婚，4离异)*/
	public Integer getMarr(){
		 return this.marr; 
	}
	public void setMarr(Integer marr){
		  this.marr = marr; 
	}
	/*是否是体验师*/
	public Integer getTryIs(){
		 return this.tryIs; 
	}
	public void setTryIs(Integer tryIs){
		  this.tryIs = tryIs; 
	}
	/*用户类型，1普通，2小编*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*状态(0未激活,1正常，2被锁定，3被拉黑)*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}
	/**/
	public String getFrom(){
		 return this.from; 
	}
	public void setFrom(String from){
		  this.from = from; 
	}
	/*修改时间*/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}
}
