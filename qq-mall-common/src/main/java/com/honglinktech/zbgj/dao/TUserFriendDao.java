package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TUserFriend;
/**
*用户的朋友Dao
**/
@Component
public class TUserFriendDao extends BaseDao<TUserFriend>{
	
	public Object[] getDBMapping(String filedName){
		for(TUserFriend.DBMaping d:TUserFriend.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TUserFriend.DBMaping dbMaping = TUserFriend.DBMaping.valueOf(filedName);
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
	protected RowMapper<TUserFriend> getRowMapper() {
		return new TUserFriend.TUserFriendRowMapper();
	}
	
}
