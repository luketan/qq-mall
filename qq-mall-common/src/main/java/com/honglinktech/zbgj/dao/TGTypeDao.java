package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGType;
/**
*商品类别表Dao
**/
@Component
public class TGTypeDao extends BaseDao<TGType>{
	
	public Object[] getDBMapping(String filedName){
		for(TGType.DBMaping d:TGType.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TGType.DBMaping dbMaping = TGType.DBMaping.valueOf(filedName);
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
	protected RowMapper<TGType> getRowMapper() {
		return new TGType.TGTypeRowMapper();
	}
	
}
