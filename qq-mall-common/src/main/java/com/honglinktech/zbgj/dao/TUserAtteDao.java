package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserAtte;
/**
*用户关注Dao
**/
@Component
public class TUserAtteDao extends BaseDao<TUserAtte>{
	
	public Object[] getDBMapping(String filedName){
		for(TUserAtte.DBMaping d:TUserAtte.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TUserAtte.DBMaping dbMaping = TUserAtte.DBMaping.valueOf(filedName);
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
	protected RowMapper<TUserAtte> getRowMapper() {
		return new TUserAtte.TUserAtteRowMapper();
	}
}
