package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.CRole;
/**
*系统角色表Dao
**/
@Component
public class CRoleDao extends BaseDao<CRole>{
	
	public Object[] getDBMapping(String filedName){
		for(CRole.DBMaping d:CRole.DBMaping.values()){
			if(d.toString().equals(filedName)){
				CRole.DBMaping dbMaping = CRole.DBMaping.valueOf(filedName);
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
	protected RowMapper<CRole> getRowMapper() {
		return new CRole.CRoleRowMapper();
	}
}
