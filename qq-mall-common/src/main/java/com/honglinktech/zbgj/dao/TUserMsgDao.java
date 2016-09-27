package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserMsg;
/**
*用户聊天记录，用户id分表 注意分表Dao
**/
@Component
public class TUserMsgDao extends BaseDao<TUserMsg>{
	
	public Object[] getDBMapping(String filedName){
		for(TUserMsg.DBMaping d:TUserMsg.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TUserMsg.DBMaping dbMaping = TUserMsg.DBMaping.valueOf(filedName);
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
	protected RowMapper<TUserMsg> getRowMapper() {
		return new TUserMsg.TUserMsgRowMapper();
	}
	
}
