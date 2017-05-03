package com.honglinktech.zbgj.dao.self;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.SocietyNoteBean;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.entity.TSocietyNote;
/**
 */
@Service
public class SocietyNoteDao extends BaseDao<SocietyNoteBean> {

	/**
	 * 获取帖子列表
	 * @param userId
	 * @return
	 */
	public List<SocietyNoteBean> findSocietyNotes(Integer userId, Integer start, Integer size, Map<String,Object> where) {
		StringBuilder sql = new StringBuilder("SELECT u.nick_name, u.head, u.level, u.sex, sn.* FROM t_society_note sn LEFT JOIN t_user u ON(sn.user_id = u.id) ");
		sql.append(" WHERE 1=1 AND sn.status= "+Constants.SOCIETY_NOTE_STATUS_NORMAL);
		if(where.containsKey("annIs")){//是否是查询公告
			if(!(boolean)where.get("annIs")){
				sql.append(" AND (ann_is = 0 OR ann_is is NULL)");
			}else{
				sql.append(" AND ann_is = 1");
			}
		}
		if(where.containsKey("atte") && (boolean)where.get("atte") 
				&& userId != null && userId > 0){//查询关注帖子
			sql.append(" AND sn.user_id IN(SELECT atte_user_id FROM t_user_atte WHERE user_id = "+userId+" )");
		}
		if(where.containsKey("friend") && (boolean)where.get("friend") 
				&& userId != null && userId > 0){//查询好友帖子
			sql.append(" AND sn.user_id IN(SELECT friend_user_id FROM t_user_friend WHERE user_id = "+userId+" )");
		}
		if(where.containsKey("subId")){//查询主题帖子
			sql.append(" AND sn.society_sub_id = "+where.get("subId"));
		}
		sql.append(" ORDER BY DATE_FORMAT(sn.create_time,'%Y%m%d') DESC, sn.top_is DESC, sn.gifts_is DESC, sn.rec_is DESC");
		sql.append(" LIMIT "+start+","+size);
		System.out.println("findSocietyNotes:"+sql);
		return find(sql.toString());
	}
	
	/**
	 * 查询帖子详情
	 * @param userId
	 * @return
	 */
	public SocietyNoteBean findSocietyNoteById(Integer userId, Integer Id, Boolean socSubInfo) {
		StringBuilder sql = new StringBuilder("SELECT u.nick_name, u.head, u.level, u.sex, sn.* ");
		if(userId != null && userId > 0){//是否需要查询是否已经关注
			sql.append(" ,snl.user_id AS likeUserId ");
		}else{
			sql.append(" ,0 AS likeUserId ");
		}
		if(socSubInfo!=null && socSubInfo){//是否需要查询帖子主题信息
			sql.append(" ,ss.name AS socSubName, ss.ico AS socSubIco, ss.ico_color AS socSubIcoColor");
		}else{
			sql.append(" ,sn.society_sub_name AS socSubName, '' AS socSubIco, '' AS socSubIcoColor");
		}
		sql.append(" FROM t_society_note sn LEFT JOIN t_user u ON(sn.user_id = u.id) ");
		if(userId != null && userId > 0){//是否需要查询是否已经关注
			sql.append(" LEFT JOIN t_society_note_like snl ON(snl.user_id = "+userId+" AND sn.id = snl.id) ");
		}
		if(socSubInfo!=null && socSubInfo){//是否需要查询帖子主题信息
			sql.append(" LEFT JOIN t_society_sub ss ON(sn.society_sub_id = ss.id) ");
		}
		sql.append(" WHERE 1=1 AND sn.status="+Constants.SOCIETY_NOTE_STATUS_NORMAL+" AND sn.id="+Id);
		System.out.println("findSocietyNoteById:"+sql);
		List<SocietyNoteBean> societyNoteBeanList = find(sql.toString(), new SocietyNoteBean.SocietyNoteInfoRowMapper());
		return societyNoteBeanList!=null&&societyNoteBeanList.size()>0?societyNoteBeanList.get(0):null;
	}
	
	/**
	 * 
	 * @param socNoteId
	 * @param like
	 * @return
	 */
	public int updateSocNoteLikeNum(int socNoteId, boolean like) {
		String sql = "update t_society_note set good_num=good_num+1 where id="+socNoteId;
		if(!like){
			sql = "update t_society_note set good_num=good_num-1 where id="+socNoteId;
		}
		return updateExecute(sql);
	}
	
	public Object[] getDBMapping(String filedName){
		for(TSocietyNote.DBMaping d:TSocietyNote.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TSocietyNote.DBMaping dbMaping = TSocietyNote.DBMaping.valueOf(filedName);
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
	protected RowMapper<SocietyNoteBean> getRowMapper() {
		return new SocietyNoteBean.SocietyNoteRowMapper();
	}

}
