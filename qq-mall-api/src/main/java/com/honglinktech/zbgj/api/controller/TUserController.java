package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TUser;
import com.honglinktech.zbgj.service.TUserService;
/**
*
**/
@ControllerMeta(name = "")
@RestController
@RequestMapping("/tUser/api/")
public class TUserController extends CommonBaseController<TUser,TUserService> {

	private TUserService tUserService;

	public TUserService getTUserService() {
		return tUserService;
	}
	@Resource
	public void setTUserService(TUserService tUserService) {
		this.tUserService = tUserService;
	}
	@Override
	protected TUserService getService() {
		return tUserService;
	}
	
}
