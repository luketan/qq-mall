package com.honglinktech.zbgj.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TProblem;
/**
*活动Dao
**/
@Component
public class TProblemDao extends BaseDao<TProblem>{
	public enum DBMaping{
		tableName("t_problem",0,false,false,false),
		id("id",Types.INTEGER,true,true,false),
		goodsId("goods_id",Types.INTEGER,false,false,false),
		userId("user_id",Types.INTEGER,false,false,false),
		userName("user_name",Types.VARCHAR,false,false,true),
		question("question",Types.VARCHAR,false,false,true),
		answer("answer",Types.VARCHAR,false,false,true),
		adminId("admin_id",Types.INTEGER,false,false,true),
		adminName("admin_name",Types.VARCHAR,false,false,true),
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
	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		super.jdbcTemplate = jdbcTemplate;
	}
	public JdbcTemplate jdbcTemplate(){
		return jdbcTemplate;
	}
	
	public class TProblemRowMapper implements RowMapper<TProblem> {  
        @Override  
        public TProblem mapRow(ResultSet rs, int rowNum) throws SQLException {  

			TProblem tProblem = new TProblem();
			tProblem.setId(rs.getInt("id"));
			tProblem.setGoodsId(rs.getInt("goods_id"));
			tProblem.setUserId(rs.getInt("user_id"));
			tProblem.setUserName(rs.getString("user_name"));
			tProblem.setQuestion(rs.getString("question"));
			tProblem.setAnswer(rs.getString("answer"));
			tProblem.setAdminId(rs.getInt("admin_id"));
			tProblem.setAdminName(rs.getString("admin_name"));
			tProblem.setCreateTime(rs.getTimestamp("create_time"));
			tProblem.setUpdateTime(rs.getTimestamp("update_time"));
			return tProblem; 
        }  
          
    }  
	@Override
	protected RowMapper<TProblem> getRowMapper() {
		return new TProblemRowMapper();
	}
}
