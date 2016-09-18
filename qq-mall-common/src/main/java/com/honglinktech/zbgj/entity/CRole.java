package com.honglinktech.zbgj.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;

/**
*系统角色表
**/
public class CRole extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "角色ID",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "关联系统",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "角色名称",dbName = "name",length = 32,allowNull=true)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "角色描述",dbName = "desc",length = 255,allowNull=true)
	private String desc=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CRole(){
 	}
 	public CRole(Integer id,Integer type,String name,String desc){
 		this.id = id;
		this.type = type;
		this.name = name;
		this.desc = desc;
		
 	}
 	
		/*角色ID*/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*关联系统*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*角色名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*角色描述*/
	public String getDesc(){
		 return this.desc; 
	}
	public void setDesc(String desc){
		  this.desc = desc; 
	}

	
	public enum DBMaping{
		tableName("c_role",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		type("type",Types.INTEGER,false,false,true),
		name("name",Types.VARCHAR,false,false,true),
		desc("desc",Types.VARCHAR,false,false,true);
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
	public static class CRoleRowMapper implements RowMapper<CRole> {  
        @Override  
        public CRole mapRow(ResultSet rs, int rowNum) throws SQLException {  

			CRole cRole = new CRole();
			cRole.setId(rs.getInt("id"));
			cRole.setType(rs.getInt("type"));
			cRole.setName(rs.getString("name"));
			cRole.setDesc(rs.getString("desc"));
			return cRole; 
        }  
          
    }
}
