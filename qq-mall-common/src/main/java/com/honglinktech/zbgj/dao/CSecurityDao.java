package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.CSecurity;
/**
*系统权限表Dao
**/
@Component
public class CSecurityDao extends BaseDao<CSecurity>{
	
	public Object[] getDBMapping(String filedName){
		for(CSecurity.DBMaping d:CSecurity.DBMaping.values()){
			if(d.toString().equals(filedName)){
				CSecurity.DBMaping dbMaping = CSecurity.DBMaping.valueOf(filedName);
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
	protected RowMapper<CSecurity> getRowMapper() {
		return new CSecurity.CSecurityRowMapper();
	}
}
