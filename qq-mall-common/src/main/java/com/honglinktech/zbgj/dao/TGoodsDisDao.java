package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGoodsDis;
/**
*商品评论表Dao
**/
@Component
public class TGoodsDisDao extends BaseDao<TGoodsDis>{
	
	public Object[] getDBMapping(String filedName){
		for(TGoodsDis.DBMaping d:TGoodsDis.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TGoodsDis.DBMaping dbMaping = TGoodsDis.DBMaping.valueOf(filedName);
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
	protected RowMapper<TGoodsDis> getRowMapper() {
		return new TGoodsDis.TGoodsDisRowMapper();
	}
}
