package com.honglinktech.zbgj.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;

/**
*用户角色关联表
**/
public class CAdminRole extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "用户ID",dbName = "admin_id",length = 10,allowNull=true)
	private Integer adminId=null;
	@FieldMeta(primaryKey = false,fieldName = "角色ID",dbName = "role_id",length = 10,allowNull=true)
	private Integer roleId=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CAdminRole(){
 	}
 	public CAdminRole(Integer id,Integer adminId,Integer roleId){
 		this.id = id;
		this.adminId = adminId;
		this.roleId = roleId;
		
 	}
 	
		/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/*用户ID*/
	public Integer getAdminId(){
		 return this.adminId; 
	}
	public void setAdminId(Integer adminId){
		  this.adminId = adminId; 
	}
	/*角色ID*/
	public Integer getRoleId(){
		 return this.roleId; 
	}
	public void setRoleId(Integer roleId){
		  this.roleId = roleId; 
	}

	
	public enum DBMaping{
		tableName("c_admin_role",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		adminId("admin_id",Types.INTEGER,false,false,true),
		roleId("role_id",Types.INTEGER,false,false,true);
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
	public static class CAdminRoleRowMapper implements RowMapper<CAdminRole> {  
        @Override  
        public CAdminRole mapRow(ResultSet rs, int rowNum) throws SQLException {  

			CAdminRole cAdminRole = new CAdminRole();
			cAdminRole.setId(rs.getInt("id"));
			cAdminRole.setAdminId(rs.getInt("admin_id"));
			cAdminRole.setRoleId(rs.getInt("role_id"));
			return cAdminRole; 
        }  
          
    }
}
