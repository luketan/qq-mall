package com.honglinktech.zbgj.dao;

import javax.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.entity.TGoodsTypeSub;
/**
*商品款式Dao
**/
@Component
public class TGoodsTypeSubDao extends BaseDao<TGoodsTypeSub>{
	
	public Object[] getDBMapping(String filedName){
		for(TGoodsTypeSub.DBMaping d:TGoodsTypeSub.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TGoodsTypeSub.DBMaping dbMaping = TGoodsTypeSub.DBMaping.valueOf(filedName);
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
	protected RowMapper<TGoodsTypeSub> getRowMapper() {
		return new TGoodsTypeSub.TGoodsTypeSubRowMapper();
	}
	
}
