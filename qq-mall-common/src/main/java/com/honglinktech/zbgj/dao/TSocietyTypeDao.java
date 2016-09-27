package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietyType;
/**
*社区类型Dao
**/
@Component
public class TSocietyTypeDao extends BaseDao<TSocietyType>{
	
	public Object[] getDBMapping(String filedName){
		for(TSocietyType.DBMaping d:TSocietyType.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TSocietyType.DBMaping dbMaping = TSocietyType.DBMaping.valueOf(filedName);
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
	protected RowMapper<TSocietyType> getRowMapper() {
		return new TSocietyType.TSocietyTypeRowMapper();
	}
	
}
