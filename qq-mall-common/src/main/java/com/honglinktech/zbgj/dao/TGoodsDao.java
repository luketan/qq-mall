package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGoods;
/**
*Dao
**/
@Component
public class TGoodsDao extends BaseDao<TGoods>{
	
	public Object[] getDBMapping(String filedName){
		for(TGoods.DBMaping d:TGoods.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TGoods.DBMaping dbMaping = TGoods.DBMaping.valueOf(filedName);
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
	protected RowMapper<TGoods> getRowMapper() {
		return new TGoods.TGoodsRowMapper();
	}
	
}
