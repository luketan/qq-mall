package com.honglinktech.zbgj.api.controller.self;


import java.util.List;
import java.util.Map;

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
import com.honglinktech.zbgj.entity.TUser;
import com.honglinktech.zbgj.entity.TUserAddress;
import com.honglinktech.zbgj.entity.TUserKeep;
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
			Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		Response<String> resp = userService.loginout(Integer.valueOf(userCode));

		return resp; 
	}
	
	@RequestMapping(value="findKeepPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<TUserKeep>> findKeepPage(@RequestBody Map<String, String> req,@RequestHeader HttpHeaders headers) throws BaseException{
	        	
	    String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode)){
			Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		Integer index = req.get("index")==null?1:Integer.valueOf(req.get("index"));
		Integer size = req.get("size")==null?10:Integer.valueOf(req.get("size"));
		if(req.get("type")==null){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"type");
		}
		Integer type = Integer.valueOf(req.get("type"));
		Response<List<TUserKeep>> resp = userService.findKeepPage(Integer.valueOf(userCode), type, index, size);

		return resp; 
	}
	@RequestMapping(value="saveOrUpdateKeep",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> saveOrUpdateKeep(@RequestHeader HttpHeaders headers,@RequestBody TUserKeep tuserKeep) throws BaseException{
	    
		String userCode =  headers.getFirst("userId");
	     
		if(StringUtils.isEmpty(userCode)){
			Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		tuserKeep.setUserId(Integer.valueOf(userCode));
		Response<String> resp = userService.saveOrUpdateKeep(tuserKeep);

		return resp; 
	}
	@RequestMapping(value="findAddressById",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<TUserAddress> findAddressById(@RequestBody Map<String, String> req,@RequestHeader HttpHeaders headers) throws BaseException{
	        	
	    String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode)){
			Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		
		if(req.get("id")==null){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"ID");
		}
		Integer id = req.get("id")==null?1:Integer.valueOf(req.get("id"));
		Response<TUserAddress> resp = userService.findAddressById(Integer.valueOf(userCode), id);

		return resp; 
	}
	@RequestMapping(value="findAddressPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<TUserAddress>> findAddressPage(@RequestBody Map<String, String> req,@RequestHeader HttpHeaders headers) throws BaseException{
	        	
	    String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode)){
			Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		Integer index = req.get("index")==null?1:Integer.valueOf(req.get("index"));
		Integer size = req.get("size")==null?10:Integer.valueOf(req.get("size"));
		Response<List<TUserAddress>> resp = userService.findAddressPage(Integer.valueOf(userCode), index, size);

		return resp; 
	}
	@RequestMapping(value="updateAddressDefault",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> updateAddressDefault(@RequestHeader HttpHeaders headers,@RequestBody TUserAddress tuserAddress) throws BaseException{
	    
		String userCode =  headers.getFirst("userId");
	     
		if(StringUtils.isEmpty(userCode)){
			Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		tuserAddress.setUserId(Integer.valueOf(userCode));
		Response<String> resp = userService.updateAddressDefault(tuserAddress);

		return resp; 
	}
	
	
}
