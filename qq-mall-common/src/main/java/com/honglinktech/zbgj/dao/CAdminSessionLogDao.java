package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.CAdminSessionLog;
/**
*登录日志表Dao
**/
@Component
public class CAdminSessionLogDao extends BaseDao<CAdminSessionLog>{
	
	public Object[] getDBMapping(String filedName){
		for(CAdminSessionLog.DBMaping d:CAdminSessionLog.DBMaping.values()){
			if(d.toString().equals(filedName)){
				CAdminSessionLog.DBMaping dbMaping = CAdminSessionLog.DBMaping.valueOf(filedName);
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
	protected RowMapper<CAdminSessionLog> getRowMapper() {
		return new CAdminSessionLog.CAdminSessionLogRowMapper();
	}
	
}
