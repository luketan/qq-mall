package com.honglinktech.zbgj.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseEntity;
import com.honglinktech.zbgj.annotation.FieldMeta;
import java.io.Serializable;

/**
*
**/
public class TSenWords extends BaseEntity implements Serializable{

	@FieldMeta(primaryKey = true,fieldName = "",dbName = "id",length = 10,allowNull=false)
	private Integer id=null;
	@FieldMeta(primaryKey = false,fieldName = "",dbName = "word",length = 25,allowNull=false)
	private String word=null;
	@FieldMeta(primaryKey = false,fieldName = "1政治类，2",dbName = "type",length = 10,allowNull=true)
	private Integer type=null;
	@FieldMeta(primaryKey = false,fieldName = "状态(1可用)",dbName = "status",length = 10,allowNull=true)
	private Integer status=null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TSenWords(){
 	}
 	public TSenWords(Integer id,String word,Integer type,Integer status){
 		this.id = id;
		this.word = word;
		this.type = type;
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
	public String getWord(){
		 return this.word; 
	}
	public void setWord(String word){
		  this.word = word; 
	}
	/*1政治类，2*/
	public Integer getType(){
		 return this.type; 
	}
	public void setType(Integer type){
		  this.type = type; 
	}
	/*状态(1可用)*/
	public Integer getStatus(){
		 return this.status; 
	}
	public void setStatus(Integer status){
		  this.status = status; 
	}

	
	public enum DBMaping{
		tableName("t_sen_words",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		word("word",Types.VARCHAR,false,false,false),
		type("type",Types.INTEGER,false,false,true),
		status("status",Types.INTEGER,false,false,true);
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
	public static class TSenWordsRowMapper implements RowMapper<TSenWords> {  
        @Override  
        public TSenWords mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TSenWords tSenWords = new TSenWords();
			tSenWords.setId(rs.getInt("id"));
			tSenWords.setWord(rs.getString("word"));
			tSenWords.setType(rs.getInt("type"));
			tSenWords.setStatus(rs.getInt("status"));
			return tSenWords; 
        }  
          
    }
}
