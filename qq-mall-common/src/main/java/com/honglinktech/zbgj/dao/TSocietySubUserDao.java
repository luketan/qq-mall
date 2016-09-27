package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietySubUser;
/**
*用户关注的主题Dao
**/
@Component
public class TSocietySubUserDao extends BaseDao<TSocietySubUser>{
	
	public Object[] getDBMapping(String filedName){
		for(TSocietySubUser.DBMaping d:TSocietySubUser.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TSocietySubUser.DBMaping dbMaping = TSocietySubUser.DBMaping.valueOf(filedName);
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
	protected RowMapper<TSocietySubUser> getRowMapper() {
		return new TSocietySubUser.TSocietySubUserRowMapper();
	}
	
}
