package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;


/**
*帖子
**/
public class SocietyNoteBean implements Serializable{

	private Integer id=null;
	private String title=null;
	private String detail=null;
	private String address=null;
	private String ip=null;
	private Integer goodNum=null;
	private Integer disNum=null;
	private Integer topIs=null;
	private Integer recIs=null;
	private Integer giftsIs=null;
	private Integer imgIs=null;
	private Integer type=null;
	private Integer anoIs=null;
	private Integer annIs=null;
	private Integer status=null;
	private String tags=null;
	private Date createTime=null;
	private Date updateTime=null;
	
	private Integer societySubId=null;
	private String societySubName=null;
	private String socSubIco;
	private String socSubIcoColor;
	
	
	private Integer userId=null;
	private String nickName=null;
	private int sex;
	private int level;
	private String head;
	
	private int likeUserId;//是否点赞
	
	private List<PicBean> picBeans;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SocietyNoteBean(){
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
	/*查看数量*/
	public Integer getGoodNum() {
		return goodNum;
	}
	public void setGoodNum(Integer goodNum) {
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public List<PicBean> getPicBeans() {
		return picBeans;
	}
	public void setPicBeans(List<PicBean> picBeans) {
		this.picBeans = picBeans;
	}
	
	public int getLikeUserId() {
		return likeUserId;
	}

	public void setLikeUserId(int likeUserId) {
		this.likeUserId = likeUserId;
	}

	public Integer getImgIs() {
		return imgIs;
	}

	public void setImgIs(Integer imgIs) {
		this.imgIs = imgIs;
	}

	public Integer getAnnIs() {
		return annIs;
	}

	public void setAnnIs(Integer annIs) {
		this.annIs = annIs;
	}
	
	public String getSocSubIco() {
		return socSubIco;
	}

	public void setSocSubIco(String socSubIco) {
		this.socSubIco = socSubIco;
	}

	public String getSocSubIcoColor() {
		return socSubIcoColor;
	}

	public void setSocSubIcoColor(String socSubIcoColor) {
		this.socSubIcoColor = socSubIcoColor;
	}

	public static class SocietyNoteRowMapper implements RowMapper<SocietyNoteBean> {  
        @Override  
        public SocietyNoteBean mapRow(ResultSet rs, int rowNum) throws SQLException {  

			SocietyNoteBean societyNote = new SocietyNoteBean();
			societyNote.setId(rs.getInt("id"));
			societyNote.setSocietySubId(rs.getInt("society_sub_id"));
			societyNote.setSocietySubName(rs.getString("society_sub_name"));
			societyNote.setTitle(rs.getString("title"));
			societyNote.setDetail(rs.getString("detail"));
			societyNote.setAddress(rs.getString("address"));
			societyNote.setIp(rs.getString("ip"));
			societyNote.setGoodNum(rs.getInt("good_num"));
			societyNote.setDisNum(rs.getInt("dis_num"));
			societyNote.setTopIs(rs.getInt("top_is"));
			societyNote.setRecIs(rs.getInt("rec_is"));
			societyNote.setGiftsIs(rs.getInt("gifts_is"));
			societyNote.setImgIs(rs.getInt("img_is"));
			societyNote.setType(rs.getInt("type"));
			societyNote.setAnoIs(rs.getInt("ano_is"));
			societyNote.setAnnIs(rs.getInt("ann_is"));
			societyNote.setStatus(rs.getInt("status"));
			societyNote.setTags(rs.getString("tags"));
			societyNote.setCreateTime(rs.getTimestamp("create_time"));
			societyNote.setUpdateTime(rs.getTimestamp("update_time"));
			
			societyNote.setNickName(rs.getString("nick_name"));
			societyNote.setSex(rs.getInt("sex"));
			societyNote.setLevel(rs.getInt("level"));
			societyNote.setHead(rs.getString("head"));
			
			return societyNote; 
        }  
          
    }
	
	public static class SocietyNoteInfoRowMapper implements RowMapper<SocietyNoteBean> {  
        @Override  
        public SocietyNoteBean mapRow(ResultSet rs, int rowNum) throws SQLException {  

			SocietyNoteBean societyNote = new SocietyNoteBean();
			societyNote.setId(rs.getInt("id"));
			societyNote.setTitle(rs.getString("title"));
			societyNote.setDetail(rs.getString("detail"));
			societyNote.setAddress(rs.getString("address"));
			societyNote.setIp(rs.getString("ip"));
			societyNote.setGoodNum(rs.getInt("good_num"));
			societyNote.setDisNum(rs.getInt("dis_num"));
			societyNote.setTopIs(rs.getInt("top_is"));
			societyNote.setRecIs(rs.getInt("rec_is"));
			societyNote.setGiftsIs(rs.getInt("gifts_is"));
			societyNote.setImgIs(rs.getInt("img_is"));
			societyNote.setType(rs.getInt("type"));
			societyNote.setAnoIs(rs.getInt("ano_is"));
			societyNote.setAnnIs(rs.getInt("ann_is"));
			societyNote.setStatus(rs.getInt("status"));
			societyNote.setTags(rs.getString("tags"));
			societyNote.setCreateTime(rs.getTimestamp("create_time"));
			societyNote.setUpdateTime(rs.getTimestamp("update_time"));
			
			societyNote.setSocietySubId(rs.getInt("society_sub_id"));
			societyNote.setSocietySubName(rs.getString("socSubName"));
			societyNote.setSocSubIco(rs.getString("socSubIco"));
			societyNote.setSocSubIcoColor(rs.getString("socSubIcoColor"));
			
			societyNote.setNickName(rs.getString("nick_name"));
			societyNote.setSex(rs.getInt("sex"));
			societyNote.setLevel(rs.getInt("level"));
			societyNote.setHead(rs.getString("head"));
			
			societyNote.setLikeUserId(rs.getInt("likeUserId"));
			
			return societyNote; 
        }  
          
    }
}
