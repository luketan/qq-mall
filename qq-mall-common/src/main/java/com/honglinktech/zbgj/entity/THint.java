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
*提示语
**/
public class THint extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "内容",dbName = "content",length = 255,allowNull=false)
	private String content=null;
	@FieldMeta(primaryKey = false,fieldName = "论坛主题(不同的主题)",dbName = "sub_type",length = 10,allowNull=true)
	private Integer subType=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "remark",length = 20,allowNull=true)
	private String remark=null;
	@FieldMeta(primaryKey = true,fieldName = "类型(1下拉更新,2转圈,3发帖,4回帖)",dbName = "type",length = 10,allowNull=false)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "更新时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public THint(){
 	}
 	public THint(Integer id,String content,Integer subType,String remark,Integer type){
 		this.id = id;
		this.content = content;
		this.subType = subType;
		this.remark = remark;
		this.type = type;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*内容*/
	public String getContent(){
		 return this.content; 
	}
	public void setContent(String content){
		  this.content = content; 
	}
	/*论坛主题(不同的主题)*/
	public Integer getSubType(){
		 return this.subType; 
	}
	public void setSubType(Integer subType){
		  this.subType = subType; 
	}
	/**/
	public String getRemark(){
		 return this.remark; 
	}
	public void setRemark(String remark){
		  this.remark = remark; 
	}
	/*类型(1下拉更新,2转圈,3发帖,4回帖)*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*创建时间*/
	public Date getCreateTime(){
		 return this.createTime; 
	}
	public void setCreateTime(Date createTime){
		  this.createTime = createTime; 
	}
	/*更新时间*/
	public Date getUpdateTime(){
		 return this.updateTime; 
	}
	public void setUpdateTime(Date updateTime){
		  this.updateTime = updateTime; 
	}

	
	public enum DBMaping{
		tableName("t_hint",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		content("content",Types.VARCHAR,false,false,false),
		subType("sub_type",Types.INTEGER,false,false,true),
		remark("remark",Types.VARCHAR,false,false,true),
		type("type",Types.INTEGER,true,false,false),
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
	public static class THintRowMapper implements RowMapper<THint> {  
        @Override  
        public THint mapRow(ResultSet rs, int rowNum) throws SQLException {  

			THint tHint = new THint();
			tHint.setId(rs.getInt("id"));
			tHint.setContent(rs.getString("content"));
			tHint.setSubType(rs.getInt("sub_type"));
			tHint.setRemark(rs.getString("remark"));
			tHint.setType(rs.getInt("type"));
			tHint.setCreateTime(rs.getTimestamp("create_time"));
			tHint.setUpdateTime(rs.getTimestamp("update_time"));
			return tHint; 
        }  
          
    }
}
