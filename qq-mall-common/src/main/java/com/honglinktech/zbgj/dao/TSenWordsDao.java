package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSenWords;
/**
*Dao
**/
@Component
public class TSenWordsDao extends BaseDao<TSenWords>{
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
	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		super.jdbcTemplate = jdbcTemplate;
	}
	public JdbcTemplate jdbcTemplate(){
		return jdbcTemplate;
	}
	
	public class TSenWordsRowMapper implements RowMapper<TSenWords> {  
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
	@Override
	protected RowMapper<TSenWords> getRowMapper() {
		return new TSenWordsRowMapper();
	}
}
