package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.CAdminRole;
/**
*用户角色关联表Dao
**/
@Component
public class CAdminRoleDao extends BaseDao<CAdminRole>{
	
	public Object[] getDBMapping(String filedName){
		for(CAdminRole.DBMaping d:CAdminRole.DBMaping.values()){
			if(d.toString().equals(filedName)){
				CAdminRole.DBMaping dbMaping = CAdminRole.DBMaping.valueOf(filedName);
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
	protected RowMapper<CAdminRole> getRowMapper() {
		return new CAdminRole.CAdminRoleRowMapper();
	}
	
}
