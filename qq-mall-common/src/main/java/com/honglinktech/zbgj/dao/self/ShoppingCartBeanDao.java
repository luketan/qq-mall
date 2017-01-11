package com.honglinktech.zbgj.dao.self;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.ShoppingCartBean;
import com.honglinktech.zbgj.entity.CAdmin;
import com.honglinktech.zbgj.entity.TShoppingCart;
/**
 *只适合于查询
 */
@Service
public class ShoppingCartBeanDao extends BaseDao<ShoppingCartBean> {

	public List<ShoppingCartBean> findShoppingBeansByUserId(Integer userId, int index, int size) {
		String sql = "SELECT sc.id, sc.user_id, sc.goods_id, g.name, g.img_url AS img_url, g.price, g.mark_price, sc.format_id, sc.format_name, sc.num, sc.checkbox FROM t_shopping_cart sc LEFT JOIN t_goods g ON(sc.goods_id = g.id) "
				+ " WHERE sc.user_id ="+userId
				+" ORDER BY sc.format_id"
				+ " limit "+((index-1)*size)+","+size;
		return find(sql);
	}
	
	public List<ShoppingCartBean> findShoppingCartBeansByMap(Map<String, Object> whereMap) {
		String sql = "SELECT sc.id, sc.user_id, sc.goods_id, g.name, g.img_url AS img_url, g.price, g.mark_price, sc.format_id, sc.format_name, sc.num, sc.checkbox FROM t_shopping_cart sc LEFT JOIN t_goods g ON(sc.goods_id = g.id) "
				+ " WHERE 1=1 ";
				if(whereMap.containsKey("userId")){
					sql += " AND sc.user_id ="+whereMap.get("userId");
				}
				if(whereMap.containsKey("checkbox")){
					sql += " AND sc.checkbox ="+whereMap.get("checkbox");
				}
				if(whereMap.containsKey("orderBy")){
					sql += " ORDER BY "+whereMap.get("checkbox");
				}
				if(whereMap.containsKey("index")&&whereMap.containsKey("size")){
					int start = (Integer.valueOf(whereMap.get("index").toString())-1)*Integer.valueOf(whereMap.get("size").toString());
					int size = Integer.valueOf(whereMap.get("size").toString());
					sql += " limit "+start+","+size;
				}
				System.out.println(sql);
		return find(sql);
	}
	public List<ShoppingCartBean> findShoppingCartBeansGoodsInfoByMap(Map<String, Object> whereMap) {
		String sql = "SELECT sc.id, sc.user_id, sc.goods_id, g.name, g.img_url AS img_url, g.price, g.mark_price, sc.format_id, sc.format_name, sc.num, sc.checkbox, gt.id AS goods_type_id, gt.name AS goods_type_name FROM t_shopping_cart sc LEFT JOIN t_goods g ON(sc.goods_id = g.id) LEFT JOIN t_goods_type gt ON(g.type_id = gt.id) "
				+ " WHERE 1=1 ";
				if(whereMap.containsKey("userId")){
					sql += " AND sc.user_id ="+whereMap.get("userId");
				}
				if(whereMap.containsKey("checkbox")){
					sql += " AND sc.checkbox ="+whereMap.get("checkbox");
				}
				if(whereMap.containsKey("orderBy")){
					sql += " ORDER BY "+whereMap.get("checkbox");
				}
				if(whereMap.containsKey("index")&&whereMap.containsKey("size")){
					int start = (Integer.valueOf(whereMap.get("index").toString())-1)*Integer.valueOf(whereMap.get("size").toString());
					int size = Integer.valueOf(whereMap.get("size").toString());
					sql += " limit "+start+","+size;
				}
				System.out.println(sql);
		return find(sql,new ShoppingCartBean.ShoppingCartBeanGoodsInfoRowMapper());
	}
	
	public int updateShoppingCart(Integer userId, TShoppingCart tshopping) {
		String sql = "UPDATE t_shopping_cart SET update_time = NOW()";
				if(tshopping.getNum()!=null){
					sql += ",num ="+tshopping.getNum();
				}
				if(tshopping.getCheckbox()!=null){
					sql += ",checkbox = "+tshopping.getCheckbox();
				}
				sql += " WHERE user_id ="+userId+" AND id = "+tshopping.getId();
		return updateExecute(sql);
	}
	
	public int updateShoppingCartChckboxAll(Integer userId, Boolean checkAll) {
		String sql = "UPDATE t_shopping_cart SET checkbox = "+checkAll
				   + " WHERE user_id ="+userId;
		return updateExecute(sql);
	}
	
	public Object[] getDBMapping(String filedName){
		for(CAdmin.DBMaping d:CAdmin.DBMaping.values()){
			if(d.toString().equals(filedName)){
				CAdmin.DBMaping dbMaping = CAdmin.DBMaping.valueOf(filedName);
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
	protected RowMapper<ShoppingCartBean> getRowMapper() {
		return new ShoppingCartBean.ShoppingCartBeanRowMapper();
	}

}
