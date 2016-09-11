package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TCoupon;
import com.honglinktech.zbgj.service.TCouponService;
/**
*优惠券
**/
@ControllerMeta(name = "优惠券")
@RestController
@RequestMapping("/tCoupon/api/")
public class TCouponController extends CommonBaseController<TCoupon,TCouponService> {

	private TCouponService tCouponService;

	public TCouponService getTCouponService() {
		return tCouponService;
	}
	@Resource
	public void setTCouponService(TCouponService tCouponService) {
		this.tCouponService = tCouponService;
	}
	@Override
	protected TCouponService getService() {
		return tCouponService;
	}
	
}
