package com.honglinktech.zbgj.dao.self;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.bean.PaymentBean;
/**
*支付方式
**/
@Component
public class PaymentDao extends BaseDao<PaymentBean>{
	public List<PaymentBean> findBeanList(int userId){
		String sql = "SELECT p.*, IF(pu.id>0, true, false) AS checked FROM t_payment p LEFT JOIN t_payment_user pu ON(p.id = pu.payment_id AND pu.user_id = "+userId+") WHERE p.delete_flag = 0";
		return find(sql);
	}
	public PaymentBean findBeanById(int id){
		String sql = "SELECT p.*, IF(pu.id>0, true, false) AS checked FROM t_payment p LEFT JOIN t_payment_user pu ON(p.id = pu.payment_id) WHERE p.delete_flag = 0 AND p.id = "+id;
		List<PaymentBean> paymentBeanList = find(sql);
		return paymentBeanList!=null&&paymentBeanList.size()>0?paymentBeanList.get(0):null;
	}
	public Object[] getDBMapping(String filedName){
		for(PaymentBean.DBMaping d:PaymentBean.DBMaping.values()){
			if(d.toString().equals(filedName)){
				PaymentBean.DBMaping dbMaping = PaymentBean.DBMaping.valueOf(filedName);
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
	protected RowMapper<PaymentBean> getRowMapper() {
		return new PaymentBean.PaymentBeanRowMapper();
	}
	
}
