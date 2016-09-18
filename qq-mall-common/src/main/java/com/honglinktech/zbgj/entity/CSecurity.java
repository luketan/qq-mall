package com.honglinktech.zbgj.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;

/**
*系统权限表
**/
public class CSecurity extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "父节点ID",dbName = "parent_id",length = 10,allowNull=true)
	private Integer parentId=null;
	@FieldMeta(primaryKey = false,fieldName = "权限类型(1.后台管理,2.商户管理)",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "权限名称",dbName = "name",length = 32,allowNull=true)
	private String name=null;
	@FieldMeta(primaryKey = false,fieldName = "权限编码",dbName = "code",length = 32,allowNull=true)
	private String code=null;
	@FieldMeta(primaryKey = false,fieldName = "权限说明",dbName = "desc",length = 255,allowNull=true)
	private String desc=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CSecurity(){
 	}
 	public CSecurity(Integer id,Integer parentId,Integer type,String name,String code,String desc){
 		this.id = id;
		this.parentId = parentId;
		this.type = type;
		this.name = name;
		this.code = code;
		this.desc = desc;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*父节点ID*/
	public Integer getParentId(){
		 return this.parentId; 
	}
	public void setParentId(Integer parentId){
		  this.parentId = parentId; 
	}
	/*权限类型(1.后台管理,2.商户管理)*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*权限名称*/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/*权限编码*/
	public String getCode(){
		 return this.code; 
	}
	public void setCode(String code){
		  this.code = code; 
	}
	/*权限说明*/
	public String getDesc(){
		 return this.desc; 
	}
	public void setDesc(String desc){
		  this.desc = desc; 
	}

	
	public enum DBMaping{
		tableName("c_security",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		parentId("parent_id",Types.INTEGER,false,false,true),
		type("type",Types.INTEGER,false,false,true),
		name("name",Types.VARCHAR,false,false,true),
		code("code",Types.VARCHAR,false,false,true),
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
	public static class CSecurityRowMapper implements RowMapper<CSecurity> {  
        @Override  
        public CSecurity mapRow(ResultSet rs, int rowNum) throws SQLException {  

			CSecurity cSecurity = new CSecurity();
			cSecurity.setId(rs.getInt("id"));
			cSecurity.setParentId(rs.getInt("parent_id"));
			cSecurity.setType(rs.getInt("type"));
			cSecurity.setName(rs.getString("name"));
			cSecurity.setCode(rs.getString("code"));
			cSecurity.setDesc(rs.getString("desc"));
			return cSecurity; 
        }  
          
    }
}
