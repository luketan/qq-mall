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
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "coupon_id",length = 10,allowNull=false)
	private Integer couponId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "coupon_name",length = 128,allowNull=true)
	private String couponName=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "value",length = 10,allowNull=true)
	private Integer value=null;
	@FieldMeta(primaryKey = false,fieldName = "1正常",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "start_date",length = 19,allowNull=true)
	private Date startDate=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "end_date",length = 19,allowNull=true)
	private Date endDate=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TCouponUser(){
 	}
 	public TCouponUser(Integer id,Integer couponId,String couponName,Integer value,Integer status,Date startDate,Date endDate){
 		this.id = id;
		this.couponId = couponId;
		this.couponName = couponName;
		this.value = value;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/**/
	public Integer getCouponId(){
		 return this.couponId; 
	}
	public void setCouponId(Integer couponId){
		  this.couponId = couponId; 
	}
	/**/
	public String getCouponName(){
		 return this.couponName; 
	}
	public void setCouponName(String couponName){
		  this.couponName = couponName; 
	}
	/**/
	public Integer getValue(){
		 return this.value; 
	}
	public void setValue(Integer value){
		  this.value = value; 
	}
	/*1正常*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}
	/**/
	public Date getStartDate(){
		 return this.startDate; 
	}
	public void setStartDate(Date startDate){
		  this.startDate = startDate; 
	}
	/**/
	public Date getEndDate(){
		 return this.endDate; 
	}
	public void setEndDate(Date endDate){
		  this.endDate = endDate; 
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
		tableName("t_coupon_user",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		couponId("coupon_id",Types.INTEGER,false,false,false),
		couponName("coupon_name",Types.VARCHAR,false,false,true),
		value("value",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		startDate("start_date",Types.TIMESTAMP,false,false,true),
		endDate("end_date",Types.TIMESTAMP,false,false,true),
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
	public static class TCouponUserRowMapper implements RowMapper<TCouponUser> {  
        @Override  
        public TCouponUser mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TCouponUser tCouponUser = new TCouponUser();
			tCouponUser.setId(rs.getInt("id"));
			tCouponUser.setCouponId(rs.getInt("coupon_id"));
			tCouponUser.setCouponName(rs.getString("coupon_name"));
			tCouponUser.setValue(rs.getInt("value"));
			tCouponUser.setStatus(rs.getInt("status"));
			tCouponUser.setStartDate(rs.getTimestamp("start_date"));
			tCouponUser.setEndDate(rs.getTimestamp("end_date"));
			tCouponUser.setUpdateTime(rs.getTimestamp("update_time"));
			tCouponUser.setCreateTime(rs.getTimestamp("create_time"));
			return tCouponUser; 
        }  
          
    }
}
