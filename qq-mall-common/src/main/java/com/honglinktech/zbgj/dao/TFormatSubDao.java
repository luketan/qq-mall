package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TFormatSub;
/**
*规格种类Dao
**/
@Component
public class TFormatSubDao extends BaseDao<TFormatSub>{
	
	public Object[] getDBMapping(String filedName){
		for(TFormatSub.DBMaping d:TFormatSub.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TFormatSub.DBMaping dbMaping = TFormatSub.DBMaping.valueOf(filedName);
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
	protected RowMapper<TFormatSub> getRowMapper() {
		return new TFormatSub.TFormatSubRowMapper();
	}
	
}
