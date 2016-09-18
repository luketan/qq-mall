package com.honglinktech.zbgj.dao;

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
	
	public Object[] getDBMapping(String filedName){
		for(TProblem.DBMaping d:TProblem.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TProblem.DBMaping dbMaping = TProblem.DBMaping.valueOf(filedName);
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
	protected RowMapper<TProblem> getRowMapper() {
		return new TProblem.TProblemRowMapper();
	}
}
