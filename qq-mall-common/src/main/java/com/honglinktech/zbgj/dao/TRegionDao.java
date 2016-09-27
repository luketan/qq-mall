package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TRegion;
/**
*Dao
**/
@Component
public class TRegionDao extends BaseDao<TRegion>{
	
	public Object[] getDBMapping(String filedName){
		for(TRegion.DBMaping d:TRegion.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TRegion.DBMaping dbMaping = TRegion.DBMaping.valueOf(filedName);
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
	protected RowMapper<TRegion> getRowMapper() {
		return new TRegion.TRegionRowMapper();
	}
	
}
