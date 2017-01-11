package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;


/**
*产品款式
**/
public class FormatBean implements Serializable{

	private Integer id=null;
	private String name=null;
	private Integer needPrice=null;
	
	private List<FormatSubBean> formatSubBeanList;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FormatBean(){
 	}
 	public FormatBean(Integer id,Integer goodsId,String name,Integer needPrice,Integer sort,Boolean deleteFlag){
 		this.id = id;
		this.name = name;
		this.needPrice = needPrice;
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
	/*是否可选样式价格*/
	public Integer getNeedPrice(){
		 return this.needPrice; 
	}
	public void setNeedPrice(Integer needPrice){
		  this.needPrice = needPrice; 
	}
	
	public List<FormatSubBean> getFormatSubBeanList() {
		return formatSubBeanList;
	}
	public void setFormatSubBeanList(List<FormatSubBean> formatSubBeanList) {
		this.formatSubBeanList = formatSubBeanList;
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
	public static class FormatBeanRowMapper implements RowMapper<FormatBean> {  
        @Override  
        public FormatBean mapRow(ResultSet rs, int rowNum) throws SQLException {  
			FormatBean formatBean = new FormatBean();
			formatBean.setId(rs.getInt("id"));
			formatBean.setName(rs.getString("name"));
			formatBean.setNeedPrice(rs.getInt("need_price"));
			return formatBean; 
        }  
          
    }
}
