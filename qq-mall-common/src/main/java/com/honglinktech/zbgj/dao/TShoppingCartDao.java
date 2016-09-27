package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TShoppingCart;
/**
*Dao
**/
@Component
public class TShoppingCartDao extends BaseDao<TShoppingCart>{
	
	public Object[] getDBMapping(String filedName){
		for(TShoppingCart.DBMaping d:TShoppingCart.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TShoppingCart.DBMaping dbMaping = TShoppingCart.DBMaping.valueOf(filedName);
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
	protected RowMapper<TShoppingCart> getRowMapper() {
		return new TShoppingCart.TShoppingCartRowMapper();
	}
	
}
