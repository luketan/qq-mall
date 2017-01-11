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
public class TPayment extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "图标",dbName = "icon",length = 32,allowNull=true)
	private String icon=null;
	@FieldMeta(primaryKey = false,fieldName = "名称",dbName = "name",length = 32,allowNull=true)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "类型（2,余额支付）",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "接收账号",dbName = "rev_account",length = 255,allowNull=true)
	private String revAccount=null;
	@FieldMeta(primaryKey = false,fieldName = "支付URL",dbName = "pay_url",length = 255,allowNull=true)
	private String payUrl=null;
	@FieldMeta(primaryKey = false,fieldName = "是否选中",dbName = "check",length = 10,allowNull=true)
	private Integer check=null;
	@FieldMeta(primaryKey = false,fieldName = "删除标志",dbName = "delete_flag",length = 10,allowNull=true)
	private Integer deleteFlag=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TPayment(){
 	}
 	public TPayment(Integer id,String icon,String name,Integer type,String revAccount,String payUrl,Integer check,Integer deleteFlag){
 		this.id = id;
		this.icon = icon;
		this.name = name;
		this.type = type;
		this.revAccount = revAccount;
		this.payUrl = payUrl;
		this.check = check;
		this.deleteFlag = deleteFlag;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*图标*/
	public String getIcon(){
		 return this.icon; 
	}
	public void setIcon(String icon){
		  this.icon = icon; 
	}
	/*名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*类型（2,余额支付）*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*接收账号*/
	public String getRevAccount(){
		 return this.revAccount; 
	}
	public void setRevAccount(String revAccount){
		  this.revAccount = revAccount; 
	}
	/*支付URL*/
	public String getPayUrl(){
		 return this.payUrl; 
	}
	public void setPayUrl(String payUrl){
		  this.payUrl = payUrl; 
	}
	/*是否选中*/
	public Integer getCheck(){
		 return this.check; 
	}
	public void setCheck(Integer check){
		  this.check = check; 
	}
	/*删除标志*/
	public Integer getDeleteFlag(){
		 return this.deleteFlag; 
	}
	public void setDeleteFlag(Integer deleteFlag){
		  this.deleteFlag = deleteFlag; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}
	/*修改时间*/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}

	
	public enum DBMaping{
		tableName("t_payment",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		icon("icon",Types.VARCHAR,false,false,true),
		name("name",Types.VARCHAR,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		revAccount("rev_account",Types.VARCHAR,false,false,true),
		payUrl("pay_url",Types.VARCHAR,false,false,true),
		check("check",Types.INTEGER,false,false,true),
		deleteFlag("delete_flag",Types.INTEGER,false,false,true),
		createTime("create_time",Types.TIMESTAMP,false,false,true),
		updateTime("update_time",Types.TIMESTAMP,false,false,true);
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
	public static class TPaymentRowMapper implements RowMapper<TPayment> {  
        @Override  
        public TPayment mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TPayment tPayment = new TPayment();
			tPayment.setId(rs.getInt("id"));
			tPayment.setIcon(rs.getString("icon"));
			tPayment.setName(rs.getString("name"));
			tPayment.setType(rs.getInt("type"));
			tPayment.setRevAccount(rs.getString("rev_account"));
			tPayment.setPayUrl(rs.getString("pay_url"));
			tPayment.setCheck(rs.getInt("check"));
			tPayment.setDeleteFlag(rs.getInt("delete_flag"));
			tPayment.setCreateTime(rs.getTimestamp("create_time"));
			tPayment.setUpdateTime(rs.getTimestamp("update_time"));
			return tPayment; 
        }  
          
    }
}
