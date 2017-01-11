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
*系统消息
**/
public class TSystemSet extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "参数名",dbName = "name",length = 32,allowNull=true)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "参数代码",dbName = "code",length = 128,allowNull=true)
	private String code=null;
	@FieldMeta(primaryKey = false,fieldName = "参数值",dbName = "val",length = 65535,allowNull=true)
	private String val=null;
	@FieldMeta(primaryKey = false,fieldName = "备注",dbName = "remark",length = 255,allowNull=true)
	private String remark=null;
	@FieldMeta(primaryKey = false,fieldName = "创建时间",dbName = "create_time",length = 19,allowNull=true)
	private Date createTime=null;
	@FieldMeta(primaryKey = false,fieldName = "修改时间",dbName = "update_time",length = 19,allowNull=true)
	private Date updateTime=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TSystemSet(){
 	}
 	public TSystemSet(Integer id,String name,String code,String val,String remark){
 		this.id = id;
		this.name = name;
		this.code = code;
		this.val = val;
		this.remark = remark;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*参数名*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*参数代码*/
	public String getCode(){
		 return this.code; 
	}
	public void setCode(String code){
		  this.code = code; 
	}
	/*参数值*/
	public String getVal(){
		 return this.val; 
	}
	public void setVal(String val){
		  this.val = val; 
	}
	/*备注*/
	public String getRemark(){
		 return this.remark; 
	}
	public void setRemark(String remark){
		  this.remark = remark; 
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
		tableName("t_system_set",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,true),
		code("code",Types.VARCHAR,false,false,true),
		val("val",Types.LONGVARCHAR,false,false,true),
		remark("remark",Types.VARCHAR,false,false,true),
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
	public static class TSystemSetRowMapper implements RowMapper<TSystemSet> {  
        @Override  
        public TSystemSet mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSystemSet tSystemSet = new TSystemSet();
			tSystemSet.setId(rs.getInt("id"));
			tSystemSet.setName(rs.getString("name"));
			tSystemSet.setCode(rs.getString("code"));
			tSystemSet.setVal(rs.getString("val"));
			tSystemSet.setRemark(rs.getString("remark"));
			tSystemSet.setCreateTime(rs.getTimestamp("create_time"));
			tSystemSet.setUpdateTime(rs.getTimestamp("update_time"));
			return tSystemSet; 
        }  
          
    }
}
