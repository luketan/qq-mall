package com.honglinktech.zbgj.dao.self;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.SocietySubBean;
/**
 */
@Service
public class SocietySubDao extends BaseDao<SocietySubBean> {
	/**
	 * 获取用户关注的主题
	 * @param userId
	 * @return
	 */
	public List<SocietySubBean> findUserSocietySubBean(int userId){
		StringBuilder sql = new StringBuilder("SELECT ss.* FROM t_society_sub_user ssu LEFT JOIN  t_society_sub ss ON(ssu.society_sub_id = ss.id) ");
					  sql.append(" WHERE ss.status=0 AND ssu.user_id="+userId);
		System.out.println("findUserSocietySubBean:"+sql);
		return find(sql.toString());
	}
	/**
	 * 获取推荐
	 * @param userId
	 * @return
	 */
	public List<SocietySubBean> findRecSocietySubBean(Integer userId) {
		StringBuilder sql = new StringBuilder("SELECT ss.* FROM t_society_sub ss ");
		if(userId != null && userId > 0){
			sql.append("WHERE id not in(SELECT ssu.society_sub_id FROM t_society_sub_user ssu WHERE ssu.user_id="+userId+") ");
		}
		System.out.println("findRecSocietySubBean:"+sql);
		return find(sql.toString());
	}
	
	/**
	 * 通过类型ID获取主题
	 * @param id
	 * @param userId
	 */
	public List<SocietySubBean> findSocSubBySocTypeId(Integer typeId, Integer userId) {
		StringBuilder sql = new StringBuilder(" SELECT ss.*");
		if(userId != null && userId > 0){
			sql.append(" ,ssu.user_id ");
		}else{
			sql.append(" ,NULL AS user_id");
		}
		sql.append(" FROM t_society_sub ss ");
		if(userId != null && userId > 0){
			sql.append(" LEFT JOIN t_society_sub_user ssu ON(ss.id = ssu.society_sub_id and ssu.user_id = 1)");
		}
		sql.append(" WHERE ss.type = "+typeId+" AND ss.status = 0");
		return find(sql.toString(), new SocietySubBean.SocietySubUserRowMapper());
	}
	
	public Object[] getDBMapping(String filedName){
		for(SocietySubBean.DBMaping d:SocietySubBean.DBMaping.values()){
			if(d.toString().equals(filedName)){
				SocietySubBean.DBMaping dbMaping = SocietySubBean.DBMaping.valueOf(filedName);
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
	protected RowMapper<SocietySubBean> getRowMapper() {
		return new SocietySubBean.SocietySubRowMapper();
	}

}
