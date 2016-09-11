package com.honglinktech.zbgj.service.self;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.self.UserDao;
import com.honglinktech.zbgj.entity.TUser;
import com.honglinktech.zbgj.service.TUserService;
import com.honglinktech.zbgj.utils.HashUtils;

@Component
public class UserService extends TUserService {

	@Resource
	private UserDao userDao;

	public Response<TUser> login(String account, String password) throws BaseException{

		if(StringUtils.isEmpty(account)){
			Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR.getRetCode(), "用户名不能为空！");
		}
		if(StringUtils.isEmpty(password)){
			Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR.getRetCode(), "密码不能为空！");
		}
		try {
			password = HashUtils.md5(password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BaseException(ExceptionEnum.COMMON_ERROE);
		}
		
		return userDao.login(account,password);
	}
}
