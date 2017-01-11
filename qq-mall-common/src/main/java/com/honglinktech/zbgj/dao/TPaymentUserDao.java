package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TPaymentUser;
/**
*用户默认支付方式Dao
**/
@Component
public class TPaymentUserDao extends BaseDao<TPaymentUser>{
	
	public Object[] getDBMapping(String filedName){
		for(TPaymentUser.DBMaping d:TPaymentUser.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TPaymentUser.DBMaping dbMaping = TPaymentUser.DBMaping.valueOf(filedName);
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
	protected RowMapper<TPaymentUser> getRowMapper() {
		return new TPaymentUser.TPaymentUserRowMapper();
	}
	
}
