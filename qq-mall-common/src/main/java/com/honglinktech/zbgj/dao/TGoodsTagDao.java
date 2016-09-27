package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGoodsTag;
/**
*商品活动Dao
**/
@Component
public class TGoodsTagDao extends BaseDao<TGoodsTag>{
	
	public Object[] getDBMapping(String filedName){
		for(TGoodsTag.DBMaping d:TGoodsTag.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TGoodsTag.DBMaping dbMaping = TGoodsTag.DBMaping.valueOf(filedName);
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
	protected RowMapper<TGoodsTag> getRowMapper() {
		return new TGoodsTag.TGoodsTagRowMapper();
	}
	
}
