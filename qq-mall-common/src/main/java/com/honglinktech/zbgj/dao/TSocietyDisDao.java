package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietyDis;
/**
*回帖内容，根据帖子id，分表 注意分表Dao
**/
@Component
public class TSocietyDisDao extends BaseDao<TSocietyDis>{
	
	public Object[] getDBMapping(String filedName){
		for(TSocietyDis.DBMaping d:TSocietyDis.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TSocietyDis.DBMaping dbMaping = TSocietyDis.DBMaping.valueOf(filedName);
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
	protected RowMapper<TSocietyDis> getRowMapper() {
		return new TSocietyDis.TSocietyDisRowMapper();
	}
}
