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
	@FieldMeta(primaryKey = false,fieldName = "类别名称",dbName = "name",length = 200,allowNull=false)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "类型图标",dbName = "ico",length = 100,allowNull=true)
	private String ico=null;
	@FieldMeta(primaryKey = false,fieldName = "类型图片",dbName = "img",length = 100,allowNull=true)
	private String img=null;
	@FieldMeta(primaryKey = false,fieldName = "是否首页l栏(0不是，1是)",dbName = "top_is",length = 10,allowNull=true)
	private Integer topIs=null;
	@FieldMeta(primaryKey = false,fieldName = "状态(1正常，2删除，3下架)",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
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
 	public TGType(Integer id,String name,String ico,String img,Integer topIs,Integer status){
 		this.id = id;
		this.name = name;
		this.ico = ico;
		this.img = img;
		this.topIs = topIs;
		this.status = status;
		
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
	/*是否首页l栏(0不是，1是)*/
	public Integer getTopIs(){
		 return this.topIs; 
	}
	public void setTopIs(Integer topIs){
		  this.topIs = topIs; 
	}
	/*状态(1正常，2删除，3下架)*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
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
		topIs("top_is",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
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
			tGType.setTopIs(rs.getInt("top_is"));
			tGType.setStatus(rs.getInt("status"));
			tGType.setUpdateTime(rs.getTimestamp("update_time"));
			tGType.setCreateTime(rs.getTimestamp("create_time"));
			return tGType; 
        }  
          
    }
}
