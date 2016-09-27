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
*快递公司表
**/
public class TPostCompany extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "公司名称",dbName = "name",length = 50,allowNull=true)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "联系地址",dbName = "address",length = 255,allowNull=true)
	private String address=null;
	@FieldMeta(primaryKey = false,fieldName = "负责人",dbName = "director",length = 15,allowNull=true)
	private String director=null;
	@FieldMeta(primaryKey = false,fieldName = "联系电话",dbName = "telephone",length = 15,allowNull=true)
	private String telephone=null;
	@FieldMeta(primaryKey = false,fieldName = "接口地址",dbName = "api_url",length = 255,allowNull=true)
	private String apiUrl=null;
	@FieldMeta(primaryKey = false,fieldName = "接口帐号",dbName = "api_account",length = 64,allowNull=true)
	private String apiAccount=null;
	@FieldMeta(primaryKey = false,fieldName = "接口代码|KEY",dbName = "api_code",length = 64,allowNull=true)
	private String apiCode=null;
	@FieldMeta(primaryKey = false,fieldName = "接口密码",dbName = "api_password",length = 36,allowNull=true)
	private String apiPassword=null;
	@FieldMeta(primaryKey = false,fieldName = "快递公司编码(要跟快递100对应)",dbName = "code",length = 32,allowNull=true)
	private String code=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TPostCompany(){
 	}
 	public TPostCompany(Integer id,String name,String address,String director,String telephone,String apiUrl,String apiAccount,String apiCode,String apiPassword,String code){
 		this.id = id;
		this.name = name;
		this.address = address;
		this.director = director;
		this.telephone = telephone;
		this.apiUrl = apiUrl;
		this.apiAccount = apiAccount;
		this.apiCode = apiCode;
		this.apiPassword = apiPassword;
		this.code = code;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*公司名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*联系地址*/
	public String getAddress(){
		 return this.address; 
	}
	public void setAddress(String address){
		  this.address = address; 
	}
	/*负责人*/
	public String getDirector(){
		 return this.director; 
	}
	public void setDirector(String director){
		  this.director = director; 
	}
	/*联系电话*/
	public String getTelephone(){
		 return this.telephone; 
	}
	public void setTelephone(String telephone){
		  this.telephone = telephone; 
	}
	/*接口地址*/
	public String getApiUrl(){
		 return this.apiUrl; 
	}
	public void setApiUrl(String apiUrl){
		  this.apiUrl = apiUrl; 
	}
	/*接口帐号*/
	public String getApiAccount(){
		 return this.apiAccount; 
	}
	public void setApiAccount(String apiAccount){
		  this.apiAccount = apiAccount; 
	}
	/*接口代码|KEY*/
	public String getApiCode(){
		 return this.apiCode; 
	}
	public void setApiCode(String apiCode){
		  this.apiCode = apiCode; 
	}
	/*接口密码*/
	public String getApiPassword(){
		 return this.apiPassword; 
	}
	public void setApiPassword(String apiPassword){
		  this.apiPassword = apiPassword; 
	}
	/*快递公司编码(要跟快递100对应)*/
	public String getCode(){
		 return this.code; 
	}
	public void setCode(String code){
		  this.code = code; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

	
	public enum DBMaping{
		tableName("t_post_company",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,true),
		address("address",Types.VARCHAR,false,false,true),
		director("director",Types.VARCHAR,false,false,true),
		telephone("telephone",Types.VARCHAR,false,false,true),
		apiUrl("api_url",Types.VARCHAR,false,false,true),
		apiAccount("api_account",Types.VARCHAR,false,false,true),
		apiCode("api_code",Types.VARCHAR,false,false,true),
		apiPassword("api_password",Types.VARCHAR,false,false,true),
		code("code",Types.VARCHAR,false,false,true),
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
	public static class TPostCompanyRowMapper implements RowMapper<TPostCompany> {  
        @Override  
        public TPostCompany mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TPostCompany tPostCompany = new TPostCompany();
			tPostCompany.setId(rs.getInt("id"));
			tPostCompany.setName(rs.getString("name"));
			tPostCompany.setAddress(rs.getString("address"));
			tPostCompany.setDirector(rs.getString("director"));
			tPostCompany.setTelephone(rs.getString("telephone"));
			tPostCompany.setApiUrl(rs.getString("api_url"));
			tPostCompany.setApiAccount(rs.getString("api_account"));
			tPostCompany.setApiCode(rs.getString("api_code"));
			tPostCompany.setApiPassword(rs.getString("api_password"));
			tPostCompany.setCode(rs.getString("code"));
			tPostCompany.setCreateTime(rs.getTimestamp("create_time"));
			return tPostCompany; 
        }  
          
    }
}
