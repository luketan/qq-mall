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
*优惠券
**/
public class TCoupon extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "ID",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "名称",dbName = "name",length = 50,allowNull=true)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "条件文本",dbName = "condition",length = 255,allowNull=true)
	private String condition=null;
	@FieldMeta(primaryKey = false,fieldName = "详情",dbName = "detail",length = 255,allowNull=true)
	private String detail=null;
	@FieldMeta(primaryKey = false,fieldName = "条件商品类型ID",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "商品类型名称",dbName = "type_name",length = 128,allowNull=true)
	private String typeName=null;
	@FieldMeta(primaryKey = false,fieldName = "条件满多少可以用",dbName = "max",length = 10,allowNull=true)
	private Integer max=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "value",length = 10,allowNull=true)
	private Integer value=null;
	@FieldMeta(primaryKey = false,fieldName = "开始时间",dbName = "start_date",length = 10,allowNull=true)
	private Date startDate=null;
	@FieldMeta(primaryKey = false,fieldName = "结束时间",dbName = "end_date",length = 10,allowNull=true)
	private Date endDate=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TCoupon(){
 	}
 	public TCoupon(Integer id,String name,String condition,String detail,Integer type,String typeName,Integer max,Integer value,Date startDate,Date endDate){
 		this.id = id;
		this.name = name;
		this.condition = condition;
		this.detail = detail;
		this.type = type;
		this.typeName = typeName;
		this.max = max;
		this.value = value;
		this.startDate = startDate;
		this.endDate = endDate;
		
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
	/*条件文本*/
	public String getCondition(){
		 return this.condition; 
	}
	public void setCondition(String condition){
		  this.condition = condition; 
	}
	/*详情*/
	public String getDetail(){
		 return this.detail; 
	}
	public void setDetail(String detail){
		  this.detail = detail; 
	}
	/*条件商品类型ID*/
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
	/*开始时间*/
	public Date getStartDate(){
		 return this.startDate; 
	}
	public void setStartDate(Date startDate){
		  this.startDate = startDate; 
	}
	/*结束时间*/
	public Date getEndDate(){
		 return this.endDate; 
	}
	public void setEndDate(Date endDate){
		  this.endDate = endDate; 
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
		tableName("t_coupon",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,true),
		condition("condition",Types.VARCHAR,false,false,true),
		detail("detail",Types.VARCHAR,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		typeName("type_name",Types.VARCHAR,false,false,true),
		max("max",Types.INTEGER,false,false,true),
		value("value",Types.INTEGER,false,false,true),
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
	public static class TCouponRowMapper implements RowMapper<TCoupon> {  
        @Override  
        public TCoupon mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TCoupon tCoupon = new TCoupon();
			tCoupon.setId(rs.getInt("id"));
			tCoupon.setName(rs.getString("name"));
			tCoupon.setCondition(rs.getString("condition"));
			tCoupon.setDetail(rs.getString("detail"));
			tCoupon.setType(rs.getInt("type"));
			tCoupon.setTypeName(rs.getString("type_name"));
			tCoupon.setMax(rs.getInt("max"));
			tCoupon.setValue(rs.getInt("value"));
			tCoupon.setStartDate(rs.getTimestamp("start_date"));
			tCoupon.setEndDate(rs.getTimestamp("end_date"));
			tCoupon.setCreateTime(rs.getTimestamp("create_time"));
			tCoupon.setUpdateTime(rs.getTimestamp("update_time"));
			return tCoupon; 
        }  
          
    }
}
