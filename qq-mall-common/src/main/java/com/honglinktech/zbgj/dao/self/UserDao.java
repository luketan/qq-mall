package com.honglinktech.zbgj.dao.self;

import java.util.List;

import org.springframework.stereotype.Service;

import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.TUserDao;
import com.honglinktech.zbgj.entity.TUser;
/**
 *
 */
@Service("userDao")
public class UserDao extends TUserDao {

	public Response<TUser> login(String account, String password) {
		List<TUser> users = findByWhere("Where ("+TUser.DBMaping.account.getDbName()+"='"+account+"' OR "+TUser.DBMaping.email.getDbName()+"='"+account+"' OR "+TUser.DBMaping.phone+"='"+account+"') AND "
				
				+TUser.DBMaping.password.getDbName()+" = '" +password+"'");
		
		if(users == null || users.size() == 0){
			return Result.fail(ExceptionEnum.USER_PASSWORD_ERROR.getRetCode(),ExceptionEnum.USER_PASSWORD_ERROR.getRetString());
		}
		if(users.size()>1){
			return Result.fail(ExceptionEnum.USER_MUCH_ERROR.getRetCode(),ExceptionEnum.USER_MUCH_ERROR.getRetString(account, password));
		}
		return Result.resultSet(users.get(0));
	}
	
}
