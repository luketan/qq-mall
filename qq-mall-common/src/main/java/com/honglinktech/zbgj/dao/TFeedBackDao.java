package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TFeedBack;
/**
*用户反馈表Dao
**/
@Component
public class TFeedBackDao extends BaseDao<TFeedBack>{
	
	public Object[] getDBMapping(String filedName){
		for(TFeedBack.DBMaping d:TFeedBack.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TFeedBack.DBMaping dbMaping = TFeedBack.DBMaping.valueOf(filedName);
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
	protected RowMapper<TFeedBack> getRowMapper() {
		return new TFeedBack.TFeedBackRowMapper();
	}
	
}
