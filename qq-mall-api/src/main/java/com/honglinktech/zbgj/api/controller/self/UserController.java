package com.honglinktech.zbgj.api.controller.self;


import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.UserLoginBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.self.UserSessionDao;
import com.honglinktech.zbgj.entity.TUser;
import com.honglinktech.zbgj.service.self.UserService;

@RestController
@RequestMapping("/user/api")
public class UserController extends BaseApiController {
	@Resource
	private UserService userService;
	
	@RequestMapping(value="login",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<UserLoginBean> login(@RequestBody TUser tuser) throws BaseException{
		
		Response<UserLoginBean> resp = userService.login(tuser.getAccount(),tuser.getPassword());

		return resp; 
	}
	
	@RequestMapping(value="loginout",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> loginout(@RequestHeader HttpHeaders headers) throws BaseException{
	        	
	        	
	    String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode)){
			Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR);
		}
		Response<String> resp = userService.loginout(Integer.valueOf(userCode));

		return resp; 
	}
	
	
}
