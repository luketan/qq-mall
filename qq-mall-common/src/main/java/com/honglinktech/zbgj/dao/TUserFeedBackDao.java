package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserFeedBack;
/**
*用户反馈和意见Dao
**/
@Component
public class TUserFeedBackDao extends BaseDao<TUserFeedBack>{
	
	public Object[] getDBMapping(String filedName){
		for(TUserFeedBack.DBMaping d:TUserFeedBack.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TUserFeedBack.DBMaping dbMaping = TUserFeedBack.DBMaping.valueOf(filedName);
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
	protected RowMapper<TUserFeedBack> getRowMapper() {
		return new TUserFeedBack.TUserFeedBackRowMapper();
	}
	
}