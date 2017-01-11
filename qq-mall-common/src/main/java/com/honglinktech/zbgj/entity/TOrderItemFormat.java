package com.honglinktech.zbgj.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;

/**
*订单商品的规格
**/
public class TOrderItemFormat extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "订单项Id",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "主订单ID",dbName = "order_item_id",length = 10,allowNull=false)
	private Integer orderItemId=null;
	@FieldMeta(primaryKey = false,fieldName = "规格子类ID",dbName = "format_sub_id",length = 10,allowNull=false)
	private Integer formatSubId=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TOrderItemFormat(){
 	}
 	public TOrderItemFormat(Integer id,Integer orderItemId,Integer formatSubId){
 		this.id = id;
		this.orderItemId = orderItemId;
		this.formatSubId = formatSubId;
		
 	}
 	
		/*订单项Id*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*主订单ID*/
	public Integer getOrderItemId(){
		 return this.orderItemId; 
	}
	public void setOrderItemId(Integer orderItemId){
		  this.orderItemId = orderItemId; 
	}
	/*规格子类ID*/
	public Integer getFormatSubId(){
		 return this.formatSubId; 
	}
	public void setFormatSubId(Integer formatSubId){
		  this.formatSubId = formatSubId; 
	}

	
	public enum DBMaping{
		tableName("t_order_item_format",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		orderItemId("order_item_id",Types.INTEGER,false,false,false),
		formatSubId("format_sub_id",Types.INTEGER,false,false,false);
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
	public static class TOrderItemFormatRowMapper implements RowMapper<TOrderItemFormat> {  
        @Override  
        public TOrderItemFormat mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TOrderItemFormat tOrderItemFormat = new TOrderItemFormat();
			tOrderItemFormat.setId(rs.getInt("id"));
			tOrderItemFormat.setOrderItemId(rs.getInt("order_item_id"));
			tOrderItemFormat.setFormatSubId(rs.getInt("format_sub_id"));
			return tOrderItemFormat; 
        }  
          
    }
}
