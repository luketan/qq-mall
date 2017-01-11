package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TPayment;
/**
*Dao
**/
@Component
public class TPaymentDao extends BaseDao<TPayment>{
	
	public Object[] getDBMapping(String filedName){
		for(TPayment.DBMaping d:TPayment.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TPayment.DBMaping dbMaping = TPayment.DBMaping.valueOf(filedName);
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
	protected RowMapper<TPayment> getRowMapper() {
		return new TPayment.TPaymentRowMapper();
	}
	
}
