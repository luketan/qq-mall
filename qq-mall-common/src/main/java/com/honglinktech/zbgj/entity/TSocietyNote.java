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
	@FieldMeta(primaryKey = false,fieldName = "社区主题id",dbName = "society_sub_id",length = 10,allowNull=true)
	private Integer societySubId=null;
	@FieldMeta(primaryKey = false,fieldName = "帖子类型名称",dbName = "society_sub_name",length = 32,allowNull=true)
	private String societySubName=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "用户昵称",dbName = "nick_name",length = 50,allowNull=true)
	private String nickName=null;
	@FieldMeta(primaryKey = false,fieldName = "标题",dbName = "title",length = 50,allowNull=true)
	private String title=null;
	@FieldMeta(primaryKey = false,fieldName = "帖子详情",dbName = "detail",length = 500,allowNull=true)
	private String detail=null;
	@FieldMeta(primaryKey = false,fieldName = "发表地址",dbName = "address",length = 50,allowNull=true)
	private String address=null;
	@FieldMeta(primaryKey = false,fieldName = "发表的ip地址",dbName = "ip",length = 32,allowNull=true)
	private String ip=null;
	@FieldMeta(primaryKey = false,fieldName = "点赞数量",dbName = "good_num",length = 10,allowNull=true)
	private Integer goodNum=null;
	@FieldMeta(primaryKey = false,fieldName = "评论数量",dbName = "dis_num",length = 10,allowNull=true)
	private Integer disNum=null;
	@FieldMeta(primaryKey = false,fieldName = "是否置顶",dbName = "top_is",length = 10,allowNull=true)
	private Integer topIs=null;
	@FieldMeta(primaryKey = false,fieldName = "是否推荐",dbName = "rec_is",length = 10,allowNull=true)
	private Integer recIs=null;
	@FieldMeta(primaryKey = false,fieldName = "是否是精品",dbName = "gifts_is",length = 10,allowNull=true)
	private Integer giftsIs=null;
	@FieldMeta(primaryKey = false,fieldName = "是否有图片(0没有)",dbName = "img_is",length = 10,allowNull=true)
	private Integer imgIs=null;
	@FieldMeta(primaryKey = false,fieldName = "是否打赏",dbName = "reward_is",length = 10,allowNull=true)
	private Integer rewardIs=null;
	@FieldMeta(primaryKey = false,fieldName = "0社区公告，1是社区讨论帖子，2是体验贴，",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "是否匿名发帖",dbName = "ano_is",length = 10,allowNull=true)
	private Integer anoIs=null;
	@FieldMeta(primaryKey = false,fieldName = "是否是公告(0不是，1是)",dbName = "ann_is",length = 10,allowNull=true)
	private Integer annIs=null;
	@FieldMeta(primaryKey = false,fieldName = "1是待审核，2是已经审核通过",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "帖子标签",dbName = "tags",length = 225,allowNull=true)
	private String tags=null;
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
 	public TSocietyNote(Integer id,Integer societySubId,String societySubName,Integer userId,String nickName,String title,String detail,String address,String ip,Integer goodNum,Integer disNum,Integer topIs,Integer recIs,Integer giftsIs,Integer imgIs,Integer rewardIs,Integer type,Integer anoIs,Integer annIs,Integer status,String tags){
 		this.id = id;
		this.societySubId = societySubId;
		this.societySubName = societySubName;
		this.userId = userId;
		this.nickName = nickName;
		this.title = title;
		this.detail = detail;
		this.address = address;
		this.ip = ip;
		this.goodNum = goodNum;
		this.disNum = disNum;
		this.topIs = topIs;
		this.recIs = recIs;
		this.giftsIs = giftsIs;
		this.imgIs = imgIs;
		this.rewardIs = rewardIs;
		this.type = type;
		this.anoIs = anoIs;
		this.annIs = annIs;
		this.status = status;
		this.tags = tags;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*社区主题id*/
	public Integer getSocietySubId(){
		 return this.societySubId; 
	}
	public void setSocietySubId(Integer societySubId){
		  this.societySubId = societySubId; 
	}
	/*帖子类型名称*/
	public String getSocietySubName(){
		 return this.societySubName; 
	}
	public void setSocietySubName(String societySubName){
		  this.societySubName = societySubName; 
	}
	/**/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*用户昵称*/
	public String getNickName(){
		 return this.nickName; 
	}
	public void setNickName(String nickName){
		  this.nickName = nickName; 
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
	/*发表的ip地址*/
	public String getIp(){
		 return this.ip; 
	}
	public void setIp(String ip){
		  this.ip = ip; 
	}
	/*点赞数量*/
	public Integer getGoodNum(){
		 return this.goodNum; 
	}
	public void setGoodNum(Integer goodNum){
		  this.goodNum = goodNum; 
	}
	/*评论数量*/
	public Integer getDisNum(){
		 return this.disNum; 
	}
	public void setDisNum(Integer disNum){
		  this.disNum = disNum; 
	}
	/*是否置顶*/
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
	/*是否有图片(0没有)*/
	public Integer getImgIs(){
		 return this.imgIs; 
	}
	public void setImgIs(Integer imgIs){
		  this.imgIs = imgIs; 
	}
	/*是否打赏*/
	public Integer getRewardIs(){
		 return this.rewardIs; 
	}
	public void setRewardIs(Integer rewardIs){
		  this.rewardIs = rewardIs; 
	}
	/*0社区公告，1是社区讨论帖子，2是体验贴，*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*是否匿名发帖*/
	public Integer getAnoIs(){
		 return this.anoIs; 
	}
	public void setAnoIs(Integer anoIs){
		  this.anoIs = anoIs; 
	}
	/*是否是公告(0不是，1是)*/
	public Integer getAnnIs(){
		 return this.annIs; 
	}
	public void setAnnIs(Integer annIs){
		  this.annIs = annIs; 
	}
	/*1是待审核，2是已经审核通过*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}
	/*帖子标签*/
	public String getTags(){
		 return this.tags; 
	}
	public void setTags(String tags){
		  this.tags = tags; 
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
		societySubId("society_sub_id",Types.INTEGER,false,false,true),
		societySubName("society_sub_name",Types.VARCHAR,false,false,true),
		userId("user_id",Types.INTEGER,false,false,false),
		nickName("nick_name",Types.VARCHAR,false,false,true),
		title("title",Types.VARCHAR,false,false,true),
		detail("detail",Types.VARCHAR,false,false,true),
		address("address",Types.VARCHAR,false,false,true),
		ip("ip",Types.VARCHAR,false,false,true),
		goodNum("good_num",Types.INTEGER,false,false,true),
		disNum("dis_num",Types.INTEGER,false,false,true),
		topIs("top_is",Types.INTEGER,false,false,true),
		recIs("rec_is",Types.INTEGER,false,false,true),
		giftsIs("gifts_is",Types.INTEGER,false,false,true),
		imgIs("img_is",Types.INTEGER,false,false,true),
		rewardIs("reward_is",Types.INTEGER,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		anoIs("ano_is",Types.INTEGER,false,false,true),
		annIs("ann_is",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		tags("tags",Types.VARCHAR,false,false,true),
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
			tSocietyNote.setSocietySubId(rs.getInt("society_sub_id"));
			tSocietyNote.setSocietySubName(rs.getString("society_sub_name"));
			tSocietyNote.setUserId(rs.getInt("user_id"));
			tSocietyNote.setNickName(rs.getString("nick_name"));
			tSocietyNote.setTitle(rs.getString("title"));
			tSocietyNote.setDetail(rs.getString("detail"));
			tSocietyNote.setAddress(rs.getString("address"));
			tSocietyNote.setIp(rs.getString("ip"));
			tSocietyNote.setGoodNum(rs.getInt("good_num"));
			tSocietyNote.setDisNum(rs.getInt("dis_num"));
			tSocietyNote.setTopIs(rs.getInt("top_is"));
			tSocietyNote.setRecIs(rs.getInt("rec_is"));
			tSocietyNote.setGiftsIs(rs.getInt("gifts_is"));
			tSocietyNote.setImgIs(rs.getInt("img_is"));
			tSocietyNote.setRewardIs(rs.getInt("reward_is"));
			tSocietyNote.setType(rs.getInt("type"));
			tSocietyNote.setAnoIs(rs.getInt("ano_is"));
			tSocietyNote.setAnnIs(rs.getInt("ann_is"));
			tSocietyNote.setStatus(rs.getInt("status"));
			tSocietyNote.setTags(rs.getString("tags"));
			tSocietyNote.setCreateTime(rs.getTimestamp("create_time"));
			tSocietyNote.setUpdateTime(rs.getTimestamp("update_time"));
			return tSocietyNote; 
        }  
          
    }
}
