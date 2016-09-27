package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TPostDetail;
/**
*快递单详情表Dao
**/
@Component
public class TPostDetailDao extends BaseDao<TPostDetail>{
	
	public Object[] getDBMapping(String filedName){
		for(TPostDetail.DBMaping d:TPostDetail.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TPostDetail.DBMaping dbMaping = TPostDetail.DBMaping.valueOf(filedName);
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
	protected RowMapper<TPostDetail> getRowMapper() {
		return new TPostDetail.TPostDetailRowMapper();
	}
	
}
