package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;


/**
*规格种类
**/
public class FormatSubBean implements Serializable{

	private Integer id=null;
	private String name=null;
	private BigDecimal price=null;
	private BigDecimal vipPrice=null;
	private Integer select=null;
	private String args=null;
	private Boolean deleteFlag=null;
	
	private String formatName;
	private Boolean needPrice;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FormatSubBean(){
 	}
 	public FormatSubBean(Integer id,Integer formatId,String name,BigDecimal price,BigDecimal vipPrice,Integer select,Integer deleteFlag,String args,Integer sort){
 		this.id = id;
		this.name = name;
		this.price = price;
		this.vipPrice = vipPrice;
		this.select = select;
		this.args = args;
		
 	}
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
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
	public String getFormatName() {
		return formatName;
	}
	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Boolean getNeedPrice() {
		return needPrice;
	}
	public void setNeedPrice(Boolean needPrice) {
		this.needPrice = needPrice;
	}

	public enum DBMaping{
		tableName("t_format_sub",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		formatId("format_id",Types.INTEGER,false,false,false),
		name("name",Types.VARCHAR,false,false,true),
		price("price",Types.DECIMAL,false,false,true),
		vipPrice("vip_price",Types.DECIMAL,false,false,true),
		select("select",Types.INTEGER,false,false,true),
		deleteFlag("delete_flag",Types.INTEGER,false,false,true),
		args("args",Types.VARCHAR,false,false,true),
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
	
	public static class FormatSubBeanRowMapper implements RowMapper<FormatSubBean> {  
        @Override  
        public FormatSubBean mapRow(ResultSet rs, int rowNum) throws SQLException {  

			FormatSubBean formatSubBean = new FormatSubBean();
			formatSubBean.setId(rs.getInt("id"));
			formatSubBean.setName(rs.getString("name"));
			formatSubBean.setPrice(rs.getBigDecimal("price"));
			formatSubBean.setVipPrice(rs.getBigDecimal("vip_price"));
			formatSubBean.setSelect(rs.getInt("select"));
			formatSubBean.setArgs(rs.getString("args"));
			return formatSubBean; 
        }  
          
    }
	/**
	 * 查询已经在购物车内的商品规格
	 * @author Administrator
	 *
	 */
	public static class FormatSubBeanForShoppingCartRowMapper implements RowMapper<FormatSubBean> {  
        @Override  
        public FormatSubBean mapRow(ResultSet rs, int rowNum) throws SQLException {  

			FormatSubBean formatSubBean = new FormatSubBean();
			formatSubBean.setId(rs.getInt("id"));
			formatSubBean.setName(rs.getString("name"));
			formatSubBean.setPrice(rs.getBigDecimal("price"));
			formatSubBean.setVipPrice(rs.getBigDecimal("vip_price"));
			formatSubBean.setArgs(rs.getString("args"));
			formatSubBean.setFormatName(rs.getString("format_name"));
			//经在购物车内的商品规格是否已过期
			formatSubBean.setDeleteFlag(rs.getBoolean("delete_flag"));
			formatSubBean.setNeedPrice(rs.getBoolean("need_price"));
			return formatSubBean; 
        }  
          
    }
}
