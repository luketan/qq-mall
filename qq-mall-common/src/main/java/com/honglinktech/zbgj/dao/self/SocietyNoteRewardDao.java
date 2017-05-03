package com.honglinktech.zbgj.dao.self;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.SocietyNoteRewardBean;
import com.honglinktech.zbgj.entity.TSocietyNote;
/**
 */
@Service
public class SocietyNoteRewardDao extends BaseDao<SocietyNoteRewardBean> {

	/**
	 * 获取帖子列表
	 * @param userId
	 * @return
	 */
	public List<SocietyNoteRewardBean> findSocietyNoteReward(int socNoteId, int index, int size) {

		StringBuilder sql = new StringBuilder("SELECT snr.*, u.nick_name AS nickName, u.head, u.sex, u.level ");
		sql.append("FROM t_society_note_reward snr LEFT JOIN t_user u ON(snr.bus_user_id = u.id)");
		sql.append(" WHERE snr.society_note_id = "+socNoteId);
		if(index>0 && size>0){
			sql.append(" limit "+((index-1)*size)+", "+size);
		}
		System.out.println("findSocietyNoteById:"+sql);
		List<SocietyNoteRewardBean> societyNoteRewarBeanList = find(sql.toString(), new SocietyNoteRewardBean.SocietyNoteRewardRowMapper());
		
		return societyNoteRewarBeanList;
	
	}
	/**
	 * 获取帖子列表
	 * @param userId
	 * @return
	 */
	public int findSocietyNoteRewardCount(int socNoteId) {

		StringBuilder sql = new StringBuilder("SELECT count(1) FROM t_society_note_reward snr ");
		sql.append(" WHERE snr.society_note_id = "+socNoteId);
		System.out.println("findSocietyNoteById:"+sql);
		int socNoteRewardCount = findCount(sql.toString());
		
		return socNoteRewardCount;
	
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
	protected RowMapper<SocietyNoteRewardBean> getRowMapper() {
		return new SocietyNoteRewardBean.SocietyNoteRewardRowMapper();
	}

}
