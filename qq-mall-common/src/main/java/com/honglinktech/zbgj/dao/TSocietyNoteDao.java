package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TSocietyNote;
/**
*帖子Dao
**/
@Component
public class TSocietyNoteDao extends BaseDao<TSocietyNote>{
	
	public Object[] getDBMapping(String filedName){
		for(TSocietyNote.DBMaping d:TSocietyNote.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TSocietyNote.DBMaping dbMaping = TSocietyNote.DBMaping.valueOf(filedName);
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
	protected RowMapper<TSocietyNote> getRowMapper() {
		return new TSocietyNote.TSocietyNoteRowMapper();
	}
}
