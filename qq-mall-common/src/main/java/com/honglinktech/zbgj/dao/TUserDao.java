package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUser;
/**
*Dao
**/
@Component
public class TUserDao extends BaseDao<TUser>{
	
	public Object[] getDBMapping(String filedName){
		for(TUser.DBMaping d:TUser.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TUser.DBMaping dbMaping = TUser.DBMaping.valueOf(filedName);
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
	protected RowMapper<TUser> getRowMapper() {
		return new TUser.TUserRowMapper();
	}
	
}
