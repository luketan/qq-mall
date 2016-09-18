package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserRec;
/**
*注册用户推荐奖励Dao
**/
@Component
public class TUserRecDao extends BaseDao<TUserRec>{
	
	public Object[] getDBMapping(String filedName){
		for(TUserRec.DBMaping d:TUserRec.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TUserRec.DBMaping dbMaping = TUserRec.DBMaping.valueOf(filedName);
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
	protected RowMapper<TUserRec> getRowMapper() {
		return new TUserRec.TUserRecRowMapper();
	}
}
