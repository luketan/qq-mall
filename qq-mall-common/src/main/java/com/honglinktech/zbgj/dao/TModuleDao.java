package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TModule;
/**
*api端模块管理Dao
**/
@Component
public class TModuleDao extends BaseDao<TModule>{
	
	public Object[] getDBMapping(String filedName){
		for(TModule.DBMaping d:TModule.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TModule.DBMaping dbMaping = TModule.DBMaping.valueOf(filedName);
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
	protected RowMapper<TModule> getRowMapper() {
		return new TModule.TModuleRowMapper();
	}
}
