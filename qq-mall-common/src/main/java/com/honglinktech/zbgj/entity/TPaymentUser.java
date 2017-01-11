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
*用户默认支付方式
**/
public class TPaymentUser extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "用户ID",dbName = "user_id",length = 10,allowNull=true)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "支付ID",dbName = "payment_id",length = 10,allowNull=true)
	private Integer paymentId=null;
	@FieldMeta(primaryKey = false,fieldName = "是否选中",dbName = "checked",length = 10,allowNull=true)
	private Integer checked=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TPaymentUser(){
 	}
 	public TPaymentUser(Integer id,Integer userId,Integer paymentId,Integer checked){
 		this.id = id;
		this.userId = userId;
		this.paymentId = paymentId;
		this.checked = checked;
		
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
	/*支付ID*/
	public Integer getPaymentId(){
		 return this.paymentId; 
	}
	public void setPaymentId(Integer paymentId){
		  this.paymentId = paymentId; 
	}
	/*是否选中*/
	public Integer getChecked(){
		 return this.checked; 
	}
	public void setChecked(Integer checked){
		  this.checked = checked; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

	
	public enum DBMaping{
		tableName("t_payment_user",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userId("user_id",Types.INTEGER,false,false,true),
		paymentId("payment_id",Types.INTEGER,false,false,true),
		checked("checked",Types.INTEGER,false,false,true),
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
	public static class TPaymentUserRowMapper implements RowMapper<TPaymentUser> {  
        @Override  
        public TPaymentUser mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TPaymentUser tPaymentUser = new TPaymentUser();
			tPaymentUser.setId(rs.getInt("id"));
			tPaymentUser.setUserId(rs.getInt("user_id"));
			tPaymentUser.setPaymentId(rs.getInt("payment_id"));
			tPaymentUser.setChecked(rs.getInt("checked"));
			tPaymentUser.setCreateTime(rs.getTimestamp("create_time"));
			return tPaymentUser; 
        }  
          
    }
}
