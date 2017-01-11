package com.honglinktech.zbgj.dao.self;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.ActivityBean;
import com.honglinktech.zbgj.entity.TGActivity;
/**
 *只适合于查询
 */
@Service
public class ActivityDao extends BaseDao<ActivityBean> {

	/**
	 * APP通过商品ID获取有效活动
	 * @return
	 */
	public List<ActivityBean> findActivityByGoodsId(int goodsId) {
		
		StringBuilder sql = new StringBuilder("select act.id,act.name,act.type,act.args,act.detail,act.max,act.value,act.url from t_goods_activity ga join t_g_activity act on ga.activity_id = act.id ");
		sql.append(" where act.status=1 AND ((act.available = 1 AND act.start_time<=NOW() AND act.end_time>=NOW()) OR act.available = 0) AND ga.goods_id = "+goodsId);
		System.out.println("findActivityByGoodsId:"+sql);
		return find(sql.toString());
	}
	/**
	 * APP通过商品ID获取有效活动 (去重复)
	 * @return
	 */
	public List<ActivityBean> findActivityByGoodsId(List<Integer> goodsIds) {
		if(goodsIds==null || goodsIds.size() == 0){
			return new ArrayList<ActivityBean>();
		}
		StringBuilder sql = new StringBuilder("select DISTINCT act.id,act.name,act.type,act.args,act.detail,act.max,act.value,act.url ");
									sql.append(" from t_goods_activity ga join t_g_activity act on ga.activity_id = act.id ");
									sql.append(" where act.status=1 AND ((act.available = 1 AND act.start_time<=NOW() AND act.end_time>=NOW()) OR act.available = 0) ");
									sql.append(" AND ga.goods_id in (");
									for(int i=0;i<goodsIds.size();i++){
										if((goodsIds.size()-1)==i){
											sql.append(goodsIds.get(i) + " ");
										}else{
											sql.append(goodsIds.get(i) + ", ");
										}
									}
									sql.append(" )");
									
		System.out.println("findActivityByGoodsIdByList:"+sql);
		return find(sql.toString());
	}
	
	public Object[] getDBMapping(String filedName){
		for(TGActivity.DBMaping d:TGActivity.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TGActivity.DBMaping dbMaping = TGActivity.DBMaping.valueOf(filedName);
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
	protected RowMapper<ActivityBean> getRowMapper() {
		return new ActivityBean.ActivityBeanRowMapper();
	}

}
