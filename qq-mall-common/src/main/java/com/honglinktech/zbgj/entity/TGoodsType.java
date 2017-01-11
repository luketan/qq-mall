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
public class TGoodsType extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "类别名称",dbName = "name",length = 64,allowNull=false)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "类型图标",dbName = "ico",length = 32,allowNull=true)
	private String ico=null;
	@FieldMeta(primaryKey = false,fieldName = "类型图片",dbName = "img",length = 128,allowNull=true)
	private String img=null;
	@FieldMeta(primaryKey = false,fieldName = "排序",dbName = "sort",length = 10,allowNull=true)
	private Integer sort=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "summary",length = 128,allowNull=true)
	private String summary=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "search",length = 225,allowNull=true)
	private String search=null;
	@FieldMeta(primaryKey = false,fieldName = "状态(0正常，1删除)",dbName = "delete_flag",length = 10,allowNull=true)
	private Integer deleteFlag=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TGoodsType(){
 	}
 	public TGoodsType(Integer id,String name,String ico,String img,Integer sort,String summary,String search,Integer deleteFlag){
 		this.id = id;
		this.name = name;
		this.ico = ico;
		this.img = img;
		this.sort = sort;
		this.summary = summary;
		this.search = search;
		this.deleteFlag = deleteFlag;
		
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
	/**/
	public String getSearch(){
		 return this.search; 
	}
	public void setSearch(String search){
		  this.search = search; 
	}
	/*状态(0正常，1删除)*/
	public Integer getDeleteFlag(){
		 return this.deleteFlag; 
	}
	public void setDeleteFlag(Integer deleteFlag){
		  this.deleteFlag = deleteFlag; 
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
		tableName("t_goods_type",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,false),
		ico("ico",Types.VARCHAR,false,false,true),
		img("img",Types.VARCHAR,false,false,true),
		sort("sort",Types.INTEGER,false,false,true),
		summary("summary",Types.VARCHAR,false,false,true),
		search("search",Types.VARCHAR,false,false,true),
		deleteFlag("delete_flag",Types.INTEGER,false,false,true),
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
	public static class TGoodsTypeRowMapper implements RowMapper<TGoodsType> {  
        @Override  
        public TGoodsType mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TGoodsType tGoodsType = new TGoodsType();
			tGoodsType.setId(rs.getInt("id"));
			tGoodsType.setName(rs.getString("name"));
			tGoodsType.setIco(rs.getString("ico"));
			tGoodsType.setImg(rs.getString("img"));
			tGoodsType.setSort(rs.getInt("sort"));
			tGoodsType.setSummary(rs.getString("summary"));
			tGoodsType.setSearch(rs.getString("search"));
			tGoodsType.setDeleteFlag(rs.getInt("delete_flag"));
			tGoodsType.setUpdateTime(rs.getTimestamp("update_time"));
			tGoodsType.setCreateTime(rs.getTimestamp("create_time"));
			return tGoodsType; 
        }  
          
    }
}
