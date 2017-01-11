package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.honglinktech.zbgj.base.BaseEntity;


/**
*优惠券
**/
public class PaymentBean extends BaseEntity implements Serializable{

	private Integer id=null;
	private String icon=null;
	private String name=null;
	private Integer type=null;
	@JsonIgnore
	private String revAccount=null;
	@JsonIgnore
	private String payUrl=null;
	private Integer checked=null;
	@JsonIgnore
	private Integer deleteFlag=null;
	@JsonIgnore
	private Date createTime=null;
	@JsonIgnore
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	public Integer getChecked() {
		return checked;
	}
	public void setChecked(Integer checked) {
		this.checked = checked;
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
	public static class PaymentBeanRowMapper implements RowMapper<PaymentBean> {  
        @Override  
        public PaymentBean mapRow(ResultSet rs, int rowNum) throws SQLException {  

			PaymentBean tPayment = new PaymentBean();
			tPayment.setId(rs.getInt("id"));
			tPayment.setIcon(rs.getString("icon"));
			tPayment.setName(rs.getString("name"));
			tPayment.setType(rs.getInt("type"));
			tPayment.setRevAccount(rs.getString("rev_account"));
			tPayment.setPayUrl(rs.getString("pay_url"));
			tPayment.setChecked(rs.getInt("checked"));
			tPayment.setDeleteFlag(rs.getInt("delete_flag"));
			tPayment.setCreateTime(rs.getTimestamp("create_time"));
			tPayment.setUpdateTime(rs.getTimestamp("update_time"));
			return tPayment; 
        }  
          
    }
}
