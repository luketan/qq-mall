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
*商品款式
**/
public class TGoodsTypeSub extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "类型名称",dbName = "name",length = 225,allowNull=false)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "商品类型",dbName = "goods_type",length = 10,allowNull=true)
	private Integer goodsType=null;
	@FieldMeta(primaryKey = false,fieldName = "类型名称",dbName = "type_name",length = 50,allowNull=true)
	private String typeName=null;
	@FieldMeta(primaryKey = false,fieldName = "删除标志",dbName = "delete_flag",length = 10,allowNull=true)
	private Integer deleteFlag=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TGoodsTypeSub(){
 	}
 	public TGoodsTypeSub(Integer id,String name,Integer goodsType,String typeName,Integer deleteFlag){
 		this.id = id;
		this.name = name;
		this.goodsType = goodsType;
		this.typeName = typeName;
		this.deleteFlag = deleteFlag;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*类型名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*商品类型*/
	public Integer getGoodsType(){
		 return this.goodsType; 
	}
	public void setGoodsType(Integer goodsType){
		  this.goodsType = goodsType; 
	}
	/*类型名称*/
	public String getTypeName(){
		 return this.typeName; 
	}
	public void setTypeName(String typeName){
		  this.typeName = typeName; 
	}
	/*删除标志*/
	public Integer getDeleteFlag(){
		 return this.deleteFlag; 
	}
	public void setDeleteFlag(Integer deleteFlag){
		  this.deleteFlag = deleteFlag; 
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
		tableName("t_goods_type_sub",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,false),
		goodsType("goods_type",Types.INTEGER,false,false,true),
		typeName("type_name",Types.VARCHAR,false,false,true),
		deleteFlag("delete_flag",Types.INTEGER,false,false,true),
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
	public static class TGoodsTypeSubRowMapper implements RowMapper<TGoodsTypeSub> {  
        @Override  
        public TGoodsTypeSub mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TGoodsTypeSub tGoodsTypeSub = new TGoodsTypeSub();
			tGoodsTypeSub.setId(rs.getInt("id"));
			tGoodsTypeSub.setName(rs.getString("name"));
			tGoodsTypeSub.setGoodsType(rs.getInt("goods_type"));
			tGoodsTypeSub.setTypeName(rs.getString("type_name"));
			tGoodsTypeSub.setDeleteFlag(rs.getInt("delete_flag"));
			tGoodsTypeSub.setCreateTime(rs.getTimestamp("create_time"));
			tGoodsTypeSub.setUpdateTime(rs.getTimestamp("update_time"));
			return tGoodsTypeSub; 
        }  
          
    }
}
