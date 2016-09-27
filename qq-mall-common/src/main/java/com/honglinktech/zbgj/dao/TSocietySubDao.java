package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietySub;
/**
*Dao
**/
@Component
public class TSocietySubDao extends BaseDao<TSocietySub>{
	
	public Object[] getDBMapping(String filedName){
		for(TSocietySub.DBMaping d:TSocietySub.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TSocietySub.DBMaping dbMaping = TSocietySub.DBMaping.valueOf(filedName);
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
	protected RowMapper<TSocietySub> getRowMapper() {
		return new TSocietySub.TSocietySubRowMapper();
	}
	
}
