package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TOrderActivity;
/**
*活动Dao
**/
@Component
public class TOrderActivityDao extends BaseDao<TOrderActivity>{
	
	public Object[] getDBMapping(String filedName){
		for(TOrderActivity.DBMaping d:TOrderActivity.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TOrderActivity.DBMaping dbMaping = TOrderActivity.DBMaping.valueOf(filedName);
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
	protected RowMapper<TOrderActivity> getRowMapper() {
		return new TOrderActivity.TOrderActivityRowMapper();
	}
	
}
