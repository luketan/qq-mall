package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.entity.TSocietyDis;


/**
*回帖内容，根据帖子id，分表 注意分表
**/
public class SocietyDisBean implements Serializable{

	private Integer id=null;
	private Integer societyNoteId=null;
	private Integer userId=null;
	private String content=null;
	private Integer imgIs=null;
	private Integer replyIs=null;
	private Integer goodNum=null;
	private Integer parent=null;
	private Integer status=null;
	private Date createTime=null;
	
	private String nickName=null;
	private String head;
	private int level;
	
	private int likeUserId;
	
	private List<SocietyDisDisBean> societyDisDisBeans;
	private List<PicBean> picBeans;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SocietyDisBean(){
 	}
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/**/
	public Integer getSocietyNoteId(){
		 return this.societyNoteId; 
	}
	public void setSocietyNoteId(Integer societyNoteId){
		  this.societyNoteId = societyNoteId; 
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
	/*是否有回复,0没有，1有*/
	public Integer getReplyIs(){
		 return this.replyIs; 
	}
	public void setReplyIs(Integer replyIs){
		  this.replyIs = replyIs; 
	}
	/*点赞数量*/
	public Integer getGoodNum(){
		 return this.goodNum; 
	}
	public void setGoodNum(Integer goodNum){
		  this.goodNum = goodNum; 
	}
	/*跟帖的上级（0表示回复帖子）*/
	public Integer getParent(){
		 return this.parent; 
	}
	public void setParent(Integer parent){
		  this.parent = parent; 
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
	public List<SocietyDisDisBean> getSocietyDisDisBeans() {
		return societyDisDisBeans;
	}
	public void setSocietyDisDisBeans(List<SocietyDisDisBean> societyDisDisBeans) {
		this.societyDisDisBeans = societyDisDisBeans;
	}
	public int getLikeUserId() {
		return likeUserId;
	}
	public void setLikeUserId(int likeUserId) {
		this.likeUserId = likeUserId;
	}
	public List<PicBean> getPicBeans() {
		return picBeans;
	}
	public void setPicBeans(List<PicBean> picBeans) {
		this.picBeans = picBeans;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public Object[] getDBMapping(String filedName){
		for(TSocietyDis.DBMaping d:TSocietyDis.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TSocietyDis.DBMaping dbMaping = TSocietyDis.DBMaping.valueOf(filedName);
				Object[] values = {dbMaping.getDbName(),dbMaping.getDbType(),dbMaping.getPrimaryKey(),dbMaping.isAotuIn(),dbMaping.isAllowNull()};
				return values;
			}
		}
		return null;
	}
	
	public static class SocietyDisBeanRowMapper implements RowMapper<SocietyDisBean> {  
        @Override  
        public SocietyDisBean mapRow(ResultSet rs, int rowNum) throws SQLException {  

			SocietyDisBean tSocietyDis = new SocietyDisBean();
			tSocietyDis.setId(rs.getInt("id"));
			tSocietyDis.setSocietyNoteId(rs.getInt("society_note_id"));
			tSocietyDis.setUserId(rs.getInt("user_id"));
			tSocietyDis.setNickName(rs.getString("nickName"));
			tSocietyDis.setContent(rs.getString("content"));
			tSocietyDis.setImgIs(rs.getInt("img_is"));
			tSocietyDis.setReplyIs(rs.getInt("reply_is"));
			tSocietyDis.setGoodNum(rs.getInt("good_num"));
			tSocietyDis.setParent(rs.getInt("parent"));
			tSocietyDis.setStatus(rs.getInt("status"));
			tSocietyDis.setCreateTime(rs.getTimestamp("create_time"));
			
			tSocietyDis.setLikeUserId(rs.getInt("likeUserId"));
			tSocietyDis.setHead(rs.getString("head"));
			tSocietyDis.setLevel(rs.getInt("level"));
			
			return tSocietyDis; 
        }  
          
    }
}
