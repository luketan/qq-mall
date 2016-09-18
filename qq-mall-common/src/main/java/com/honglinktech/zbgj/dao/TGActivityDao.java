package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGActivity;
/**
*活动Dao
**/
@Component
public class TGActivityDao extends BaseDao<TGActivity>{
	
	public Object[] getDBMapping(String filedName){
		for(TGActivity.DBMaping d:TGActivity.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TGActivity.DBMaping dbMaping = TGActivity.DBMaping.valueOf(filedName);
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
	protected RowMapper<TGActivity> getRowMapper() {
		return new TGActivity.TGActivityRowMapper();
	}
}
