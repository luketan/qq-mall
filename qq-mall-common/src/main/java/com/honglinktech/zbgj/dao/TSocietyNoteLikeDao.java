package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietyNoteLike;
/**
*帖子和评论点赞Dao
**/
@Component
public class TSocietyNoteLikeDao extends BaseDao<TSocietyNoteLike>{
	
	public Object[] getDBMapping(String filedName){
		for(TSocietyNoteLike.DBMaping d:TSocietyNoteLike.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TSocietyNoteLike.DBMaping dbMaping = TSocietyNoteLike.DBMaping.valueOf(filedName);
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
	protected RowMapper<TSocietyNoteLike> getRowMapper() {
		return new TSocietyNoteLike.TSocietyNoteLikeRowMapper();
	}
	
}
