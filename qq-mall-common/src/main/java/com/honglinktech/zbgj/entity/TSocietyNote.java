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
*帖子
**/
public class TSocietyNote extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "社区主题id",dbName = "society_subject_id",length = 10,allowNull=false)
	private Integer societySubjectId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_name",length = 50,allowNull=true)
	private String userName=null;
	@FieldMeta(primaryKey = false,fieldName = "标题",dbName = "title",length = 50,allowNull=true)
	private String title=null;
	@FieldMeta(primaryKey = false,fieldName = "帖子详情",dbName = "detail",length = 500,allowNull=true)
	private String detail=null;
	@FieldMeta(primaryKey = false,fieldName = "发表地址",dbName = "address",length = 50,allowNull=true)
	private String address=null;
	@FieldMeta(primaryKey = false,fieldName = "查看数量",dbName = "look_num",length = 10,allowNull=true)
	private Integer lookNum=null;
	@FieldMeta(primaryKey = false,fieldName = "评论数量",dbName = "dis_num",length = 10,allowNull=true)
	private Integer disNum=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "top_is",length = 10,allowNull=true)
	private Integer topIs=null;
	@FieldMeta(primaryKey = false,fieldName = "是否推荐",dbName = "rec_is",length = 10,allowNull=true)
	private Integer recIs=null;
	@FieldMeta(primaryKey = false,fieldName = "是否是精品",dbName = "gifts_is",length = 10,allowNull=true)
	private Integer giftsIs=null;
	@FieldMeta(primaryKey = false,fieldName = "1是社区讨论帖子，2是体验贴",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "1是待审核，2是已经审核通过",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TSocietyNote(){
 	}
 	public TSocietyNote(Integer id,Integer societySubjectId,Integer userId,String userName,String title,String detail,String address,Integer lookNum,Integer disNum,Integer topIs,Integer recIs,Integer giftsIs,Integer type,Integer status){
 		this.id = id;
		this.societySubjectId = societySubjectId;
		this.userId = userId;
		this.userName = userName;
		this.title = title;
		this.detail = detail;
		this.address = address;
		this.lookNum = lookNum;
		this.disNum = disNum;
		this.topIs = topIs;
		this.recIs = recIs;
		this.giftsIs = giftsIs;
		this.type = type;
		this.status = status;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*社区主题id*/
	public Integer getSocietySubjectId(){
		 return this.societySubjectId; 
	}
	public void setSocietySubjectId(Integer societySubjectId){
		  this.societySubjectId = societySubjectId; 
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
	/*标题*/
	public String getTitle(){
		 return this.title; 
	}
	public void setTitle(String title){
		  this.title = title; 
	}
	/*帖子详情*/
	public String getDetail(){
		 return this.detail; 
	}
	public void setDetail(String detail){
		  this.detail = detail; 
	}
	/*发表地址*/
	public String getAddress(){
		 return this.address; 
	}
	public void setAddress(String address){
		  this.address = address; 
	}
	/*查看数量*/
	public Integer getLookNum(){
		 return this.lookNum; 
	}
	public void setLookNum(Integer lookNum){
		  this.lookNum = lookNum; 
	}
	/*评论数量*/
	public Integer getDisNum(){
		 return this.disNum; 
	}
	public void setDisNum(Integer disNum){
		  this.disNum = disNum; 
	}
	/**/
	public Integer getTopIs(){
		 return this.topIs; 
	}
	public void setTopIs(Integer topIs){
		  this.topIs = topIs; 
	}
	/*是否推荐*/
	public Integer getRecIs(){
		 return this.recIs; 
	}
	public void setRecIs(Integer recIs){
		  this.recIs = recIs; 
	}
	/*是否是精品*/
	public Integer getGiftsIs(){
		 return this.giftsIs; 
	}
	public void setGiftsIs(Integer giftsIs){
		  this.giftsIs = giftsIs; 
	}
	/*1是社区讨论帖子，2是体验贴*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*1是待审核，2是已经审核通过*/
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
		tableName("t_society_note",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		societySubjectId("society_subject_id",Types.INTEGER,false,false,false),
		userId("user_id",Types.INTEGER,false,false,false),
		userName("user_name",Types.VARCHAR,false,false,true),
		title("title",Types.VARCHAR,false,false,true),
		detail("detail",Types.VARCHAR,false,false,true),
		address("address",Types.VARCHAR,false,false,true),
		lookNum("look_num",Types.INTEGER,false,false,true),
		disNum("dis_num",Types.INTEGER,false,false,true),
		topIs("top_is",Types.INTEGER,false,false,true),
		recIs("rec_is",Types.INTEGER,false,false,true),
		giftsIs("gifts_is",Types.INTEGER,false,false,true),
		type("type",Types.INTEGER,false,false,true),
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
	public static class TSocietyNoteRowMapper implements RowMapper<TSocietyNote> {  
        @Override  
        public TSocietyNote mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSocietyNote tSocietyNote = new TSocietyNote();
			tSocietyNote.setId(rs.getInt("id"));
			tSocietyNote.setSocietySubjectId(rs.getInt("society_subject_id"));
			tSocietyNote.setUserId(rs.getInt("user_id"));
			tSocietyNote.setUserName(rs.getString("user_name"));
			tSocietyNote.setTitle(rs.getString("title"));
			tSocietyNote.setDetail(rs.getString("detail"));
			tSocietyNote.setAddress(rs.getString("address"));
			tSocietyNote.setLookNum(rs.getInt("look_num"));
			tSocietyNote.setDisNum(rs.getInt("dis_num"));
			tSocietyNote.setTopIs(rs.getInt("top_is"));
			tSocietyNote.setRecIs(rs.getInt("rec_is"));
			tSocietyNote.setGiftsIs(rs.getInt("gifts_is"));
			tSocietyNote.setType(rs.getInt("type"));
			tSocietyNote.setStatus(rs.getInt("status"));
			tSocietyNote.setCreateTime(rs.getTimestamp("create_time"));
			tSocietyNote.setUpdateTime(rs.getTimestamp("update_time"));
			return tSocietyNote; 
        }  
          
    }
}
