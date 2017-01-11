package com.honglinktech.zbgj.dao.self;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.FormatSubBean;
import com.honglinktech.zbgj.entity.TFormatSub;
import com.honglinktech.zbgj.entity.TGActivity;
/**
 *只适合于查询
 */
@Service
public class FormatSubDao extends BaseDao<FormatSubBean> {

	/**
	 * APP通过商品ID获取有效活动
	 * @return
	 */
	public List<FormatSubBean> findFormatSubByFormatId(int formatId) {
		
		StringBuilder sql = new StringBuilder("select id, `name`, price, vip_price, `select`, args FROM t_format_sub ");
		sql.append(" where format_id = "+formatId);//delete_flag=0 AND
		sql.append(" ORDER BY sort is null,sort ASC ");
		System.out.println("findFormatSubByFormatId:"+sql);
		return find(sql.toString());
	}
	
	/**
	 * APP通过购物车ID商品规格
	 * @return
	 */
	public List<FormatSubBean> findFormatSubByShoppingId(int shoppingId) {
		
		StringBuilder sql = new StringBuilder("SELECT fs.id,fs.name,fs.price,fs.vip_price,fs.args,fs.delete_flag,f.name AS format_name,f.need_price,f.delete_flag|fs.delete_flag AS delete_flag FROM t_shopping_cart_format scf LEFT JOIN t_format_sub fs ON(scf.format_sub_id = fs.id) LEFT JOIN t_format f ON(fs.format_id = f.id) ");
		sql.append(" WHERE scf.shopping_cart_id="+shoppingId);
		System.out.println("findFormatSubByShoppingId:"+sql);
		return find(sql.toString(),new FormatSubBean.FormatSubBeanForShoppingCartRowMapper());
	}
	/**
	 * APP直接购买
	 * @return
	 */
	public List<FormatSubBean> findFormatSubByIds(List<Integer> ids) {
		if(ids==null || ids.size()<=0){
			return new ArrayList<FormatSubBean>();
		}
		StringBuilder sql = new StringBuilder("SELECT fs.id,fs.name,fs.price,fs.vip_price,fs.args,f.name AS format_name,f.need_price,f.delete_flag|fs.delete_flag AS delete_flag FROM t_format_sub AS fs LEFT JOIN t_format AS f ON(fs.format_id = f.id) ");
		sql.append(" WHERE 1=1 and (");
		for(int i=0;i<ids.size();i++){
			if(i==(ids.size()-1)){
				sql.append(" fs.id = "+ids.get(i)+" ");
			}else{
				sql.append(" fs.id = "+ids.get(i)+" OR");
			}
		}
		sql.append(")");
		System.out.println("findFormatSubByShoppingId:"+sql);
		return find(sql.toString(),new FormatSubBean.FormatSubBeanForShoppingCartRowMapper());
	}
	
	
	public Object[] getDBMapping(String filedName){
		for(TFormatSub.DBMaping d:TFormatSub.DBMaping.values()){
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
	protected RowMapper<FormatSubBean> getRowMapper() {
		return new FormatSubBean.FormatSubBeanRowMapper();
	}

}
