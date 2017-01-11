package com.honglinktech.zbgj.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.math.BigDecimal; 

import java.util.Date; 


/**
*
**/
public class UserBean extends BaseEntity implements Serializable{

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

	
	public enum DBMaping{
		tableName("t_user",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		nickName("nick_name",Types.VARCHAR,false,false,true),
		account("account",Types.VARCHAR,false,false,false),
		password("password",Types.VARCHAR,false,false,false),
		sign("sign",Types.VARCHAR,false,false,true),
		head("head",Types.VARCHAR,false,false,true),
		virtualMoney("virtual_money",Types.DECIMAL,false,false,true),
		money("money",Types.DECIMAL,false,false,true),
		point("point",Types.INTEGER,false,false,true),
		exp("exp",Types.INTEGER,false,false,true),
		level("level",Types.INTEGER,false,false,true),
		email("email",Types.VARCHAR,false,false,true),
		emailIs("email_is",Types.INTEGER,false,false,true),
		phone("phone",Types.VARCHAR,false,false,true),
		phoneIs("phone_is",Types.INTEGER,false,false,true),
		age("age",Types.VARCHAR,false,false,true),
		sex("sex",Types.INTEGER,false,false,true),
		sexu("sexu",Types.INTEGER,false,false,true),
		marr("marr",Types.INTEGER,false,false,true),
		tryIs("try_is",Types.INTEGER,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		from("from",Types.VARCHAR,false,false,true),
		updateTime("update_time",Types.TIMESTAMP,false,false,true),
		createTime("create_time",Types.TIMESTAMP,false,false,true);
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
	public static class UserRowMapper implements RowMapper<UserBean> {  
        @Override  
        public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {  

			UserBean tUser = new UserBean();
			tUser.setId(rs.getInt("id"));
			tUser.setNickName(rs.getString("nick_name"));
			tUser.setAccount(rs.getString("account"));
			tUser.setPassword(rs.getString("password"));
			tUser.setSign(rs.getString("sign"));
			tUser.setHead(rs.getString("head"));
			tUser.setVirtualMoney(rs.getBigDecimal("virtual_money"));
			tUser.setMoney(rs.getBigDecimal("money"));
			tUser.setPoint(rs.getInt("point"));
			tUser.setExp(rs.getInt("exp"));
			tUser.setLevel(rs.getInt("level"));
			tUser.setEmail(rs.getString("email"));
			tUser.setEmailIs(rs.getInt("email_is"));
			tUser.setPhone(rs.getString("phone"));
			tUser.setPhoneIs(rs.getInt("phone_is"));
			tUser.setAge(rs.getString("age"));
			tUser.setSex(rs.getInt("sex"));
			tUser.setSexu(rs.getInt("sexu"));
			tUser.setMarr(rs.getInt("marr"));
			tUser.setTryIs(rs.getInt("try_is"));
			tUser.setType(rs.getInt("type"));
			tUser.setStatus(rs.getInt("status"));
			tUser.setFrom(rs.getString("from"));
			tUser.setUpdateTime(rs.getTimestamp("update_time"));
			tUser.setCreateTime(rs.getTimestamp("create_time"));
			return tUser; 
        }  
          
    }
}
