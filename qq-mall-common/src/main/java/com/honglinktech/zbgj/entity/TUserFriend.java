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
*用户的朋友
**/
public class TUserFriend extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "用户ID",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = true,fieldName = "好友ID",dbName = "friend_user_id",length = 10,allowNull=false)
	private Integer friendUserId=null;
	@FieldMeta(primaryKey = false,fieldName = "类型（1：好友申请，2：好友，3陌生人）",dbName = "type",length = 10,allowNull=false)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "好友名字",dbName = "friend_user_name",length = 50,allowNull=true)
	private String friendUserName=null;
	@FieldMeta(primaryKey = false,fieldName = "好友经理头像",dbName = "friend_user_head",length = 300,allowNull=true)
	private String friendUserHead=null;
	@FieldMeta(primaryKey = false,fieldName = "好友等级",dbName = "friend_user_level",length = 10,allowNull=true)
	private Integer friendUserLevel=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "friend_money",length = 10,allowNull=true)
	private Integer friendMoney=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserFriend(){
 	}
 	public TUserFriend(Integer userId,Integer friendUserId,Integer type,String friendUserName,String friendUserHead,Integer friendUserLevel,Integer friendMoney){
 		this.userId = userId;
		this.friendUserId = friendUserId;
		this.type = type;
		this.friendUserName = friendUserName;
		this.friendUserHead = friendUserHead;
		this.friendUserLevel = friendUserLevel;
		this.friendMoney = friendMoney;
		
 	}
 	
		/*用户ID*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*好友ID*/
	public Integer getFriendUserId(){
		 return this.friendUserId; 
	}
	public void setFriendUserId(Integer friendUserId){
		  this.friendUserId = friendUserId; 
	}
	/*类型（1：好友申请，2：好友，3陌生人）*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*好友名字*/
	public String getFriendUserName(){
		 return this.friendUserName; 
	}
	public void setFriendUserName(String friendUserName){
		  this.friendUserName = friendUserName; 
	}
	/*好友经理头像*/
	public String getFriendUserHead(){
		 return this.friendUserHead; 
	}
	public void setFriendUserHead(String friendUserHead){
		  this.friendUserHead = friendUserHead; 
	}
	/*好友等级*/
	public Integer getFriendUserLevel(){
		 return this.friendUserLevel; 
	}
	public void setFriendUserLevel(Integer friendUserLevel){
		  this.friendUserLevel = friendUserLevel; 
	}
	/**/
	public Integer getFriendMoney(){
		 return this.friendMoney; 
	}
	public void setFriendMoney(Integer friendMoney){
		  this.friendMoney = friendMoney; 
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
		tableName("t_user_friend",0,false,false,false),
		friendUserName("friend_user_name",Types.VARCHAR,false,false,true),
		friendUserHead("friend_user_head",Types.VARCHAR,false,false,true),
		friendMoney("friend_money",Types.INTEGER,false,false,true),
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
	public static class TUserFriendRowMapper implements RowMapper<TUserFriend> {  
        @Override  
        public TUserFriend mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserFriend tUserFriend = new TUserFriend();
			tUserFriend.setFriendUserName(rs.getString("friend_user_name"));
			tUserFriend.setFriendUserHead(rs.getString("friend_user_head"));
			tUserFriend.setFriendMoney(rs.getInt("friend_money"));
			tUserFriend.setUpdateTime(rs.getTimestamp("update_time"));
			tUserFriend.setCreateTime(rs.getTimestamp("create_time"));
			return tUserFriend; 
        }  
          
    }
}
