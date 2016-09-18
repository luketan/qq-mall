package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TCouponUser;
/**
*Dao
**/
@Component
public class TCouponUserDao extends BaseDao<TCouponUser>{
	
	public Object[] getDBMapping(String filedName){
		for(TCouponUser.DBMaping d:TCouponUser.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TCouponUser.DBMaping dbMaping = TCouponUser.DBMaping.valueOf(filedName);
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
	protected RowMapper<TCouponUser> getRowMapper() {
		return new TCouponUser.TCouponUserRowMapper();
	}
}
