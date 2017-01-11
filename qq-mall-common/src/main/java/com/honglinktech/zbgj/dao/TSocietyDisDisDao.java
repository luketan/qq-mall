package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietyDisDis;
/**
*回帖内容，根据帖子id，分表 注意分表Dao
**/
@Component
public class TSocietyDisDisDao extends BaseDao<TSocietyDisDis>{
	
	public Object[] getDBMapping(String filedName){
		for(TSocietyDisDis.DBMaping d:TSocietyDisDis.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TSocietyDisDis.DBMaping dbMaping = TSocietyDisDis.DBMaping.valueOf(filedName);
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
	protected RowMapper<TSocietyDisDis> getRowMapper() {
		return new TSocietyDisDis.TSocietyDisDisRowMapper();
	}
	
}
