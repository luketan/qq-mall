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
*
**/
public class TUser extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "用户ID",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "昵称",dbName = "nick_name",length = 20,allowNull=true)
	private String nickName=null;
	@FieldMeta(primaryKey = false,fieldName = "账号",dbName = "account",length = 64,allowNull=false)
	private String account=null;
	@FieldMeta(primaryKey = false,fieldName = "密码",dbName = "password",length = 64,allowNull=false)
	private String password=null;
	@FieldMeta(primaryKey = false,fieldName = "个性签名",dbName = "sign",length = 50,allowNull=true)
	private String sign=null;
	@FieldMeta(primaryKey = false,fieldName = "头像",dbName = "head",length = 225,allowNull=true)
	private String head=null;
	@FieldMeta(primaryKey = false,fieldName = "邮箱",dbName = "email",length = 50,allowNull=true)
	private String email=null;
	@FieldMeta(primaryKey = false,fieldName = "是否已认证(0否,1是)",dbName = "email_is",length = 10,allowNull=true)
	private Integer emailIs=null;
	@FieldMeta(primaryKey = false,fieldName = "手机号码",dbName = "phone",length = 50,allowNull=true)
	private String phone=null;
	@FieldMeta(primaryKey = false,fieldName = "是否已认证(0否,1是)",dbName = "phone_is",length = 10,allowNull=true)
	private Integer phoneIs=null;
	@FieldMeta(primaryKey = false,fieldName = "年龄（出生年月）",dbName = "age",length = 12,allowNull=true)
	private String age=null;
	@FieldMeta(primaryKey = false,fieldName = "性别(1男，2女)",dbName = "sex",length = 10,allowNull=true)
	private Integer sex=null;
	@FieldMeta(primaryKey = false,fieldName = "性取向(1爱好男，2爱好女，3双性恋，4无性恋，5保密)",dbName = "sexu",length = 10,allowNull=true)
	private Integer sexu=null;
	@FieldMeta(primaryKey = false,fieldName = "婚恋状态(1单身，2恋爱中，3已婚，4离异)",dbName = "marr",length = 10,allowNull=true)
	private Integer marr=null;
	@FieldMeta(primaryKey = false,fieldName = "是否是体验师",dbName = "try_is",length = 10,allowNull=true)
	private Integer tryIs=null;
	@FieldMeta(primaryKey = false,fieldName = "用户类型，1普通，2小编",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "状态(0未激活,1正常，2被锁定，3被拉黑)",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "from",length = 50,allowNull=true)
	private String from=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUser(){
 	}
 	public TUser(Integer id,String nickName,String account,String password,String sign,String head,String email,Integer emailIs,String phone,Integer phoneIs,String age,Integer sex,Integer sexu,Integer marr,Integer tryIs,Integer type,Integer status,String from){
 		this.id = id;
		this.nickName = nickName;
		this.account = account;
		this.password = password;
		this.sign = sign;
		this.head = head;
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
	public static class TUserRowMapper implements RowMapper<TUser> {  
        @Override  
        public TUser mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUser tUser = new TUser();
			tUser.setId(rs.getInt("id"));
			tUser.setNickName(rs.getString("nick_name"));
			tUser.setAccount(rs.getString("account"));
			tUser.setPassword(rs.getString("password"));
			tUser.setSign(rs.getString("sign"));
			tUser.setHead(rs.getString("head"));
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
