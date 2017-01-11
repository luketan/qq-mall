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
*产品款式
**/
public class TFormat extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "产品ID",dbName = "goods_id",length = 10,allowNull=true)
	private Integer goodsId=null;
	@FieldMeta(primaryKey = false,fieldName = "名称",dbName = "name",length = 64,allowNull=true)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "是否可选样式价格",dbName = "need_price",length = 10,allowNull=true)
	private Integer needPrice=null;
	@FieldMeta(primaryKey = false,fieldName = "排序",dbName = "sort",length = 10,allowNull=true)
	private Integer sort=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "delete_flag",length = 3,allowNull=true)
	private Boolean deleteFlag=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TFormat(){
 	}
 	public TFormat(Integer id,Integer goodsId,String name,Integer needPrice,Integer sort,Boolean deleteFlag){
 		this.id = id;
		this.goodsId = goodsId;
		this.name = name;
		this.needPrice = needPrice;
		this.sort = sort;
		this.deleteFlag = deleteFlag;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*产品ID*/
	public Integer getGoodsId(){
		 return this.goodsId; 
	}
	public void setGoodsId(Integer goodsId){
		  this.goodsId = goodsId; 
	}
	/*名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*是否可选样式价格*/
	public Integer getNeedPrice(){
		 return this.needPrice; 
	}
	public void setNeedPrice(Integer needPrice){
		  this.needPrice = needPrice; 
	}
	/*排序*/
	public Integer getSort(){
		 return this.sort; 
	}
	public void setSort(Integer sort){
		  this.sort = sort; 
	}
	/**/
	public Boolean isDeleteFlag(){
		 return this.deleteFlag; 
	}
	public void setDeleteFlag(Boolean deleteFlag){
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
		tableName("t_format",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		goodsId("goods_id",Types.INTEGER,false,false,true),
		name("name",Types.VARCHAR,false,false,true),
		needPrice("need_price",Types.INTEGER,false,false,true),
		sort("sort",Types.INTEGER,false,false,true),
		deleteFlag("delete_flag",Types.TINYINT,false,false,true),
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
	public static class TFormatRowMapper implements RowMapper<TFormat> {  
        @Override  
        public TFormat mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TFormat tFormat = new TFormat();
			tFormat.setId(rs.getInt("id"));
			tFormat.setGoodsId(rs.getInt("goods_id"));
			tFormat.setName(rs.getString("name"));
			tFormat.setNeedPrice(rs.getInt("need_price"));
			tFormat.setSort(rs.getInt("sort"));
			tFormat.setDeleteFlag(rs.getBoolean("delete_flag"));
			tFormat.setCreateTime(rs.getTimestamp("create_time"));
			tFormat.setUpdateTime(rs.getTimestamp("update_time"));
			return tFormat; 
        }  
          
    }
}
