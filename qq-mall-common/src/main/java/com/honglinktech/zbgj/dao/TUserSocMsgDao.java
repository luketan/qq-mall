package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserSocMsg;
/**
*用户社区消息Dao
**/
@Component
public class TUserSocMsgDao extends BaseDao<TUserSocMsg>{
	
	public Object[] getDBMapping(String filedName){
		for(TUserSocMsg.DBMaping d:TUserSocMsg.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TUserSocMsg.DBMaping dbMaping = TUserSocMsg.DBMaping.valueOf(filedName);
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
	protected RowMapper<TUserSocMsg> getRowMapper() {
		return new TUserSocMsg.TUserSocMsgRowMapper();
	}
	
}
