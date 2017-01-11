package com.honglinktech.zbgj.dao.self;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.FormatBean;
/**
 *只适合于查询
 */
@Service
public class FormatDao extends BaseDao<FormatBean> {

	/**
	 * APP通过商品ID获取有效活动
	 * @return
	 */
	public List<FormatBean> findFormatByGoodsId(int goodsId) {
		
		StringBuilder sql = new StringBuilder("select id, name, need_price FROM t_format  ");
		sql.append(" where delete_flag=0 AND goods_id = "+goodsId);
		sql.append(" ORDER BY sort is null,sort ASC ");
		System.out.println("findFormatByGoodsId:"+sql);
		return find(sql.toString());
	}
	
	public Object[] getDBMapping(String filedName){
		for(FormatBean.DBMaping d:FormatBean.DBMaping.values()){
			if(d.toString().equals(filedName)){
				FormatBean.DBMaping dbMaping = FormatBean.DBMaping.valueOf(filedName);
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
	protected RowMapper<FormatBean> getRowMapper() {
		return new FormatBean.FormatBeanRowMapper();
	}

}
