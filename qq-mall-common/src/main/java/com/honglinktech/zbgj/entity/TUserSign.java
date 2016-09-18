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
*用户的个性签名记录
**/
public class TUserSign extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "ID",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "用户ID",dbName = "user_id",length = 10,allowNull=true)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "个性签名",dbName = "sign",length = 225,allowNull=true)
	private String sign=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserSign(){
 	}
 	public TUserSign(Integer id,Integer userId,String sign){
 		this.id = id;
		this.userId = userId;
		this.sign = sign;
		
 	}
 	
		/*ID*/
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
	/*个性签名*/
	public String getSign(){
		 return this.sign; 
	}
	public void setSign(String sign){
		  this.sign = sign; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

	
	public enum DBMaping{
		tableName("t_user_sign",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userId("user_id",Types.INTEGER,false,false,true),
		sign("sign",Types.VARCHAR,false,false,true),
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
	public static class TUserSignRowMapper implements RowMapper<TUserSign> {  
        @Override  
        public TUserSign mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserSign tUserSign = new TUserSign();
			tUserSign.setId(rs.getInt("id"));
			tUserSign.setUserId(rs.getInt("user_id"));
			tUserSign.setSign(rs.getString("sign"));
			tUserSign.setCreateTime(rs.getTimestamp("create_time"));
			return tUserSign; 
        }  
          
    }
}
