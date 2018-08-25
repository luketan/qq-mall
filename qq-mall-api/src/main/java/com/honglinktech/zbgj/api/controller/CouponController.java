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
import com.honglinktech.zbgj.entity.Coupon;
import com.honglinktech.zbgj.entity.User;
import com.honglinktech.zbgj.entity.UserAddress;
import com.honglinktech.zbgj.entity.UserKeep;
import com.honglinktech.zbgj.service.ChangeLogService;
import com.honglinktech.zbgj.service.CouponService;
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
@RequestMapping("/coupon/api")
public class CouponController extends BaseApiController {


	@Resource
	private CouponService couponService;

	/**
	 * 获取可用的券数量
	 * @return
	 * @throws BaseException
	 */
	@RequestMapping(value="findCouponCount",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<Integer> findCouponCount(@RequestBody Map map,
											@RequestAttribute UserVO user) throws BaseException{

		int count = couponService.findCouponCount(user.getId());

		return Result.resultSet(count);
	}
	@RequestMapping(value="findCouponPage",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response<List<Coupon>> findCouponPage(@RequestBody Map<String, String> req,
												 @RequestAttribute UserVO user) throws BaseException{

		int start = req.containsKey("start")?Integer.valueOf(req.get("start")):0;
		int rows = req.containsKey("rows")?Integer.valueOf(req.get("rows")):10;
		int type = req.get("type")==null?0:Integer.valueOf(req.get("type"));
		Response<List<Coupon>> resp = couponService.findCoupons(user.getId(), start, rows, type);

		return resp; 
	}
	@RequestMapping(value="deleteCoupon",method={RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Response deleteCoupon(@RequestBody Map<String, String> req,
								 @RequestAttribute UserVO user) throws BaseException{
	    

		if(req.get("couponId") == null || Integer.valueOf(req.get("couponId"))==0){
			return Result.fail(ExceptionEnum.COMMON_PARAMETER_ERROR_NOT_NULL,"couponIdv");
		}
		Integer couponId = Integer.valueOf(req.get("couponId"));
		
		Response<Integer> resp = couponService.deleteCoupon(user.getId(), couponId);

		return resp; 
	}

	
}
