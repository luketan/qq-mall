package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.CAdminSession;
/**
*管理员回话信息Dao
**/
@Component
public class CAdminSessionDao extends BaseDao<CAdminSession>{
	
	public Object[] getDBMapping(String filedName){
		for(CAdminSession.DBMaping d:CAdminSession.DBMaping.values()){
			if(d.toString().equals(filedName)){
				CAdminSession.DBMaping dbMaping = CAdminSession.DBMaping.valueOf(filedName);
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
	protected RowMapper<CAdminSession> getRowMapper() {
		return new CAdminSession.CAdminSessionRowMapper();
	}
}
