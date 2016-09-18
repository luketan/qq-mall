package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserKeep;
/**
*用户的收藏Dao
**/
@Component
public class TUserKeepDao extends BaseDao<TUserKeep>{
	
	public Object[] getDBMapping(String filedName){
		for(TUserKeep.DBMaping d:TUserKeep.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TUserKeep.DBMaping dbMaping = TUserKeep.DBMaping.valueOf(filedName);
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
	protected RowMapper<TUserKeep> getRowMapper() {
		return new TUserKeep.TUserKeepRowMapper();
	}
}
