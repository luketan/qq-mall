package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserSign;
/**
*用户的个性签名记录Dao
**/
@Component
public class TUserSignDao extends BaseDao<TUserSign>{
	
	public Object[] getDBMapping(String filedName){
		for(TUserSign.DBMaping d:TUserSign.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TUserSign.DBMaping dbMaping = TUserSign.DBMaping.valueOf(filedName);
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
	protected RowMapper<TUserSign> getRowMapper() {
		return new TUserSign.TUserSignRowMapper();
	}
	
}
