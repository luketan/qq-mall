package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TCouponUser;
import com.honglinktech.zbgj.service.TCouponUserService;
/**
*
**/
@ControllerMeta(name = "")
@RestController
@RequestMapping("/tCouponUser/api/")
public class TCouponUserController extends CommonBaseController<TCouponUser,TCouponUserService> {

	private TCouponUserService tCouponUserService;

	public TCouponUserService getTCouponUserService() {
		return tCouponUserService;
	}
	@Resource
	public void setTCouponUserService(TCouponUserService tCouponUserService) {
		this.tCouponUserService = tCouponUserService;
	}
	@Override
	protected TCouponUserService getService() {
		return tCouponUserService;
	}
	
}
