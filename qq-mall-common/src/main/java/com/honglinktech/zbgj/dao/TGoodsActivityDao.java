package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGoodsActivity;
/**
*商品活动Dao
**/
@Component
public class TGoodsActivityDao extends BaseDao<TGoodsActivity>{
	
	public Object[] getDBMapping(String filedName){
		for(TGoodsActivity.DBMaping d:TGoodsActivity.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TGoodsActivity.DBMaping dbMaping = TGoodsActivity.DBMaping.valueOf(filedName);
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
	protected RowMapper<TGoodsActivity> getRowMapper() {
		return new TGoodsActivity.TGoodsActivityRowMapper();
	}
	
}
