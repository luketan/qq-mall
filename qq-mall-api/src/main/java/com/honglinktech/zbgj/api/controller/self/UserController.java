package com.honglinktech.zbgj.api.controller.self;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.bean.HomeBean;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.dao.TModuleDao;
import com.honglinktech.zbgj.entity.TModule;
import com.honglinktech.zbgj.entity.TUser;
import com.honglinktech.zbgj.service.self.UserService;

@RestController
@RequestMapping("/user/api")
public class UserController extends BaseApiController {
	@Resource
	private UserService userService;
	
	@RequestMapping(value="login",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<TUser> login(@RequestBody TUser tuser) throws BaseException{
		
		Response<TUser> resp = userService.login(tuser.getAccount(),tuser.getPassword());

		return resp; 
	}
	
	
}
