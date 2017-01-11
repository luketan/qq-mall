package com.honglinktech.zbgj.dao.self;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.SocietyDisDisBean;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.entity.TSocietyDis;
/**
 */
@Service
public class SocietyDisDisDao extends BaseDao<SocietyDisDisBean> {

	public List<SocietyDisDisBean> findSocietyDisDis(int societyDisId) {
		StringBuilder sql = new StringBuilder("SELECT sdd.*,u.nick_name AS nickName,replyUser.nick_name AS replyUserName ");
		sql.append(" FROM t_society_dis_dis sdd LEFT JOIN t_user u ON(sdd.user_id = u.id) LEFT JOIN t_user replyUser on(sdd.reply_user_id = replyUser.id)");
		sql.append(" WHERE sdd.status="+Constants.SOCIETY_DIS_STATUS_NORMAL);
		sql.append(" AND sdd.society_dis_id="+societyDisId);
		System.out.println("findSocietyDisDis:"+sql);
		List<SocietyDisDisBean> societyDisBeanList = find(sql.toString(), new SocietyDisDisBean.SocietyDisDisRowMapper());
		return societyDisBeanList;
	}
	
	public Object[] getDBMapping(String filedName){
		for(TSocietyDis.DBMaping d:TSocietyDis.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TSocietyDis.DBMaping dbMaping = TSocietyDis.DBMaping.valueOf(filedName);
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
	protected RowMapper<SocietyDisDisBean> getRowMapper() {
		return new SocietyDisDisBean.SocietyDisDisRowMapper();
	}

}
