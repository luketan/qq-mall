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
*回帖内容，根据帖子id，分表 注意分表
**/
public class TSocietyDisDis extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "评论ID",dbName = "society_dis_id",length = 10,allowNull=true)
	private Integer societyDisId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_id",length = 10,allowNull=true)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_name",length = 50,allowNull=true)
	private String userName=null;
	@FieldMeta(primaryKey = false,fieldName = "回复内容",dbName = "content",length = 225,allowNull=true)
	private String content=null;
	@FieldMeta(primaryKey = false,fieldName = "是否有图片0没有，1有",dbName = "img_is",length = 10,allowNull=true)
	private Integer imgIs=null;
	@FieldMeta(primaryKey = false,fieldName = "跟帖的上级（0表示回复帖子）",dbName = "parent",length = 10,allowNull=true)
	private Integer parent=null;
	@FieldMeta(primaryKey = false,fieldName = "点赞数量",dbName = "good_num",length = 10,allowNull=true)
	private Integer goodNum=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "reply_user_id",length = 10,allowNull=true)
	private Integer replyUserId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "reply_user_name",length = 50,allowNull=true)
	private String replyUserName=null;
	@FieldMeta(primaryKey = false,fieldName = "0正常",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TSocietyDisDis(){
 	}
 	public TSocietyDisDis(Integer id,Integer societyDisId,Integer userId,String userName,String content,Integer imgIs,Integer parent,Integer goodNum,Integer replyUserId,String replyUserName,Integer status){
 		this.id = id;
		this.societyDisId = societyDisId;
		this.userId = userId;
		this.userName = userName;
		this.content = content;
		this.imgIs = imgIs;
		this.parent = parent;
		this.goodNum = goodNum;
		this.replyUserId = replyUserId;
		this.replyUserName = replyUserName;
		this.status = status;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*评论ID*/
	public Integer getSocietyDisId(){
		 return this.societyDisId; 
	}
	public void setSocietyDisId(Integer societyDisId){
		  this.societyDisId = societyDisId; 
	}
	/**/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/**/
	public String getUserName(){
		 return this.userName; 
	}
	public void setUserName(String userName){
		  this.userName = userName; 
	}
	/*回复内容*/
	public String getContent(){
		 return this.content; 
	}
	public void setContent(String content){
		  this.content = content; 
	}
	/*是否有图片0没有，1有*/
	public Integer getImgIs(){
		 return this.imgIs; 
	}
	public void setImgIs(Integer imgIs){
		  this.imgIs = imgIs; 
	}
	/*跟帖的上级（0表示回复帖子）*/
	public Integer getParent(){
		 return this.parent; 
	}
	public void setParent(Integer parent){
		  this.parent = parent; 
	}
	/*点赞数量*/
	public Integer getGoodNum(){
		 return this.goodNum; 
	}
	public void setGoodNum(Integer goodNum){
		  this.goodNum = goodNum; 
	}
	/**/
	public Integer getReplyUserId(){
		 return this.replyUserId; 
	}
	public void setReplyUserId(Integer replyUserId){
		  this.replyUserId = replyUserId; 
	}
	/**/
	public String getReplyUserName(){
		 return this.replyUserName; 
	}
	public void setReplyUserName(String replyUserName){
		  this.replyUserName = replyUserName; 
	}
	/*0正常*/
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

	
	public enum DBMaping{
		tableName("t_society_dis_dis",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		societyDisId("society_dis_id",Types.INTEGER,false,false,true),
		userId("user_id",Types.INTEGER,false,false,true),
		userName("user_name",Types.VARCHAR,false,false,true),
		content("content",Types.VARCHAR,false,false,true),
		imgIs("img_is",Types.INTEGER,false,false,true),
		parent("parent",Types.INTEGER,false,false,true),
		goodNum("good_num",Types.INTEGER,false,false,true),
		replyUserId("reply_user_id",Types.INTEGER,false,false,true),
		replyUserName("reply_user_name",Types.VARCHAR,false,false,true),
		status("status",Types.INTEGER,false,false,true),
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
	public static class TSocietyDisDisRowMapper implements RowMapper<TSocietyDisDis> {  
        @Override  
        public TSocietyDisDis mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSocietyDisDis tSocietyDisDis = new TSocietyDisDis();
			tSocietyDisDis.setId(rs.getInt("id"));
			tSocietyDisDis.setSocietyDisId(rs.getInt("society_dis_id"));
			tSocietyDisDis.setUserId(rs.getInt("user_id"));
			tSocietyDisDis.setUserName(rs.getString("user_name"));
			tSocietyDisDis.setContent(rs.getString("content"));
			tSocietyDisDis.setImgIs(rs.getInt("img_is"));
			tSocietyDisDis.setParent(rs.getInt("parent"));
			tSocietyDisDis.setGoodNum(rs.getInt("good_num"));
			tSocietyDisDis.setReplyUserId(rs.getInt("reply_user_id"));
			tSocietyDisDis.setReplyUserName(rs.getString("reply_user_name"));
			tSocietyDisDis.setStatus(rs.getInt("status"));
			tSocietyDisDis.setCreateTime(rs.getTimestamp("create_time"));
			return tSocietyDisDis; 
        }  
          
    }
}
