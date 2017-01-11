package com.honglinktech.zbgj.dao.self;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.SocietyTypeBean;
/**
 */
@Service
public class SocietyTypeDao extends BaseDao<SocietyTypeBean> {

	/**
	 * 获取所有类型
	 * @param userId
	 * @return
	 */
	public List<SocietyTypeBean> findAllSocTypes(Integer userId) {
		
		return find("SELECT * FROM t_society_type WHERE status = 0");
	}
	
	public Object[] getDBMapping(String filedName){
		for(SocietyTypeBean.DBMaping d:SocietyTypeBean.DBMaping.values()){
			if(d.toString().equals(filedName)){
				SocietyTypeBean.DBMaping dbMaping = SocietyTypeBean.DBMaping.valueOf(filedName);
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
	protected RowMapper<SocietyTypeBean> getRowMapper() {
		return new SocietyTypeBean.SocietyTypeBeanRowMapper();
	}

}
