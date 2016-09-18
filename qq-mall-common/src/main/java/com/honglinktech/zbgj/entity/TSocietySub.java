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
*
**/
public class TSocietySub extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "name",length = 50,allowNull=true)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "image",length = 128,allowNull=true)
	private String image=null;
	@FieldMeta(primaryKey = false,fieldName = "简介",dbName = "synopsis",length = 225,allowNull=true)
	private String synopsis=null;
	@FieldMeta(primaryKey = false,fieldName = "类型",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "1正常",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "sort",length = 10,allowNull=true)
	private Integer sort=null;
	@FieldMeta(primaryKey = false,fieldName = "热门度，就是帖子数",dbName = "hot_num",length = 10,allowNull=true)
	private Integer hotNum=null;
	@FieldMeta(primaryKey = false,fieldName = "奖励类型，（0没有奖励，1奖励逗币，2奖励积分，3是逗币和积分）",dbName = "award_type",length = 10,allowNull=true)
	private Integer awardType=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "award_num",length = 10,allowNull=true)
	private Integer awardNum=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TSocietySub(){
 	}
 	public TSocietySub(Integer id,String name,String image,String synopsis,Integer type,Integer status,Integer sort,Integer hotNum,Integer awardType,Integer awardNum){
 		this.id = id;
		this.name = name;
		this.image = image;
		this.synopsis = synopsis;
		this.type = type;
		this.status = status;
		this.sort = sort;
		this.hotNum = hotNum;
		this.awardType = awardType;
		this.awardNum = awardNum;
		
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
		tableName("t_society_sub",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,true),
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
	public static class TSocietySubRowMapper implements RowMapper<TSocietySub> {  
        @Override  
        public TSocietySub mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSocietySub tSocietySub = new TSocietySub();
			tSocietySub.setId(rs.getInt("id"));
			tSocietySub.setName(rs.getString("name"));
			tSocietySub.setImage(rs.getString("image"));
			tSocietySub.setSynopsis(rs.getString("synopsis"));
			tSocietySub.setType(rs.getInt("type"));
			tSocietySub.setStatus(rs.getInt("status"));
			tSocietySub.setSort(rs.getInt("sort"));
			tSocietySub.setHotNum(rs.getInt("hot_num"));
			tSocietySub.setAwardType(rs.getInt("award_type"));
			tSocietySub.setAwardNum(rs.getInt("award_num"));
			tSocietySub.setCreateTime(rs.getTimestamp("create_time"));
			tSocietySub.setUpdateTime(rs.getTimestamp("update_time"));
			return tSocietySub; 
        }  
          
    }
}
