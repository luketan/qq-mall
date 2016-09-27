package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGBrand;
/**
*商品品牌Dao
**/
@Component
public class TGBrandDao extends BaseDao<TGBrand>{
	
	public Object[] getDBMapping(String filedName){
		for(TGBrand.DBMaping d:TGBrand.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TGBrand.DBMaping dbMaping = TGBrand.DBMaping.valueOf(filedName);
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
	protected RowMapper<TGBrand> getRowMapper() {
		return new TGBrand.TGBrandRowMapper();
	}
	
}
