package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGFormat;
/**
*商品规格Dao
**/
@Component
public class TGFormatDao extends BaseDao<TGFormat>{
	
	public Object[] getDBMapping(String filedName){
		for(TGFormat.DBMaping d:TGFormat.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TGFormat.DBMaping dbMaping = TGFormat.DBMaping.valueOf(filedName);
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
	protected RowMapper<TGFormat> getRowMapper() {
		return new TGFormat.TGFormatRowMapper();
	}
}
