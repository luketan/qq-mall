package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietyDisDisLike;
/**
*帖子和评论点赞Dao
**/
@Component
public class TSocietyDisDisLikeDao extends BaseDao<TSocietyDisDisLike>{
	
	public Object[] getDBMapping(String filedName){
		for(TSocietyDisDisLike.DBMaping d:TSocietyDisDisLike.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TSocietyDisDisLike.DBMaping dbMaping = TSocietyDisDisLike.DBMaping.valueOf(filedName);
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
	protected RowMapper<TSocietyDisDisLike> getRowMapper() {
		return new TSocietyDisDisLike.TSocietyDisDisLikeRowMapper();
	}
	
}
