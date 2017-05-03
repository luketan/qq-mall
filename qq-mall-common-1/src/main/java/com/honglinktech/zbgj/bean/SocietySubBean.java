package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;


/**
*
**/
public class SocietySubBean extends BaseEntity implements Serializable{

	private Integer id=null;
	private String name=null;
	private String ico=null;
	private String icoColor=null;
	private String image=null;
	private String synopsis=null;
	private Integer type=null;
	private Integer status=null;
	private Integer sort=null;
	private Integer hotNum=null;
	private Integer awardType=null;
	private Integer awardNum=null;
	
	private Integer userId;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SocietySubBean(){
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/**/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*图标*/
	public String getIco(){
		 return this.ico; 
	}
	public void setIco(String ico){
		  this.ico = ico; 
	}
	/*图标颜色*/
	public String getIcoColor(){
		 return this.icoColor; 
	}
	public void setIcoColor(String icoColor){
		  this.icoColor = icoColor; 
	}
	/**/
	public String getImage(){
		 return this.image; 
	}
	public void setImage(String image){
		  this.image = image; 
	}
	/*简介*/
	public String getSynopsis(){
		 return this.synopsis; 
	}
	public void setSynopsis(String synopsis){
		  this.synopsis = synopsis; 
	}
	/*类型*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*1正常*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}
	/**/
	public Integer getSort(){
		 return this.sort; 
	}
	public void setSort(Integer sort){
		  this.sort = sort; 
	}
	/*热门度，就是帖子数*/
	public Integer getHotNum(){
		 return this.hotNum; 
	}
	public void setHotNum(Integer hotNum){
		  this.hotNum = hotNum; 
	}
	/*奖励类型，（0没有奖励，1奖励逗币，2奖励积分，3是逗币和积分）*/
	public Integer getAwardType(){
		 return this.awardType; 
	}
	public void setAwardType(Integer awardType){
		  this.awardType = awardType; 
	}
	/**/
	public Integer getAwardNum(){
		 return this.awardNum; 
	}
	public void setAwardNum(Integer awardNum){
		  this.awardNum = awardNum; 
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public enum DBMaping{
		tableName("t_society_sub",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,true),
		ico("ico",Types.VARCHAR,false,false,true),
		icoColor("ico_color",Types.VARCHAR,false,false,true),
		image("image",Types.VARCHAR,false,false,true),
		synopsis("synopsis",Types.VARCHAR,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		sort("sort",Types.INTEGER,false,false,true),
		hotNum("hot_num",Types.INTEGER,false,false,true),
		awardType("award_type",Types.INTEGER,false,false,true),
		awardNum("award_num",Types.INTEGER,false,false,true),
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
	public static class SocietySubRowMapper implements RowMapper<SocietySubBean> {  
        @Override  
        public SocietySubBean mapRow(ResultSet rs, int rowNum) throws SQLException {  

			SocietySubBean tSocietySub = new SocietySubBean();
			tSocietySub.setId(rs.getInt("id"));
			tSocietySub.setName(rs.getString("name"));
			tSocietySub.setIco(rs.getString("ico"));
			tSocietySub.setIcoColor(rs.getString("ico_color"));
			tSocietySub.setImage(rs.getString("image"));
			tSocietySub.setSynopsis(rs.getString("synopsis"));
			tSocietySub.setType(rs.getInt("type"));
			tSocietySub.setStatus(rs.getInt("status"));
			tSocietySub.setSort(rs.getInt("sort"));
			tSocietySub.setHotNum(rs.getInt("hot_num"));
			tSocietySub.setAwardType(rs.getInt("award_type"));
			tSocietySub.setAwardNum(rs.getInt("award_num"));
			return tSocietySub; 
        }  
          
    }
	
	public static class SocietySubUserRowMapper implements RowMapper<SocietySubBean> {  
        @Override  
        public SocietySubBean mapRow(ResultSet rs, int rowNum) throws SQLException {  

			SocietySubBean tSocietySub = new SocietySubBean();
			tSocietySub.setId(rs.getInt("id"));
			tSocietySub.setName(rs.getString("name"));
			tSocietySub.setIco(rs.getString("ico"));
			tSocietySub.setIcoColor(rs.getString("ico_color"));
			tSocietySub.setImage(rs.getString("image"));
			tSocietySub.setSynopsis(rs.getString("synopsis"));
			tSocietySub.setType(rs.getInt("type"));
			tSocietySub.setStatus(rs.getInt("status"));
			tSocietySub.setSort(rs.getInt("sort"));
			tSocietySub.setHotNum(rs.getInt("hot_num"));
			tSocietySub.setAwardType(rs.getInt("award_type"));
			tSocietySub.setAwardNum(rs.getInt("award_num"));
			tSocietySub.setUserId(rs.getInt("user_id"));
			return tSocietySub; 
        }  
    }
}
