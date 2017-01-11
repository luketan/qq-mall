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
*活动
**/
public class TOrderActivity extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "活动ID",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "订单ID",dbName = "order_id",length = 10,allowNull=true)
	private Integer orderId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "activity_id",length = 10,allowNull=true)
	private Integer activityId=null;
	@FieldMeta(primaryKey = false,fieldName = "活动名称",dbName = "name",length = 225,allowNull=true)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "活动链接地址",dbName = "url",length = 255,allowNull=true)
	private String url=null;
	@FieldMeta(primaryKey = false,fieldName = "活动详情",dbName = "detail",length = 225,allowNull=true)
	private String detail=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TOrderActivity(){
 	}
 	public TOrderActivity(Integer id,Integer orderId,Integer activityId,String name,String url,String detail){
 		this.id = id;
		this.orderId = orderId;
		this.activityId = activityId;
		this.name = name;
		this.url = url;
		this.detail = detail;
		
 	}
 	
		/*活动ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*订单ID*/
	public Integer getOrderId(){
		 return this.orderId; 
	}
	public void setOrderId(Integer orderId){
		  this.orderId = orderId; 
	}
	/**/
	public Integer getActivityId(){
		 return this.activityId; 
	}
	public void setActivityId(Integer activityId){
		  this.activityId = activityId; 
	}
	/*活动名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*活动链接地址*/
	public String getUrl(){
		 return this.url; 
	}
	public void setUrl(String url){
		  this.url = url; 
	}
	/*活动详情*/
	public String getDetail(){
		 return this.detail; 
	}
	public void setDetail(String detail){
		  this.detail = detail; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

	
	public enum DBMaping{
		tableName("t_order_activity",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		orderId("order_id",Types.INTEGER,false,false,true),
		activityId("activity_id",Types.INTEGER,false,false,true),
		name("name",Types.VARCHAR,false,false,true),
		url("url",Types.VARCHAR,false,false,true),
		detail("detail",Types.VARCHAR,false,false,true),
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
	public static class TOrderActivityRowMapper implements RowMapper<TOrderActivity> {  
        @Override  
        public TOrderActivity mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TOrderActivity tOrderActivity = new TOrderActivity();
			tOrderActivity.setId(rs.getInt("id"));
			tOrderActivity.setOrderId(rs.getInt("order_id"));
			tOrderActivity.setActivityId(rs.getInt("activity_id"));
			tOrderActivity.setName(rs.getString("name"));
			tOrderActivity.setUrl(rs.getString("url"));
			tOrderActivity.setDetail(rs.getString("detail"));
			tOrderActivity.setCreateTime(rs.getTimestamp("create_time"));
			return tOrderActivity; 
        }  
          
    }
}
