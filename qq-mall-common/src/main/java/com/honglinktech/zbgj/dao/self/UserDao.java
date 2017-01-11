package com.honglinktech.zbgj.dao.self;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.honglinktech.zbgj.base.BaseDao;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.UserBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.TUser;
/**
 *
 */
@Service
public class UserDao extends BaseDao<UserBean> {

	public Response<UserBean> login(String account, String password) {
		List<UserBean> users = findByWhere("Where ("+TUser.DBMaping.account.getDbName()+"='"+account+"' OR "+TUser.DBMaping.email.getDbName()+"='"+account+"' OR "+TUser.DBMaping.phone+"='"+account+"') AND "
				+TUser.DBMaping.password.getDbName()+" = '" +password+"'");
		
		if(users == null || users.size() == 0){
			return Result.fail(ExceptionEnum.USER_PASSWORD_ERROR.getRetCode(),ExceptionEnum.USER_PASSWORD_ERROR.getRetString());
		}
		if(users.size()>1){
			return Result.fail(ExceptionEnum.USER_MUCH_ERROR.getRetCode(),ExceptionEnum.USER_MUCH_ERROR.getRetString(account, password));
		}
		return Result.resultSet(users.get(0));
	}
	
	public List<UserBean> findAtteUserByNum(Integer userId, int index, int size) {
		int start = (index-1)*size <= 0 ? 0 : (index-1)*size;
		
		StringBuilder sql =  new StringBuilder(" SELECT * FROM t_user ");
					sql.append(" WHERE id IN (SELECT atte_user_id  From t_user_atte ua ");
					if(userId!=null && userId>0){
						sql.append(" WHERE ua.atte_user_id <> "+userId+" AND ua.atte_user_id NOT IN(SELECT atte_user_id FROM t_user_atte WHERE user_id = "+userId+")");
					}
					sql.append(" GROUP BY ua.atte_user_id ORDER BY sum(1) DESC) ");
					sql.append(" LIMIT "+start+","+size);
					System.out.println("findAtteUserByNum:"+sql);
		return find(sql.toString());
	}
	
	public List<UserBean> findFriendUserByNum(Integer userId, int index, int size) {
		int start = (index-1)*size <= 0 ? 0 : (index-1)*size;
		StringBuilder sql =  new StringBuilder(" SELECT * FROM t_user");
		sql.append(" WHERE id IN (SELECT friend_user_id  From t_user_friend uf ");
		if(userId!=null && userId>0){
			sql.append(" WHERE uf.friend_user_id <> "+userId+" AND uf.friend_user_id NOT IN(SELECT atte_user_id FROM t_user_atte WHERE user_id = "+userId+")");
		}
		sql.append(" GROUP BY uf.friend_user_id ORDER BY sum(1) DESC) ");
		sql.append(" LIMIT "+start+","+size);
		System.out.println("findFriendUserByNum:"+sql);
		return find(sql.toString());
	}
	
	@Resource
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		super.jdbcTemplate = jdbcTemplate;
	}
	public JdbcTemplate jdbcTemplate(){
		return jdbcTemplate;
	}
	 
	@Override
	protected RowMapper<UserBean> getRowMapper() {
		return new UserBean.UserRowMapper();
	}

	public Object[] getDBMapping(String filedName){
		for(UserBean.DBMaping d:UserBean.DBMaping.values()){
			if(d.toString().equals(filedName)){
				UserBean.DBMaping dbMaping = UserBean.DBMaping.valueOf(filedName);
				Object[] values = {dbMaping.getDbName(),dbMaping.getDbType(),dbMaping.getPrimaryKey(),dbMaping.isAotuIn(),dbMaping.isAllowNull()};
				return values;
			}
		}
		return null;
	}

}
