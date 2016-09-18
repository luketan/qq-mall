package com.honglinktech.zbgj.dao.self;

import org.springframework.stereotype.Service;

import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.TUserSessionDao;
import com.honglinktech.zbgj.entity.TUserSession;
/**
 *
 */
@Service
public class UserSessionDao extends TUserSessionDao {
	
	public Response<String> loginout(Integer id) throws BaseException {
		TUserSession us = new TUserSession();
		us.setUserId(id);
		int result = delete(us);
		if(result>0){
			return Result.success();
		}else{
			return Result.fail(ExceptionEnum.USER_LOGINOUT_ERROR,String.valueOf(id));
		}
	}
	
}
