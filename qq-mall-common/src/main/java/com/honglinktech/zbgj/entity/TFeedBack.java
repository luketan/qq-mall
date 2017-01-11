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
*用户反馈表
**/
public class TFeedBack extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "反馈ID",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "用户ID",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "反馈详情",dbName = "detail",length = 65535,allowNull=true)
	private String detail=null;
	@FieldMeta(primaryKey = false,fieldName = "系统回复",dbName = "reply",length = 65535,allowNull=true)
	private String reply=null;
	@FieldMeta(primaryKey = false,fieldName = "回复时间",dbName = "reply_time",length = 19,allowNull=true)
	private Date replyTime=null;
	@FieldMeta(primaryKey = false,fieldName = "是否已读",dbName = "read_is",length = 10,allowNull=true)
	private Integer readIs=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TFeedBack(){
 	}
 	public TFeedBack(Integer id,Integer userId,String detail,String reply,Date replyTime,Integer readIs){
 		this.id = id;
		this.userId = userId;
		this.detail = detail;
		this.reply = reply;
		this.replyTime = replyTime;
		this.readIs = readIs;
		
 	}
 	
		/*反馈ID*/
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
	/*反馈详情*/
	public String getDetail(){
		 return this.detail; 
	}
	public void setDetail(String detail){
		  this.detail = detail; 
	}
	/*系统回复*/
	public String getReply(){
		 return this.reply; 
	}
	public void setReply(String reply){
		  this.reply = reply; 
	}
	/*回复时间*/
	public Date getReplyTime(){
		 return this.replyTime; 
	}
	public void setReplyTime(Date replyTime){
		  this.replyTime = replyTime; 
	}
	/*是否已读*/
	public Integer getReadIs(){
		 return this.readIs; 
	}
	public void setReadIs(Integer readIs){
		  this.readIs = readIs; 
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
		tableName("t_feed_back",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userId("user_id",Types.INTEGER,false,false,false),
		detail("detail",Types.LONGVARCHAR,false,false,true),
		reply("reply",Types.LONGVARCHAR,false,false,true),
		replyTime("reply_time",Types.TIMESTAMP,false,false,true),
		readIs("read_is",Types.INTEGER,false,false,true),
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
	public static class TFeedBackRowMapper implements RowMapper<TFeedBack> {  
        @Override  
        public TFeedBack mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TFeedBack tFeedBack = new TFeedBack();
			tFeedBack.setId(rs.getInt("id"));
			tFeedBack.setUserId(rs.getInt("user_id"));
			tFeedBack.setDetail(rs.getString("detail"));
			tFeedBack.setReply(rs.getString("reply"));
			tFeedBack.setReplyTime(rs.getTimestamp("reply_time"));
			tFeedBack.setReadIs(rs.getInt("read_is"));
			tFeedBack.setUpdateTime(rs.getTimestamp("update_time"));
			tFeedBack.setCreateTime(rs.getTimestamp("create_time"));
			return tFeedBack; 
        }  
          
    }
}
