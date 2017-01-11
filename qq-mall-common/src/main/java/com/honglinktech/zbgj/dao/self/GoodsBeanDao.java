package com.honglinktech.zbgj.dao.self;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.GoodsBean;
import com.honglinktech.zbgj.entity.TGoods;
/**
 *只适合于查询
 */
@Service
public class GoodsBeanDao extends BaseDao<GoodsBean> {

	/**
	 * 
	 * @param whereMap typeId,typeSubId,minPrice,maxPrice,orderBy|sort,
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsBean> findGoodsSearchBeansByMap(Map<String, String> whereMap) {
		
		StringBuilder sql = new StringBuilder("SELECT g.id,g.name,g.sub_name,g.mark_price,g.price,g.sales_num,g.img_url FROM t_goods g ");
					  sql.append(" WHERE g.status=1 ");
					  TGoods tgoods = new TGoods();
					  if(whereMap.containsKey("typeId")){
						  sql.append(" AND g.type_id = "+whereMap.get("typeId"));
					  }
					  if(whereMap.containsKey("typeSubId")){
						  sql.append(" AND g.type_sub_Id = "+whereMap.get("typeSubId"));
					  }
					  if(whereMap.containsKey("minPrice")){
						  sql.append(" AND g.price >= "+whereMap.get("minPrice"));
					  }
					  if(whereMap.containsKey("maxPrice")){
						  sql.append(" AND g.price <= "+whereMap.get("maxPrice"));
					  }
					  if(whereMap.containsKey("orderBy")){
						  sql.append(" ORDER BY g."+tgoods.getDBMapping(whereMap.get("orderBy").toString())[0]+" "+(whereMap.containsKey("sort")?whereMap.get("sort"):"ASC"));
					  }else{
						  sql.append(" ORDER BY g.sort is null,g.sort ASC");
					  }
		 			  if(whereMap.get("index") != null){
		 				  int index = Integer.valueOf(whereMap.get("index").toString());
		 				  index = (index<=0)?1:index;
		 				  int size = Integer.valueOf(whereMap.get("size").toString());
		 				  size = (size<=0)?10:size;
		 				  sql.append(" limit "+((index-1)*size)+","+size);
		 			  }
				System.out.println("findGoodsListBeansByMap1:"+sql);
				
		return findRowMapper(sql.toString(),new GoodsBean.GoodsSearchBeanRowMapper());
	}
	
	/**
	 * APP获取商品详情，包含是否收藏
	 * @param id
	 * @return
	 */
	public GoodsBean appFindById(int id,int userId) {
		
		StringBuilder sql = new StringBuilder("SELECT g.id,g.name,g.sub_name,g.mark_price,g.price,g.sales_num,g.img_url,g.detail,g.former_price ");
							if(userId > 0){
								sql.append(", IF(uk.id>0,true,false) as keep ");
							}else{
								sql.append(", 0 as keep ");
							}
							sql.append(" FROM t_goods g ");
							if(userId > 0){
								sql.append(" LEFT JOIN t_user_keep uk ON(g.id = uk.obj_id AND uk.type=1 AND uk.user_id="+userId+")");
							}
							sql.append(" WHERE g.status=1 and g.id="+id);
							System.out.println("findGoodsListBeansByMap1:"+sql);
							List<GoodsBean> goodsBeans = findRowMapper(sql.toString(),new GoodsBean.GoodsBeanRowMapper());
							GoodsBean goodsBean = null;
							if(goodsBeans!=null && goodsBeans.size()>0){
								goodsBean = goodsBeans.get(0);
							}
							
							return goodsBean;
	}

	
	
	public Object[] getDBMapping(String filedName){
		for(TGoods.DBMaping d:TGoods.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TGoods.DBMaping dbMaping = TGoods.DBMaping.valueOf(filedName);
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
	protected RowMapper<GoodsBean> getRowMapper() {
		return new GoodsBean.GoodsBeanRowMapper();
	}

}
