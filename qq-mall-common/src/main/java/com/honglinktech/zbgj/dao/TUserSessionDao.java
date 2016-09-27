package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserSession;
/**
*用户回话信息Dao
**/
public class TUserSessionDao extends BaseDao<TUserSession>{
	
	public Object[] getDBMapping(String filedName){
		for(TUserSession.DBMaping d:TUserSession.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TUserSession.DBMaping dbMaping = TUserSession.DBMaping.valueOf(filedName);
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
	protected RowMapper<TUserSession> getRowMapper() {
		return new TUserSession.TUserSessionRowMapper();
	}
	
}
