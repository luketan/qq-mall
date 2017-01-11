package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietyDisLike;
/**
*帖子和评论点赞Dao
**/
@Component
public class TSocietyDisLikeDao extends BaseDao<TSocietyDisLike>{
	
	public Object[] getDBMapping(String filedName){
		for(TSocietyDisLike.DBMaping d:TSocietyDisLike.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TSocietyDisLike.DBMaping dbMaping = TSocietyDisLike.DBMaping.valueOf(filedName);
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
	protected RowMapper<TSocietyDisLike> getRowMapper() {
		return new TSocietyDisLike.TSocietyDisLikeRowMapper();
	}
	
}
