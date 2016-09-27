package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.CAdmin;
/**
*管理员表Dao
**/
@Component
public class CAdminDao extends BaseDao<CAdmin>{
	
	public Object[] getDBMapping(String filedName){
		for(CAdmin.DBMaping d:CAdmin.DBMaping.values()){
			if(d.toString().equals(filedName)){
				CAdmin.DBMaping dbMaping = CAdmin.DBMaping.valueOf(filedName);
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
	protected RowMapper<CAdmin> getRowMapper() {
		return new CAdmin.CAdminRowMapper();
	}
	
}
