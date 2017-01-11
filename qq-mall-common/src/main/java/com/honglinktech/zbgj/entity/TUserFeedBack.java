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
*用户反馈和意见
**/
public class TUserFeedBack extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "parent_id",length = 10,allowNull=false)
	private Integer parentId=null;
	@FieldMeta(primaryKey = false,fieldName = "用户id",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "rec_name",length = 20,allowNull=true)
	private String recName=null;
	@FieldMeta(primaryKey = false,fieldName = "奖励类型（1逗币）",dbName = "content",length = 10,allowNull=true)
	private Integer content=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserFeedBack(){
 	}
 	public TUserFeedBack(Integer id,Integer parentId,Integer userId,String recName,Integer content){
 		this.id = id;
		this.parentId = parentId;
		this.userId = userId;
		this.recName = recName;
		this.content = content;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/**/
	public Integer getParentId(){
		 return this.parentId; 
	}
	public void setParentId(Integer parentId){
		  this.parentId = parentId; 
	}
	/*用户id*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/**/
	public String getRecName(){
		 return this.recName; 
	}
	public void setRecName(String recName){
		  this.recName = recName; 
	}
	/*奖励类型（1逗币）*/
	public Integer getContent(){
		 return this.content; 
	}
	public void setContent(Integer content){
		  this.content = content; 
	}
	/**/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

	
	public enum DBMaping{
		tableName("t_user_feed_back",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		parentId("parent_id",Types.INTEGER,false,false,false),
		userId("user_id",Types.INTEGER,false,false,false),
		recName("rec_name",Types.VARCHAR,false,false,true),
		content("content",Types.INTEGER,false,false,true),
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
	public static class TUserFeedBackRowMapper implements RowMapper<TUserFeedBack> {  
        @Override  
        public TUserFeedBack mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserFeedBack tUserFeedBack = new TUserFeedBack();
			tUserFeedBack.setId(rs.getInt("id"));
			tUserFeedBack.setParentId(rs.getInt("parent_id"));
			tUserFeedBack.setUserId(rs.getInt("user_id"));
			tUserFeedBack.setRecName(rs.getString("rec_name"));
			tUserFeedBack.setContent(rs.getInt("content"));
			tUserFeedBack.setCreateTime(rs.getTimestamp("create_time"));
			return tUserFeedBack; 
        }  
          
    }
}
