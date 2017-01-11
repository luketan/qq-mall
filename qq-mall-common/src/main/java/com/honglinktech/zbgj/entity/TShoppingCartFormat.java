package com.honglinktech.zbgj.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;

/**
*购物车规格中间表
**/
public class TShoppingCartFormat extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "购物车ID",dbName = "shopping_cart_id",length = 10,allowNull=false)
	private Integer shoppingCartId=null;
	@FieldMeta(primaryKey = false,fieldName = "规格子类ID",dbName = "format_sub_id",length = 10,allowNull=false)
	private Integer formatSubId=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TShoppingCartFormat(){
 	}
 	public TShoppingCartFormat(Integer id,Integer shoppingCartId,Integer formatSubId){
 		this.id = id;
		this.shoppingCartId = shoppingCartId;
		this.formatSubId = formatSubId;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*购物车ID*/
	public Integer getShoppingCartId(){
		 return this.shoppingCartId; 
	}
	public void setShoppingCartId(Integer shoppingCartId){
		  this.shoppingCartId = shoppingCartId; 
	}
	/*规格子类ID*/
	public Integer getFormatSubId(){
		 return this.formatSubId; 
	}
	public void setFormatSubId(Integer formatSubId){
		  this.formatSubId = formatSubId; 
	}

	
	public enum DBMaping{
		tableName("t_shopping_cart_format",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		shoppingCartId("shopping_cart_id",Types.INTEGER,false,false,false),
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
	public static class TShoppingCartFormatRowMapper implements RowMapper<TShoppingCartFormat> {  
        @Override  
        public TShoppingCartFormat mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TShoppingCartFormat tShoppingCartFormat = new TShoppingCartFormat();
			tShoppingCartFormat.setId(rs.getInt("id"));
			tShoppingCartFormat.setShoppingCartId(rs.getInt("shopping_cart_id"));
			tShoppingCartFormat.setFormatSubId(rs.getInt("format_sub_id"));
			return tShoppingCartFormat; 
        }  
          
    }
}
