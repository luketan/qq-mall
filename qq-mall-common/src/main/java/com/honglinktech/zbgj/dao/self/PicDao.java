package com.honglinktech.zbgj.dao.self;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.PicBean;
import com.honglinktech.zbgj.entity.TPic;
/**
*商品图片Dao
**/
@Component
public class PicDao extends BaseDao<PicBean>{
	public List<PicBean> findBeanList(int objId ,int type){
		String sql = "SELECT id,url_type,pic_title,pic_url from t_pic where obj_id="+objId+" AND type="+type;
		return find(sql);
	}
	public Object[] getDBMapping(String filedName){
		for(TPic.DBMaping d:TPic.DBMaping.values()){
			if(d.toString().equals(filedName)){
				TPic.DBMaping dbMaping = TPic.DBMaping.valueOf(filedName);
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
	protected RowMapper<PicBean> getRowMapper() {
		return new PicBean.PicBeanRowMapper();
	}
	
}
