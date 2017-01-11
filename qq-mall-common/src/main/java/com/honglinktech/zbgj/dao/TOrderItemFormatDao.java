package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TOrderItemFormat;
/**
*订单商品的规格Dao
**/
@Component
public class TOrderItemFormatDao extends BaseDao<TOrderItemFormat>{
	
	public Object[] getDBMapping(String filedName){
		for(TOrderItemFormat.DBMaping d:TOrderItemFormat.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TOrderItemFormat.DBMaping dbMaping = TOrderItemFormat.DBMaping.valueOf(filedName);
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
	protected RowMapper<TOrderItemFormat> getRowMapper() {
		return new TOrderItemFormat.TOrderItemFormatRowMapper();
	}
	
}
