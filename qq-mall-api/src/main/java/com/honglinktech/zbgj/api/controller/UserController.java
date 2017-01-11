package com.honglinktech.zbgj.api.controller;


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
import com.honglinktech.zbgj.bean.FeedBackBean;
import com.honglinktech.zbgj.bean.UserLoginBean;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.TChangeLog;
import com.honglinktech.zbgj.entity.TCoupon;
import com.honglinktech.zbgj.entity.TUser;
import com.honglinktech.zbgj.entity.TUserAddress;
import com.honglinktech.zbgj.entity.TUserKeep;
import com.honglinktech.zbgj.service.self.CouponService;
import com.honglinktech.zbgj.service.self.UserAddressService;
import com.honglinktech.zbgj.service.self.UserKeepService;
import com.honglinktech.zbgj.service.self.UserService;

@RestController
@RequestMapping("/user/api")
public class UserController extends BaseApiController {
	@Resource
	private UserService userService;
	@Resource
	private UserAddressService userAddressService;
	@Resource
	private CouponService couponService;
	
	@Resource
	private UserKeepService userKeepService;
	
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
	    if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		Response<String> resp = userService.loginout(Integer.valueOf(userCode));

		return resp; 
	}
	
	@RequestMapping(value="findMoneyLogPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<TChangeLog>> findMoneyLogPage(@RequestHeader HttpHeaders headers,@RequestBody Map<String, String> req) throws BaseException{
	        	
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		int index = req.get("index")==null?1:Integer.valueOf(req.get("index"));
		int size = req.get("size")==null?10:Integer.valueOf(req.get("size"));
		
		Response<List<TChangeLog>> response = userService.findChangeLog(Integer.valueOf(userCode), Constants.CHANGE_MONEY, index, size);
		return response; 
	}
	
	@RequestMapping(value="findPointLogPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<TChangeLog>> findPointLogPage(@RequestHeader HttpHeaders headers,@RequestBody Map<String, String> req) throws BaseException{
	        	
	        	
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		int index = req.get("index")==null?1:Integer.valueOf(req.get("index"));
		int size = req.get("size")==null?10:Integer.valueOf(req.get("size"));
		
		Response<List<TChangeLog>> response = userService.findChangeLog(Integer.valueOf(userCode), Constants.CHANGE_POINT, index, size);
		return response; 
		
	}
	
	@RequestMapping(value="findKeepPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<TUserKeep>> findKeepPage(@RequestBody Map<String, String> req,@RequestHeader HttpHeaders headers) throws BaseException{
	        	
	    String userCode =  headers.getFirst("userId");
	    if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		Integer index = req.get("index")==null?1:Integer.valueOf(req.get("index"));
		Integer size = req.get("size")==null?10:Integer.valueOf(req.get("size"));
		if(req.get("type")==null){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"type");
		}
		Integer type = Integer.valueOf(req.get("type"));
		Response<List<TUserKeep>> resp = userKeepService.findKeepPage(Integer.valueOf(userCode), type, index, size);

		return resp; 
	}
	@RequestMapping(value="saveOrUpdateKeep",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> saveOrUpdateKeep(@RequestHeader HttpHeaders headers,@RequestBody TUserKeep tuserKeep) throws BaseException{
	    
		String userCode =  headers.getFirst("userId");
	     
		if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		tuserKeep.setUserId(Integer.valueOf(userCode));
		Response<String> resp = userKeepService.updateGoodsKeep(Integer.valueOf(userCode), tuserKeep.getObjId(), !(tuserKeep.getId() != null && tuserKeep.getId() > 0));
		return resp; 
	}
	@RequestMapping(value="findAddressById",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<TUserAddress> findAddressById(@RequestBody Map<String, String> req,@RequestHeader HttpHeaders headers) throws BaseException{
	        	
	    String userCode =  headers.getFirst("userId");
	    if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		
		if(req.get("id")==null){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"ID");
		}
		Integer id = req.get("id")==null?1:Integer.valueOf(req.get("id"));
		Response<TUserAddress> resp = userAddressService.findAddressById(Integer.valueOf(userCode), id);

		return resp; 
	}
	@RequestMapping(value="findAddressList",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<TUserAddress>> findAddressList(@RequestBody Map<String, String> req,@RequestHeader HttpHeaders headers) throws BaseException{
	        	
	    String userCode =  headers.getFirst("userId");
	    if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		Response<List<TUserAddress>> resp = userAddressService.findAddress(Integer.valueOf(userCode));

		return resp; 
	}
	@RequestMapping(value="updateAddressDefault",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> updateAddressDefault(@RequestHeader HttpHeaders headers,@RequestBody TUserAddress tuserAddress) throws BaseException{
	    
		String userCode =  headers.getFirst("userId");
	     
		if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		tuserAddress.setUserId(Integer.valueOf(userCode));
		Response<String> resp = userAddressService.updateAddressDefault(tuserAddress);

		return resp; 
	}
	/**
	 * 获取可用的券数量
	 * @param headers
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findCouponCount",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<Object> findCouponCount(@RequestHeader HttpHeaders headers) throws BaseException{
	    
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		Response<Object> resp = couponService.findCouponCount(Integer.valueOf(userCode));

		return resp; 
	}
	@RequestMapping(value="findCouponPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<TCoupon>> findCouponPage(@RequestHeader HttpHeaders headers, @RequestBody Map<String, String> req) throws BaseException{
	    
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		int index = req.get("index")==null?1:Integer.valueOf(req.get("index"));
		int size = req.get("size")==null?10:Integer.valueOf(req.get("size"));
		int type = req.get("type")==null?0:Integer.valueOf(req.get("type"));
		Response<List<TCoupon>> resp = couponService.findCoupons(Integer.valueOf(userCode), index, size, type);

		return resp; 
	}
	@RequestMapping(value="deleteCoupon",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> deleteCoupon(@RequestHeader HttpHeaders headers, @RequestBody Map<String, String> req) throws BaseException{
	    
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		if(req.get("couponId") == null || Integer.valueOf(req.get("couponId"))==0){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"couponIdv");
		}
		Integer couponId = Integer.valueOf(req.get("couponId"));
		
		Response<String> resp = couponService.deleteCoupon(Integer.valueOf(userCode), couponId);

		return resp; 
	}
	/**
	 * 获取红包记录
	 * @param headers
	 * @param req
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findRedMoneyLog",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<TChangeLog>> findRedMoneyLog(@RequestHeader HttpHeaders headers, @RequestBody Map<String, String> req) throws BaseException{
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		int index = req.get("index")==null?1:Integer.valueOf(req.get("index"));
		int size = req.get("size")==null?10:Integer.valueOf(req.get("size"));
		
		Response<List<TChangeLog>> response = userService.findChangeLog(Integer.valueOf(userCode), Constants.CHANGE_VIRTUAL_MONEY, index, size);
		return response; 
	}
	/**
	 * 获取红包记录
	 * @param headers
	 * @param req
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findFeedBackById",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<FeedBackBean> findFeedBackById(@RequestHeader HttpHeaders headers, @RequestBody Map<String, String> req) throws BaseException{
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		String id =  req.get("id");
		if(StringUtils.isEmpty(id) || Integer.valueOf(id)<=0){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"id");
		}
		Response<FeedBackBean> response = userService.findFeedBackById(Integer.valueOf(userCode), Integer.valueOf(id));
		return response; 
	}
	/**
	 * 保存意见反馈
	 * @param headers
	 * @param req
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="saveFeedBack",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> saveFeedBackPage(@RequestHeader HttpHeaders headers, @RequestBody Map<String, String> req) throws BaseException{
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		String detail = req.get("detail");
		Response<String> response = userService.saveFeedPage(Integer.valueOf(userCode), detail, null);
		return response; 
	}
	/**
	 * 获取意见反馈
	 * @param headers
	 * @param req
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findFeedBackPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<FeedBackBean>> findFeedBackPage(@RequestHeader HttpHeaders headers, @RequestBody Map<String, String> req) throws BaseException{
		String userCode =  headers.getFirst("userId");
		if(StringUtils.isEmpty(userCode) || Integer.valueOf(userCode)==0){
			return Result.fail(ExceptionEnum.COMMON_USER_CODE_NOT_EMPTY);
		}
		int index = req.get("index")==null?1:Integer.valueOf(req.get("index"));
		int size = req.get("size")==null?10:Integer.valueOf(req.get("size"));
		
		Response<List<FeedBackBean>> response = userService.findFeedBackPage(Integer.valueOf(userCode), index, size);
		return response; 
	}
	
}
