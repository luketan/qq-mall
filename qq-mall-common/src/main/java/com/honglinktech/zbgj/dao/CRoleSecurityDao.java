package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.CRoleSecurity;
/**
*角色权限关联表Dao
**/
@Component
public class CRoleSecurityDao extends BaseDao<CRoleSecurity>{
	
	public Object[] getDBMapping(String filedName){
		for(CRoleSecurity.DBMaping d:CRoleSecurity.DBMaping.values()){
			if(d.toString().equals(filedName)){
				CRoleSecurity.DBMaping dbMaping = CRoleSecurity.DBMaping.valueOf(filedName);
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
	protected RowMapper<CRoleSecurity> getRowMapper() {
		return new CRoleSecurity.CRoleSecurityRowMapper();
	}
	
}
