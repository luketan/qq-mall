package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.entity.TCoupon;


/**
*优惠券
**/
public class CouponBean	 implements Serializable{

	private Integer id=null;
	private String name=null;
	private Integer type=null;
	private String typeName=null;
	private Integer max=null;
	private Integer value=null;
	
	private boolean select;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CouponBean(){
 	}
 	public CouponBean(TCoupon tcoupon){
 		this.id = tcoupon.getId();
		this.name = tcoupon.getName();
		this.type = tcoupon.getType();
		this.typeName = tcoupon.getTypeName();
		this.max = tcoupon.getMax();
		this.value = tcoupon.getValue();
 	}
 	
		/*ID*/
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
	/*条件商品类型(1优惠券）*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*商品类型名称*/
	public String getTypeName(){
		 return this.typeName; 
	}
	public void setTypeName(String typeName){
		  this.typeName = typeName; 
	}
	/*条件满多少可以用*/
	public Integer getMax(){
		 return this.max; 
	}
	public void setMax(Integer max){
		  this.max = max; 
	}
	/**/
	public Integer getValue(){
		 return this.value; 
	}
	public void setValue(Integer value){
		  this.value = value; 
	}
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}

	public enum DBMaping{
		tableName("t_coupon",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		typeName("type_name",Types.VARCHAR,false,false,true),
		max("max",Types.INTEGER,false,false,true),
		value("value",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
		startDate("start_date",Types.DATE,false,false,true),
		endDate("end_date",Types.DATE,false,false,true),
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
	public static class CouponBeanRowMapper implements RowMapper<CouponBean> {  
        @Override  
        public CouponBean mapRow(ResultSet rs, int rowNum) throws SQLException {  

			CouponBean tCoupon = new CouponBean();
			tCoupon.setId(rs.getInt("id"));
			tCoupon.setName(rs.getString("name"));
			tCoupon.setType(rs.getInt("type"));
			tCoupon.setTypeName(rs.getString("type_name"));
			tCoupon.setMax(rs.getInt("max"));
			tCoupon.setValue(rs.getInt("value"));
			return tCoupon; 
        }  
          
    }
}
