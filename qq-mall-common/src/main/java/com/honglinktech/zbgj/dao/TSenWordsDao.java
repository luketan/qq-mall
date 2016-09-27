package com.honglinktech.zbgj.dao;

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
	
	public Object[] getDBMapping(String filedName){
		for(TSenWords.DBMaping d:TSenWords.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TSenWords.DBMaping dbMaping = TSenWords.DBMaping.valueOf(filedName);
				Object[] values = {dbMaping.getDbName(),dbMaping.getDbType(),dbMaping.getPrimaryKey(),dbMaping.isAotuIn(),dbMaping.isAllowNull()};
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
	 
	@Override
	protected RowMapper<TSenWords> getRowMapper() {
		return new TSenWords.TSenWordsRowMapper();
	}
	
}
