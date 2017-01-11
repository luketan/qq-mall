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
*帖子和评论点赞
**/
public class TSocietyLike extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "ID(帖子ID,或者评论ID或者评论的评论ID）",dbName = "obj_id",length = 10,allowNull=false)
	private Integer objId=null;
	@FieldMeta(primaryKey = false,fieldName = "用户ID",dbName = "user_id",length = 10,allowNull=false)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "类型1是帖子，2是评论,3是评论的评论",dbName = "type",length = 10,allowNull=false)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TSocietyLike(){
 	}
 	public TSocietyLike(Integer id,Integer objId,Integer userId,Integer type){
 		this.id = id;
		this.objId = objId;
		this.userId = userId;
		this.type = type;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*ID(帖子ID,或者评论ID或者评论的评论ID）*/
	public Integer getObjId(){
		 return this.objId; 
	}
	public void setObjId(Integer objId){
		  this.objId = objId; 
	}
	/*用户ID*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*类型1是帖子，2是评论,3是评论的评论*/
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

	
	public enum DBMaping{
		tableName("t_society_like",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		objId("obj_id",Types.INTEGER,false,false,false),
		userId("user_id",Types.INTEGER,false,false,false),
		type("type",Types.INTEGER,false,false,false),
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
	public static class TSocietyLikeRowMapper implements RowMapper<TSocietyLike> {  
        @Override  
        public TSocietyLike mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSocietyLike tSocietyLike = new TSocietyLike();
			tSocietyLike.setId(rs.getInt("id"));
			tSocietyLike.setObjId(rs.getInt("obj_id"));
			tSocietyLike.setUserId(rs.getInt("user_id"));
			tSocietyLike.setType(rs.getInt("type"));
			tSocietyLike.setCreateTime(rs.getTimestamp("create_time"));
			return tSocietyLike; 
        }  
          
    }
}
