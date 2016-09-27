package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TOrder;
/**
*订单信息Dao
**/
@Component
public class TOrderDao extends BaseDao<TOrder>{
	
	public Object[] getDBMapping(String filedName){
		for(TOrder.DBMaping d:TOrder.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TOrder.DBMaping dbMaping = TOrder.DBMaping.valueOf(filedName);
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
	protected RowMapper<TOrder> getRowMapper() {
		return new TOrder.TOrderRowMapper();
	}
	
}
