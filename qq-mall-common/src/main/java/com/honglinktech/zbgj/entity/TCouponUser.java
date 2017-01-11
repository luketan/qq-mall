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
public class TCouponUser extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "用户ID",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "券ID",dbName = "coupon_id",length = 10,allowNull=false)
	private Integer couponId=null;
	@FieldMeta(primaryKey = false,fieldName = "是否已经选中",dbName = "checked",length = 10,allowNull=true)
	private Integer checked=null;
	@FieldMeta(primaryKey = false,fieldName = "唯一识别码",dbName = "code",length = 255,allowNull=true)
	private String code=null;
	@FieldMeta(primaryKey = false,fieldName = "状态(0未使用，1是已使用)",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TCouponUser(){
 	}
 	public TCouponUser(Integer id,Integer userId,Integer couponId,Integer checked,String code,Integer status){
 		this.id = id;
		this.userId = userId;
		this.couponId = couponId;
		this.checked = checked;
		this.code = code;
		this.status = status;
		
 	}
 	
		/**/
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
	/*券ID*/
	public Integer getCouponId(){
		 return this.couponId; 
	}
	public void setCouponId(Integer couponId){
		  this.couponId = couponId; 
	}
	/*是否已经选中*/
	public Integer getChecked(){
		 return this.checked; 
	}
	public void setChecked(Integer checked){
		  this.checked = checked; 
	}
	/*唯一识别码*/
	public String getCode(){
		 return this.code; 
	}
	public void setCode(String code){
		  this.code = code; 
	}
	/*状态(0未使用，1是已使用)*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

	
	public enum DBMaping{
		tableName("t_coupon_user",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userId("user_id",Types.INTEGER,false,false,false),
		couponId("coupon_id",Types.INTEGER,false,false,false),
		checked("checked",Types.INTEGER,false,false,true),
		code("code",Types.VARCHAR,false,false,true),
		status("status",Types.INTEGER,false,false,true),
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
	public static class TCouponUserRowMapper implements RowMapper<TCouponUser> {  
        @Override  
        public TCouponUser mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TCouponUser tCouponUser = new TCouponUser();
			tCouponUser.setId(rs.getInt("id"));
			tCouponUser.setUserId(rs.getInt("user_id"));
			tCouponUser.setCouponId(rs.getInt("coupon_id"));
			tCouponUser.setChecked(rs.getInt("checked"));
			tCouponUser.setCode(rs.getString("code"));
			tCouponUser.setStatus(rs.getInt("status"));
			tCouponUser.setCreateTime(rs.getTimestamp("create_time"));
			return tCouponUser; 
        }  
          
    }
}
