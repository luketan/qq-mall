package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TPostCompany;
/**
*快递公司表Dao
**/
@Component
public class TPostCompanyDao extends BaseDao<TPostCompany>{
	
	public Object[] getDBMapping(String filedName){
		for(TPostCompany.DBMaping d:TPostCompany.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TPostCompany.DBMaping dbMaping = TPostCompany.DBMaping.valueOf(filedName);
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
	protected RowMapper<TPostCompany> getRowMapper() {
		return new TPostCompany.TPostCompanyRowMapper();
	}
	
}
