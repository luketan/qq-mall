package com.honglinktech.zbgj.dao.self;

import java.util.List;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.TUserDao;
import com.honglinktech.zbgj.entity.TUser;
/**
 *
 */
@Component
public class UserDao extends TUserDao {

	public Response<TUser> login(String account, String password) {
		List<TUser> users = findByWhere("Where ("+DBMaping.account.getDbName()+"='"+account+"' OR "+DBMaping.email.getDbName()+"='"+account+"' OR "+DBMaping.phone+"='"+account+"') AND "
				
				+DBMaping.password.getDbName()+" = '" +password+"'");
		
		if(users == null || users.size() == 0){
			return Result.fail(ExceptionEnum.USER_PASSWORD_ERROR.getRetCode(),ExceptionEnum.USER_PASSWORD_ERROR.getRetString());
		}
		if(users.size()>1){
			return Result.fail(ExceptionEnum.USER_MUCH_ERROR.getRetCode(),ExceptionEnum.USER_MUCH_ERROR.getRetString(account, password));
		}
		return Result.resultSet(users.get(0));
	}
	
}
