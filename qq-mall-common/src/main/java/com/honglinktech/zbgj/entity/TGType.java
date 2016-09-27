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
*商品类别表
**/
public class TGType extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "类别名称",dbName = "name",length = 64,allowNull=false)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "类型图标",dbName = "ico",length = 128,allowNull=true)
	private String ico=null;
	@FieldMeta(primaryKey = false,fieldName = "类型图片",dbName = "img",length = 128,allowNull=true)
	private String img=null;
	@FieldMeta(primaryKey = false,fieldName = "排序",dbName = "sort",length = 10,allowNull=true)
	private Integer sort=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "summary",length = 128,allowNull=true)
	private String summary=null;
	@FieldMeta(primaryKey = false,fieldName = "状态(0正常，1删除)",dbName = "delete_tag",length = 10,allowNull=true)
	private Integer deleteTag=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TGType(){
 	}
 	public TGType(Integer id,String name,String ico,String img,Integer sort,String summary,Integer deleteTag){
 		this.id = id;
		this.name = name;
		this.ico = ico;
		this.img = img;
		this.sort = sort;
		this.summary = summary;
		this.deleteTag = deleteTag;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*类别名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*类型图标*/
	public String getIco(){
		 return this.ico; 
	}
	public void setIco(String ico){
		  this.ico = ico; 
	}
	/*类型图片*/
	public String getImg(){
		 return this.img; 
	}
	public void setImg(String img){
		  this.img = img; 
	}
	/*排序*/
	public Integer getSort(){
		 return this.sort; 
	}
	public void setSort(Integer sort){
		  this.sort = sort; 
	}
	/**/
	public String getSummary(){
		 return this.summary; 
	}
	public void setSummary(String summary){
		  this.summary = summary; 
	}
	/*状态(0正常，1删除)*/
	public Integer getDeleteTag(){
		 return this.deleteTag; 
	}
	public void setDeleteTag(Integer deleteTag){
		  this.deleteTag = deleteTag; 
	}
	/**/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}
	/**/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}

	
	public enum DBMaping{
		tableName("t_g_type",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,false),
		ico("ico",Types.VARCHAR,false,false,true),
		img("img",Types.VARCHAR,false,false,true),
		sort("sort",Types.INTEGER,false,false,true),
		summary("summary",Types.VARCHAR,false,false,true),
		deleteTag("delete_tag",Types.INTEGER,false,false,true),
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
	public static class TGTypeRowMapper implements RowMapper<TGType> {  
        @Override  
        public TGType mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TGType tGType = new TGType();
			tGType.setId(rs.getInt("id"));
			tGType.setName(rs.getString("name"));
			tGType.setIco(rs.getString("ico"));
			tGType.setImg(rs.getString("img"));
			tGType.setSort(rs.getInt("sort"));
			tGType.setSummary(rs.getString("summary"));
			tGType.setDeleteTag(rs.getInt("delete_tag"));
			tGType.setUpdateTime(rs.getTimestamp("update_time"));
			tGType.setCreateTime(rs.getTimestamp("create_time"));
			return tGType; 
        }  
          
    }
}
