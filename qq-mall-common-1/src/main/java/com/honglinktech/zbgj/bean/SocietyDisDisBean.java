package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;


/**
*回帖内容，根据帖子id，分表 注意分表
**/
public class SocietyDisDisBean implements Serializable{

	private Integer id=null;
	private Integer societyDisId=null;
	private Integer userId=null;
	private String nickName=null;
	private String content=null;
	private Integer imgIs=null;
	private Integer parent=null;
	private Integer goodNum=null;
	private Integer replyUserId=null;
	private String replyUserName=null;
	private Integer status=null;
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SocietyDisDisBean(){
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public static class SocietyDisDisRowMapper implements RowMapper<SocietyDisDisBean> {  
        @Override  
        public SocietyDisDisBean mapRow(ResultSet rs, int rowNum) throws SQLException {  

			SocietyDisDisBean tSocietyDisDis = new SocietyDisDisBean();
			tSocietyDisDis.setId(rs.getInt("id"));
			tSocietyDisDis.setSocietyDisId(rs.getInt("society_dis_id"));
			tSocietyDisDis.setUserId(rs.getInt("user_id"));
			tSocietyDisDis.setContent(rs.getString("content"));
			tSocietyDisDis.setImgIs(rs.getInt("img_is"));
			tSocietyDisDis.setParent(rs.getInt("parent"));
			tSocietyDisDis.setGoodNum(rs.getInt("good_num"));
			tSocietyDisDis.setReplyUserId(rs.getInt("reply_user_id"));
			tSocietyDisDis.setStatus(rs.getInt("status"));
			tSocietyDisDis.setCreateTime(rs.getTimestamp("create_time"));
			
			tSocietyDisDis.setNickName(rs.getString("nickName"));
			tSocietyDisDis.setReplyUserName(rs.getString("replyUserName"));
			return tSocietyDisDis; 
        }  
          
    }
}
