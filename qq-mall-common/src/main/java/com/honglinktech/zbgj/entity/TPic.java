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
*商品图片
**/
public class TPic extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "商品类型",dbName = "obj_id",length = 10,allowNull=true)
	private Integer objId=null;
	@FieldMeta(primaryKey = false,fieldName = "图片类型(1是商品图，2是商品评论图片,3是论坛评论图片,4意见反馈图)",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "地址类型(1.完整，2.系统路径)",dbName = "url_type",length = 10,allowNull=true)
	private Integer urlType=null;
	@FieldMeta(primaryKey = false,fieldName = "图片标题",dbName = "pic_title",length = 50,allowNull=true)
	private String picTitle=null;
	@FieldMeta(primaryKey = false,fieldName = "图片地址",dbName = "pic_url",length = 225,allowNull=true)
	private String picUrl=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TPic(){
 	}
 	public TPic(Integer id,Integer objId,Integer type,Integer urlType,String picTitle,String picUrl){
 		this.id = id;
		this.objId = objId;
		this.type = type;
		this.urlType = urlType;
		this.picTitle = picTitle;
		this.picUrl = picUrl;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*商品类型*/
	public Integer getObjId(){
		 return this.objId; 
	}
	public void setObjId(Integer objId){
		  this.objId = objId; 
	}
	/*图片类型(1是商品图，2是商品评论图片,3是论坛评论图片,4意见反馈图)*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*地址类型(1.完整，2.系统路径)*/
	public Integer getUrlType(){
		 return this.urlType; 
	}
	public void setUrlType(Integer urlType){
		  this.urlType = urlType; 
	}
	/*图片标题*/
	public String getPicTitle(){
		 return this.picTitle; 
	}
	public void setPicTitle(String picTitle){
		  this.picTitle = picTitle; 
	}
	/*图片地址*/
	public String getPicUrl(){
		 return this.picUrl; 
	}
	public void setPicUrl(String picUrl){
		  this.picUrl = picUrl; 
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
		tableName("t_pic",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		objId("obj_id",Types.INTEGER,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		urlType("url_type",Types.INTEGER,false,false,true),
		picTitle("pic_title",Types.VARCHAR,false,false,true),
		picUrl("pic_url",Types.VARCHAR,false,false,true),
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
	public static class TPicRowMapper implements RowMapper<TPic> {  
        @Override  
        public TPic mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TPic tPic = new TPic();
			tPic.setId(rs.getInt("id"));
			tPic.setObjId(rs.getInt("obj_id"));
			tPic.setType(rs.getInt("type"));
			tPic.setUrlType(rs.getInt("url_type"));
			tPic.setPicTitle(rs.getString("pic_title"));
			tPic.setPicUrl(rs.getString("pic_url"));
			tPic.setCreateTime(rs.getTimestamp("create_time"));
			tPic.setUpdateTime(rs.getTimestamp("update_time"));
			return tPic; 
        }  
          
    }
}
