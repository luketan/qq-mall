package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGStyle;
/**
*商品款式Dao
**/
@Component
public class TGStyleDao extends BaseDao<TGStyle>{
	
	public Object[] getDBMapping(String filedName){
		for(TGStyle.DBMaping d:TGStyle.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TGStyle.DBMaping dbMaping = TGStyle.DBMaping.valueOf(filedName);
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
	protected RowMapper<TGStyle> getRowMapper() {
		return new TGStyle.TGStyleRowMapper();
	}
}
