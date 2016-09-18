package com.honglinktech.zbgj.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;

/**
*角色权限关联表
**/
public class CRoleSecurity extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "角色ID",dbName = "role_id",length = 10,allowNull=true)
	private Integer roleId=null;
	@FieldMeta(primaryKey = false,fieldName = "权限ID",dbName = "security_id",length = 10,allowNull=true)
	private Integer securityId=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CRoleSecurity(){
 	}
 	public CRoleSecurity(Integer id,Integer roleId,Integer securityId){
 		this.id = id;
		this.roleId = roleId;
		this.securityId = securityId;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*角色ID*/
	public Integer getRoleId(){
		 return this.roleId; 
	}
	public void setRoleId(Integer roleId){
		  this.roleId = roleId; 
	}
	/*权限ID*/
	public Integer getSecurityId(){
		 return this.securityId; 
	}
	public void setSecurityId(Integer securityId){
		  this.securityId = securityId; 
	}

	
	public enum DBMaping{
		tableName("c_role_security",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		roleId("role_id",Types.INTEGER,false,false,true),
		securityId("security_id",Types.INTEGER,false,false,true);
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
	public static class CRoleSecurityRowMapper implements RowMapper<CRoleSecurity> {  
        @Override  
        public CRoleSecurity mapRow(ResultSet rs, int rowNum) throws SQLException {  

			CRoleSecurity cRoleSecurity = new CRoleSecurity();
			cRoleSecurity.setId(rs.getInt("id"));
			cRoleSecurity.setRoleId(rs.getInt("role_id"));
			cRoleSecurity.setSecurityId(rs.getInt("security_id"));
			return cRoleSecurity; 
        }  
          
    }
}
