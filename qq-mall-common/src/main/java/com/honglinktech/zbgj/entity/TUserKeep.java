package com.honglinktech.zbgj.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;
import java.math.BigDecimal; 

import java.util.Date; 


/**
*用户的收藏
**/
public class TUserKeep extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "ID",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "用户ID",dbName = "user_id",length = 10,allowNull=true)
	private Integer userId=null;
	@FieldMeta(primaryKey = false,fieldName = "收藏ID(商品，帖子)",dbName = "obj_id",length = 10,allowNull=true)
	private Integer objId=null;
	@FieldMeta(primaryKey = false,fieldName = "类型ID",dbName = "obj_type",length = 10,allowNull=true)
	private Integer objType=null;
	@FieldMeta(primaryKey = false,fieldName = "类型名称",dbName = "obj_type_name",length = 64,allowNull=true)
	private String objTypeName=null;
	@FieldMeta(primaryKey = false,fieldName = "类型(1商品，2贴子)",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "名称",dbName = "name",length = 225,allowNull=true)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "图片地址",dbName = "img_url",length = 225,allowNull=true)
	private String imgUrl=null;
	@FieldMeta(primaryKey = false,fieldName = "商品价格",dbName = "price",length = 10,allowNull=true)
	private BigDecimal price=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TUserKeep(){
 	}
 	public TUserKeep(Integer id,Integer userId,Integer objId,Integer objType,String objTypeName,Integer type,String name,String imgUrl,BigDecimal price){
 		this.id = id;
		this.userId = userId;
		this.objId = objId;
		this.objType = objType;
		this.objTypeName = objTypeName;
		this.type = type;
		this.name = name;
		this.imgUrl = imgUrl;
		this.price = price;
		
 	}
 	
		/*ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*用户ID*/
	public Integer getUserId(){
		 return this.userId; 
	}
	public void setUserId(Integer userId){
		  this.userId = userId; 
	}
	/*收藏ID(商品，帖子)*/
	public Integer getObjId(){
		 return this.objId; 
	}
	public void setObjId(Integer objId){
		  this.objId = objId; 
	}
	/*类型ID*/
	public Integer getObjType(){
		 return this.objType; 
	}
	public void setObjType(Integer objType){
		  this.objType = objType; 
	}
	/*类型名称*/
	public String getObjTypeName(){
		 return this.objTypeName; 
	}
	public void setObjTypeName(String objTypeName){
		  this.objTypeName = objTypeName; 
	}
	/*类型(1商品，2贴子)*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*图片地址*/
	public String getImgUrl(){
		 return this.imgUrl; 
	}
	public void setImgUrl(String imgUrl){
		  this.imgUrl = imgUrl; 
	}
	/*商品价格*/
	public BigDecimal getPrice(){
		 return this.price; 
	}
	public void setPrice(BigDecimal price){
		  this.price = price; 
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
		tableName("t_user_keep",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		userId("user_id",Types.INTEGER,false,false,true),
		objId("obj_id",Types.INTEGER,false,false,true),
		objType("obj_type",Types.INTEGER,false,false,true),
		objTypeName("obj_type_name",Types.VARCHAR,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		name("name",Types.VARCHAR,false,false,true),
		imgUrl("img_url",Types.VARCHAR,false,false,true),
		price("price",Types.DECIMAL,false,false,true),
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
	public static class TUserKeepRowMapper implements RowMapper<TUserKeep> {  
        @Override  
        public TUserKeep mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TUserKeep tUserKeep = new TUserKeep();
			tUserKeep.setId(rs.getInt("id"));
			tUserKeep.setUserId(rs.getInt("user_id"));
			tUserKeep.setObjId(rs.getInt("obj_id"));
			tUserKeep.setObjType(rs.getInt("obj_type"));
			tUserKeep.setObjTypeName(rs.getString("obj_type_name"));
			tUserKeep.setType(rs.getInt("type"));
			tUserKeep.setName(rs.getString("name"));
			tUserKeep.setImgUrl(rs.getString("img_url"));
			tUserKeep.setPrice(rs.getBigDecimal("price"));
			tUserKeep.setCreateTime(rs.getTimestamp("create_time"));
			tUserKeep.setUpdateTime(rs.getTimestamp("update_time"));
			return tUserKeep; 
        }  
          
    }
}
