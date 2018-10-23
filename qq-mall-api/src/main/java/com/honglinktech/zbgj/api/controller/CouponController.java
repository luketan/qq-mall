package com.honglinktech.zbgj.api.controller;


import com.honglinktech.zbgj.annotation.RequireLogin;
import com.honglinktech.zbgj.api.base.BaseApiController;
import com.honglinktech.zbgj.base.BaseException;
import com.honglinktech.zbgj.base.ExceptionEnum;
import com.honglinktech.zbgj.common.Response;
import com.honglinktech.zbgj.common.Result;
import com.honglinktech.zbgj.entity.Coupon;
import com.honglinktech.zbgj.service.CouponService;
import com.honglinktech.zbgj.vo.CouponUserVO;
import com.honglinktech.zbgj.vo.UserVO;
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



	@RequestMapping(value="findAvailableCoupons",method={RequestMethod.POST})
	@ResponseBody
	public Response<List<CouponUserVO>> findAvailableCoupons(@RequestBody Map<String, String> req,
												 @RequestAttribute UserVO user) throws BaseException{

		int start = req.containsKey("start")?Integer.valueOf(req.get("start")):0;
		int rows = req.containsKey("rows")?Integer.valueOf(req.get("rows")):10;
		Response<List<CouponUserVO>> resp = couponService.findUserCoupons(user.getId(), start, rows, 1);

		return resp; 
	}


	@RequestMapping(value="findUsedCoupons",method={RequestMethod.POST})
	@ResponseBody
	public Response<List<CouponUserVO>> findUsedCoupons(@RequestBody Map<String, String> req,
															 @RequestAttribute UserVO user) throws BaseException{

		int start = req.containsKey("start")?Integer.valueOf(req.get("start")):0;
		int rows = req.containsKey("rows")?Integer.valueOf(req.get("rows")):10;
		Response<List<CouponUserVO>> resp = couponService.findUserCoupons(user.getId(), start, rows, 2);

		return resp;
	}

	@RequestMapping(value="findExpiredCoupons",method={RequestMethod.POST})
	@ResponseBody
	public Response<List<CouponUserVO>> findExpiredCoupons(@RequestBody Map<String, String> req,
														@RequestAttribute UserVO user) throws BaseException{

		int start = req.containsKey("start")?Integer.valueOf(req.get("start")):0;
		int rows = req.containsKey("rows")?Integer.valueOf(req.get("rows")):10;
		Response<List<CouponUserVO>> resp = couponService.findUserCoupons(user.getId(), start, rows, 3);

		return resp;
	}

	@RequestMapping(value="findUserCouponById",method={RequestMethod.POST})
	@ResponseBody
	public Response<CouponUserVO> findUserCouponById(@RequestBody Map<String, String> req,
														   @RequestAttribute UserVO user) throws BaseException{

		if(req.get("id") == null || Integer.valueOf(req.get("id"))==0){
			return Result.fail("ID不能为空！");
		}
		Integer id = Integer.valueOf(req.get("id"));
		Response<CouponUserVO> resp = couponService.findUserCouponById(user.getId(), id);

		return resp;
	}


	@RequestMapping(value="deleteUserCoupon",method={RequestMethod.POST})
	@ResponseBody
	public Response deleteUserCoupon(@RequestBody Map<String, String> req,
								 @RequestAttribute UserVO user) throws BaseException{
	    

		if(req.get("id") == null || Integer.valueOf(req.get("id"))==0){
			return Result.fail("ID不能为空！");
		}
		Integer id = Integer.valueOf(req.get("id"));
		
		Response<Integer> resp = couponService.deleteUserCoupon(user.getId(), id);

		return resp; 
	}

	
}
