package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TCoupon;
/**
*优惠券Dao
**/
@Component
public class TCouponDao extends BaseDao<TCoupon>{
	
	public Object[] getDBMapping(String filedName){
		for(TCoupon.DBMaping d:TCoupon.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TCoupon.DBMaping dbMaping = TCoupon.DBMaping.valueOf(filedName);
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
	protected RowMapper<TCoupon> getRowMapper() {
		return new TCoupon.TCouponRowMapper();
	}
}
