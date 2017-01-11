package com.honglinktech.zbgj.dao.self;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.SocietyDisBean;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.entity.TSocietyDis;
/**
 */
@Service
public class SocietyDisDao extends BaseDao<SocietyDisBean> {

	public List<SocietyDisBean> findSocietyDis(int socNoteId, Integer userId, int index,
			int size, Map<String, Object> whereMap, Map<String, Object> orderMap) {
		StringBuilder sql = new StringBuilder("SELECT sd.*,u.nick_name AS nickName, u.head AS head ");
		if(userId != null && userId > 0){//是否需要查询是否已经关注
			sql.append(" ,sdl.user_id AS likeUserId");
		}else{
			sql.append(" ,0 AS likeUserId");
		}
		sql.append(" FROM t_society_dis sd LEFT JOIN t_user u ON(sd.user_id = u.id)");
		if(userId != null && userId > 0){//是否需要查询是否已经关注
			sql.append(" LEFT JOIN t_society_dis_like sdl ON(sdl.user_id = "+userId+" AND sd.id = sdl.id) ");
		}
		sql.append(" WHERE sd.society_note_id = "+socNoteId+" AND sd.status="+Constants.SOCIETY_DIS_STATUS_NORMAL);
		if(whereMap.containsKey("currUserId")){
			sql.append(" AND sd.user_id = "+whereMap.get("currUserId"));
		}
		if(orderMap.containsKey("createTime")){
			sql.append(" ORDER BY create_time DESC");
		}
		sql.append(" limit "+(index-1)*size+","+size);
		System.out.println("findSocietyDis:"+sql);
		List<SocietyDisBean> societyDisBeanList = find(sql.toString(), new SocietyDisBean.SocietyDisBeanRowMapper());
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
	protected RowMapper<SocietyDisBean> getRowMapper() {
		return new SocietyDisBean.SocietyDisBeanRowMapper();
	}

}
