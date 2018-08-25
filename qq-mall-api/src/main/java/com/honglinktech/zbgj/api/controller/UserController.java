package com.honglinktech.zbgj.api.controller;


import com.honglinktech.zbgj.annotation.NoRequireLogin;
import com.honglinktech.zbgj.annotation.RequireLogin;
import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.bean.FeedBackBean;
import com.honglinktech.zbgj.common.AppAgent;
import com.honglinktech.zbgj.common.Constants;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.ChangeLog;
import com.honglinktech.zbgj.entity.User;
import com.honglinktech.zbgj.entity.UserAddress;
import com.honglinktech.zbgj.entity.UserKeep;
import com.honglinktech.zbgj.service.ChangeLogService;
import com.honglinktech.zbgj.service.FeedBackService;
import com.honglinktech.zbgj.service.UserAddressService;
import com.honglinktech.zbgj.service.UserKeepService;
import com.honglinktech.zbgj.service.UserService;
import com.honglinktech.zbgj.vo.UserHomeVO;
import com.honglinktech.zbgj.vo.UserLoginVO;
import com.honglinktech.zbgj.vo.UserVO;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequireLogin
@RestController
@RequestMapping("/user/api")
public class UserController extends BaseApiController {
	@Resource
	private UserService userService;
	@Resource
	private UserAddressService userAddressService;
	@Resource
	private UserKeepService userKeepService;
	@Resource
	private FeedBackService feedBackService;
	@Resource
	private ChangeLogService changeLogService;

	@NoRequireLogin
	@RequestMapping(value="login",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<UserLoginVO> login(@RequestBody User user) throws BaseException{
		
		Response<UserLoginVO> resp = userService.login(user.getAccount(), user.getPassword());

		return resp; 
	}
	
	@RequestMapping(value="loginout",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> loginout(@RequestBody Map map,
									 @RequestAttribute UserVO user,
									 @RequestAttribute AppAgent agent) throws BaseException{

		Response<String> resp = userService.loginout(user.getId());

		return resp; 
	}

	@RequestMapping(value="findUsreHome",method={RequestMethod.POST})
	@ResponseBody
	public Response<UserHomeVO> findUsreHome(@RequestBody Map<String, String> req,
											 @RequestAttribute UserVO user) throws BaseException{
		Response<UserHomeVO> response = userService.findUserHome(user.getId());
		return response;
	}

	@RequestMapping(value="findMoneyLogPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<ChangeLog>> findMoneyLogPage(@RequestBody Map<String, String> req,
													  @RequestAttribute UserVO user) throws BaseException{

		int start = req.containsKey("start")?Integer.valueOf(req.get("start")):0;
		int rows = req.containsKey("rows")?Integer.valueOf(req.get("rows")):10;
		
		Response<List<ChangeLog>> response = changeLogService.findChangeLog(user.getId(), Constants.CHANGE_MONEY, start, rows);
		return response; 
	}
	
	@RequestMapping(value="findPointLogPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<ChangeLog>> findPointLogPage(@RequestBody Map<String, String> req,
													  @RequestAttribute UserVO user) throws BaseException{

		int start = req.containsKey("start")?Integer.valueOf(req.get("start")):0;
		int rows = req.containsKey("rows")?Integer.valueOf(req.get("rows")):10;
		
		Response<List<ChangeLog>> response = changeLogService.findChangeLog(user.getId(), Constants.CHANGE_POINT, start, rows);
		return response; 
		
	}
	
	@RequestMapping(value="findKeepPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<UserKeep>> findKeepPage(@RequestBody Map<String, String> req, @RequestAttribute UserVO user) throws BaseException{

		int start = req.containsKey("start")?Integer.valueOf(req.get("start")):0;
		int rows = req.containsKey("rows")?Integer.valueOf(req.get("rows")):10;
		if(req.get("type")==null){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"type");
		}
		Integer type = Integer.valueOf(req.get("type"));
		Response<List<UserKeep>> resp = userKeepService.findKeepPage(user.getId(), type, start, rows);

		return resp; 
	}
	@RequestMapping(value="saveOrUpdateKeep",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> saveOrUpdateKeep(@RequestBody UserKeep userKeep, @RequestAttribute UserVO user) throws BaseException{


		userKeep.setUserId(user.getId());
		Response<String> resp = userKeepService.updateGoodsKeep(user.getId(), userKeep.getObjId(), !(userKeep.getId() != null && userKeep.getId() > 0));
		return resp; 
	}
	@RequestMapping(value="findAddressById",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<UserAddress> findAddressById(@RequestBody Map<String, String> req,
												 @RequestAttribute UserVO user) throws BaseException{
		
		if(req.get("id")==null){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"ID");
		}
		Integer id = req.get("id")==null?1:Integer.valueOf(req.get("id"));
		Response<UserAddress> resp = userAddressService.findAddressById(user.getId(), id);

		return resp; 
	}
	@RequestMapping(value="findAddressList",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<UserAddress>> findAddressList(@RequestBody Map<String, String> req,
													   @RequestAttribute UserVO user) throws BaseException{

		Response<List<UserAddress>> resp = userAddressService.findAddress(user.getId());

		return resp; 
	}
	@RequestMapping(value="updateAddressDefault",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> updateAddressDefault(@RequestBody UserAddress userAddress,
												 @RequestAttribute UserVO user) throws BaseException{
	    

		userAddress.setUserId(user.getId());
		Response<String> resp = userAddressService.updateAddressDefault(userAddress);

		return resp; 
	}

	/**
	 * 获取红包记录
	 * @param req
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findRedMoneyLog",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<ChangeLog>> findRedMoneyLog(@RequestBody Map<String, String> req,
													 @RequestAttribute UserVO user) throws BaseException{

		int start = req.containsKey("start")?Integer.valueOf(req.get("start")):0;
		int rows = req.containsKey("rows")?Integer.valueOf(req.get("rows")):10;
		
		Response<List<ChangeLog>> response = changeLogService.findChangeLog(user.getId(), Constants.CHANGE_VIRTUAL_MONEY, start, rows);
		return response; 
	}
	/**
	 * 获取意见反馈
	 * @param req
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findFeedBackById",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<FeedBackBean> findFeedBackById(@RequestBody Map<String, String> req,
												   @RequestAttribute UserVO user) throws BaseException{

		String id =  req.get("id");
		if(StringUtils.isEmpty(id) || Integer.valueOf(id)<=0){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"id");
		}
		Response<FeedBackBean> response = feedBackService.findFeedBackById(user.getId(), Integer.valueOf(id));
		return response; 
	}
	/**
	 * 保存意见反馈
	 * @param req
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="saveFeedBack",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<String> saveFeedBackPage(@RequestBody Map<String, String> req,
											 @RequestAttribute UserVO user) throws BaseException{

		String detail = req.get("detail");
		Response<String> response = feedBackService.saveFeedPage(user.getId(), detail, null);
		return response; 
	}
	/**
	 * 获取意见反馈
	 * @param req
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findFeedBackPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<FeedBackBean>> findFeedBackPage(@RequestBody Map<String, String> req,
														 @RequestAttribute UserVO user) throws BaseException{

		int start = req.containsKey("start")?Integer.valueOf(req.get("start")):0;
		int rows = req.containsKey("rows")?Integer.valueOf(req.get("rows")):10;
		
		Response<List<FeedBackBean>> response = feedBackService.findFeedBackPage(user.getId(), start, rows);
		return response; 
	}
	
}
