package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TChangeLog;
/**
*变更变更日志[逗比、经验、vip]  注意分表Dao
**/
@Component
public class TChangeLogDao extends BaseDao<TChangeLog>{
	
	public Object[] getDBMapping(String filedName){
		for(TChangeLog.DBMaping d:TChangeLog.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TChangeLog.DBMaping dbMaping = TChangeLog.DBMaping.valueOf(filedName);
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
	protected RowMapper<TChangeLog> getRowMapper() {
		return new TChangeLog.TChangeLogRowMapper();
	}
	
}
