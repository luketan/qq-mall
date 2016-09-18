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
*系统消息
**/
public class TSystemMsg extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "发送方0是系统",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "内容",dbName = "content",length = 225,allowNull=true)
	private String content=null;
	@FieldMeta(primaryKey = false,fieldName = "消息类型1系统通知",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "是否已读0未读，1已读",dbName = "read_is",length = 10,allowNull=true)
	private Integer readIs=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TSystemMsg(){
 	}
 	public TSystemMsg(Integer id,Integer userId,String content,Integer type,Integer readIs){
 		this.id = id;
		this.userId = userId;
		this.content = content;
		this.type = type;
		this.readIs = readIs;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*发送方0是系统*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*内容*/
	public String getContent(){
		 return this.content; 
	}
	public void setContent(String content){
		  this.content = content; 
	}
	/*消息类型1系统通知*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*是否已读0未读，1已读*/
	public Integer getReadIs(){
		 return this.readIs; 
	}
	public void setReadIs(Integer readIs){
		  this.readIs = readIs; 
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
		tableName("t_system_msg",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userId("user_id",Types.INTEGER,false,false,false),
		content("content",Types.VARCHAR,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		readIs("read_is",Types.INTEGER,false,false,true),
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
	public static class TSystemMsgRowMapper implements RowMapper<TSystemMsg> {  
        @Override  
        public TSystemMsg mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSystemMsg tSystemMsg = new TSystemMsg();
			tSystemMsg.setId(rs.getInt("id"));
			tSystemMsg.setUserId(rs.getInt("user_id"));
			tSystemMsg.setContent(rs.getString("content"));
			tSystemMsg.setType(rs.getInt("type"));
			tSystemMsg.setReadIs(rs.getInt("read_is"));
			tSystemMsg.setCreateTime(rs.getTimestamp("create_time"));
			tSystemMsg.setUpdateTime(rs.getTimestamp("update_time"));
			return tSystemMsg; 
        }  
          
    }
}
