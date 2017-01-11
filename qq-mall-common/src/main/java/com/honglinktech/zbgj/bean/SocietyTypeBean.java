package com.honglinktech.zbgj.bean;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;


/**
*社区类型
**/
public class SocietyTypeBean implements Serializable{

	private Integer id=null;
	private String name=null;
	private Integer sort=null;
	private Integer status=null;
	private Date createTime=null;
	private Date updateTime=null;
	
	private List<SocietySubBean> societySubBeanList;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SocietyTypeBean(){
 	}
	
 	public SocietyTypeBean(Integer id,String name,Integer sort,Integer status){
 		this.id = id;
		this.name = name;
		this.sort = sort;
		this.status = status;
		
 	}
	/**/
	public Integer getId(){
		 return this.id; 
	}
	public void setId(Integer id){
		  this.id = id; 
	}
	/**/
	public String getName(){
		 return this.name; 
	}
	public void setName(String name){
		  this.name = name; 
	}
	/**/
	public Integer getSort(){
		 return this.sort; 
	}
	public void setSort(Integer sort){
		  this.sort = sort; 
	}
	/*1正常*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
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
	
	public List<SocietySubBean> getSocietySubBeanList() {
		return societySubBeanList;
	}

	public void setSocietySubBeanList(List<SocietySubBean> societySubBeanList) {
		this.societySubBeanList = societySubBeanList;
	}




	public enum DBMaping{
		tableName("t_society_type",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		name("name",Types.VARCHAR,false,false,true),
		sort("sort",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true),
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
	public static class SocietyTypeBeanRowMapper implements RowMapper<SocietyTypeBean> {  
        @Override  
        public SocietyTypeBean mapRow(ResultSet rs, int rowNum) throws SQLException {  

			SocietyTypeBean societyType = new SocietyTypeBean();
			societyType.setId(rs.getInt("id"));
			societyType.setName(rs.getString("name"));
			societyType.setSort(rs.getInt("sort"));
			societyType.setStatus(rs.getInt("status"));
			societyType.setCreateTime(rs.getTimestamp("create_time"));
			societyType.setUpdateTime(rs.getTimestamp("update_time"));
			return societyType; 
        }  
          
    }
}
