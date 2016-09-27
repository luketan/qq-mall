package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TPic;
/**
*商品图片Dao
**/
@Component
public class TPicDao extends BaseDao<TPic>{
	
	public Object[] getDBMapping(String filedName){
		for(TPic.DBMaping d:TPic.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TPic.DBMaping dbMaping = TPic.DBMaping.valueOf(filedName);
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
	protected RowMapper<TPic> getRowMapper() {
		return new TPic.TPicRowMapper();
	}
	
}
