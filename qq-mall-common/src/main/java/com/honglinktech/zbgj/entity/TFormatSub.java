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
*规格种类
**/
public class TFormatSub extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "规格ID",dbName = "format_id",length = 10,allowNull=false)
	private Integer formatId=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "format_name",length = 255,allowNull=true)
	private String formatName=null;
	@FieldMeta(primaryKey = false,fieldName = "名称",dbName = "name",length = 255,allowNull=true)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "费用",dbName = "price",length = 10,allowNull=true)
	private BigDecimal price=null;
	@FieldMeta(primaryKey = false,fieldName = "vip费用",dbName = "vip_price",length = 10,allowNull=true)
	private BigDecimal vipPrice=null;
	@FieldMeta(primaryKey = false,fieldName = "是否可选",dbName = "select",length = 10,allowNull=true)
	private Integer select=null;
	@FieldMeta(primaryKey = false,fieldName = "系数",dbName = "args",length = 128,allowNull=true)
	private String args=null;
	@FieldMeta(primaryKey = false,fieldName = "删除标志",dbName = "delete_flag",length = 10,allowNull=true)
	private Integer deleteFlag=null;
	@FieldMeta(primaryKey = false,fieldName = "排序",dbName = "sort",length = 10,allowNull=true)
	private Integer sort=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TFormatSub(){
 	}
 	public TFormatSub(Integer id,Integer formatId,String formatName,String name,BigDecimal price,BigDecimal vipPrice,Integer select,String args,Integer deleteFlag,Integer sort){
 		this.id = id;
		this.formatId = formatId;
		this.formatName = formatName;
		this.name = name;
		this.price = price;
		this.vipPrice = vipPrice;
		this.select = select;
		this.args = args;
		this.deleteFlag = deleteFlag;
		this.sort = sort;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*规格ID*/
	public Integer getFormatId(){
		 return this.formatId; 
	}
	public void setFormatId(Integer formatId){
		  this.formatId = formatId; 
	}
	/**/
	public String getFormatName(){
		 return this.formatName; 
	}
	public void setFormatName(String formatName){
		  this.formatName = formatName; 
	}
	/*名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*费用*/
	public BigDecimal getPrice(){
		 return this.price; 
	}
	public void setPrice(BigDecimal price){
		  this.price = price; 
	}
	/*vip费用*/
	public BigDecimal getVipPrice(){
		 return this.vipPrice; 
	}
	public void setVipPrice(BigDecimal vipPrice){
		  this.vipPrice = vipPrice; 
	}
	/*是否可选*/
	public Integer getSelect(){
		 return this.select; 
	}
	public void setSelect(Integer select){
		  this.select = select; 
	}
	/*系数*/
	public String getArgs(){
		 return this.args; 
	}
	public void setArgs(String args){
		  this.args = args; 
	}
	/*删除标志*/
	public Integer getDeleteFlag(){
		 return this.deleteFlag; 
	}
	public void setDeleteFlag(Integer deleteFlag){
		  this.deleteFlag = deleteFlag; 
	}
	/*排序*/
	public Integer getSort(){
		 return this.sort; 
	}
	public void setSort(Integer sort){
		  this.sort = sort; 
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
		tableName("t_format_sub",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		formatId("format_id",Types.INTEGER,false,false,false),
		formatName("format_name",Types.VARCHAR,false,false,true),
		name("name",Types.VARCHAR,false,false,true),
		price("price",Types.DECIMAL,false,false,true),
		vipPrice("vip_price",Types.DECIMAL,false,false,true),
		select("select",Types.INTEGER,false,false,true),
		args("args",Types.VARCHAR,false,false,true),
		deleteFlag("delete_flag",Types.INTEGER,false,false,true),
		sort("sort",Types.INTEGER,false,false,true),
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
	public static class TFormatSubRowMapper implements RowMapper<TFormatSub> {  
        @Override  
        public TFormatSub mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TFormatSub tFormatSub = new TFormatSub();
			tFormatSub.setId(rs.getInt("id"));
			tFormatSub.setFormatId(rs.getInt("format_id"));
			tFormatSub.setFormatName(rs.getString("format_name"));
			tFormatSub.setName(rs.getString("name"));
			tFormatSub.setPrice(rs.getBigDecimal("price"));
			tFormatSub.setVipPrice(rs.getBigDecimal("vip_price"));
			tFormatSub.setSelect(rs.getInt("select"));
			tFormatSub.setArgs(rs.getString("args"));
			tFormatSub.setDeleteFlag(rs.getInt("delete_flag"));
			tFormatSub.setSort(rs.getInt("sort"));
			tFormatSub.setCreateTime(rs.getTimestamp("create_time"));
			tFormatSub.setUpdateTime(rs.getTimestamp("update_time"));
			return tFormatSub; 
        }  
          
    }
}
