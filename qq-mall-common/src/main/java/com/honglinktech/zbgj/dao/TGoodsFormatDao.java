package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGoodsFormat;
/**
*商品规格Dao
**/
@Component
public class TGoodsFormatDao extends BaseDao<TGoodsFormat>{
	
	public Object[] getDBMapping(String filedName){
		for(TGoodsFormat.DBMaping d:TGoodsFormat.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TGoodsFormat.DBMaping dbMaping = TGoodsFormat.DBMaping.valueOf(filedName);
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
	protected RowMapper<TGoodsFormat> getRowMapper() {
		return new TGoodsFormat.TGoodsFormatRowMapper();
	}
}
