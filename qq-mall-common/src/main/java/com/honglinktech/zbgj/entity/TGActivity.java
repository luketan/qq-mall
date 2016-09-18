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
public class TGActivity extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "活动ID",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "活动名称",dbName = "name",length = 225,allowNull=false)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "活动类型(1打折,2包邮,3赠送)",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "活动系数",dbName = "args",length = 225,allowNull=true)
	private String args=null;
	@FieldMeta(primaryKey = false,fieldName = "活动详情",dbName = "detail",length = 225,allowNull=true)
	private String detail=null;
	@FieldMeta(primaryKey = false,fieldName = "是否有时效(0无时效，1有时效)",dbName = "available",length = 10,allowNull=true)
	private Integer available=null;
	@FieldMeta(primaryKey = false,fieldName = "开始时间",dbName = "start_time",length = 19,allowNull=true)
	private Date startTime=null;
	@FieldMeta(primaryKey = false,fieldName = "结束时间",dbName = "end_time",length = 19,allowNull=true)
	private Date endTime=null;
	@FieldMeta(primaryKey = false,fieldName = "状态(1正常，2删除，3下架)",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TGActivity(){
 	}
 	public TGActivity(Integer id,String name,Integer type,String args,String detail,Integer available,Date startTime,Date endTime,Integer status){
 		this.id = id;
		this.name = name;
		this.type = type;
		this.args = args;
		this.detail = detail;
		this.available = available;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		
 	}
 	
		/*活动ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*活动名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*活动类型(1打折,2包邮,3赠送)*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*活动系数*/
	public String getArgs(){
		 return this.args; 
	}
	public void setArgs(String args){
		  this.args = args; 
	}
	/*活动详情*/
	public String getDetail(){
		 return this.detail; 
	}
	public void setDetail(String detail){
		  this.detail = detail; 
	}
	/*是否有时效(0无时效，1有时效)*/
	public Integer getAvailable(){
		 return this.available; 
	}
	public void setAvailable(Integer available){
		  this.available = available; 
	}
	/*开始时间*/
	public Date getStartTime(){
		 return this.startTime; 
	}
	public void setStartTime(Date startTime){
		  this.startTime = startTime; 
	}
	/*结束时间*/
	public Date getEndTime(){
		 return this.endTime; 
	}
	public void setEndTime(Date endTime){
		  this.endTime = endTime; 
	}
	/*状态(1正常，2删除，3下架)*/
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
	/*修改时间*/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}

	
	public enum DBMaping{
		tableName("t_g_activity",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,false),
		args("args",Types.VARCHAR,false,false,true),
		detail("detail",Types.VARCHAR,false,false,true),
		startTime("start_time",Types.TIMESTAMP,false,false,true),
		endTime("end_time",Types.TIMESTAMP,false,false,true),
		status("status",Types.INTEGER,false,false,true),
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
	public static class TGActivityRowMapper implements RowMapper<TGActivity> {  
        @Override  
        public TGActivity mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TGActivity tGActivity = new TGActivity();
			tGActivity.setId(rs.getInt("id"));
			tGActivity.setName(rs.getString("name"));
			tGActivity.setArgs(rs.getString("args"));
			tGActivity.setDetail(rs.getString("detail"));
			tGActivity.setStartTime(rs.getTimestamp("start_time"));
			tGActivity.setEndTime(rs.getTimestamp("end_time"));
			tGActivity.setStatus(rs.getInt("status"));
			tGActivity.setCreateTime(rs.getTimestamp("create_time"));
			tGActivity.setUpdateTime(rs.getTimestamp("update_time"));
			return tGActivity; 
        }  
          
    }
}
