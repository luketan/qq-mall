package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserAddress;
/**
*用户地址Dao
**/
@Component
public class TUserAddressDao extends BaseDao<TUserAddress>{
	
	public Object[] getDBMapping(String filedName){
		for(TUserAddress.DBMaping d:TUserAddress.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TUserAddress.DBMaping dbMaping = TUserAddress.DBMaping.valueOf(filedName);
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
	protected RowMapper<TUserAddress> getRowMapper() {
		return new TUserAddress.TUserAddressRowMapper();
	}
}
