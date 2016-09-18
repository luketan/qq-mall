package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TOrderItem;
/**
*订单详情Dao
**/
@Component
public class TOrderItemDao extends BaseDao<TOrderItem>{
	
	public Object[] getDBMapping(String filedName){
		for(TOrderItem.DBMaping d:TOrderItem.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TOrderItem.DBMaping dbMaping = TOrderItem.DBMaping.valueOf(filedName);
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
	protected RowMapper<TOrderItem> getRowMapper() {
		return new TOrderItem.TOrderItemRowMapper();
	}
}
