package com.honglinktech.zbgj.dao.self;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.GoodsTypeBean;
import com.honglinktech.zbgj.bean.GoodsTypeBean.GoodsTypeBeanRowMapper;
import com.honglinktech.zbgj.entity.CAdmin;
/**
 *只适合于查询
 */
@Service
public class GoodsTypeBeanDao extends BaseDao<GoodsTypeBean> {

	public GoodsTypeBean findGoodsBeanTypeById(int id) {
		StringBuilder sql = new StringBuilder("SELECT gt.id,gt.name,gt.ico,gt.img,gt.search,gt.summary FROM t_goods_type gt ");
		  sql.append(" WHERE gt.id= "+id);
		  List<GoodsTypeBean> goodsBeans = find(sql.toString());
		  return goodsBeans!=null && goodsBeans.size()>0?goodsBeans.get(0):null;
	}
	
	public Object[] getDBMapping(String filedName){
		for(CAdmin.DBMaping d:CAdmin.DBMaping.values()){
			if(d.toString().equals(filedName)){
				GoodsTypeBean.DBMaping dbMaping = GoodsTypeBean.DBMaping.valueOf(filedName);
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
	protected GoodsTypeBeanRowMapper getRowMapper() {
		return new GoodsTypeBean.GoodsTypeBeanRowMapper();
	}

}
