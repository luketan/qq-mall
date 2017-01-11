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
public class PicBean extends BaseEntity implements Serializable{

	private Integer id=null;
	private Integer urlType=null;
	private String picTitle=null;
	private String picUrl=null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PicBean(){
 	}
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
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
	public static class PicBeanRowMapper implements RowMapper<PicBean> {  
        @Override  
        public PicBean mapRow(ResultSet rs, int rowNum) throws SQLException {  

			PicBean pic = new PicBean();
			pic.setId(rs.getInt("id"));
			pic.setUrlType(rs.getInt("url_type"));
			pic.setPicTitle(rs.getString("pic_title"));
			pic.setPicUrl(rs.getString("pic_url"));
			return pic; 
        }  
          
    }

}
