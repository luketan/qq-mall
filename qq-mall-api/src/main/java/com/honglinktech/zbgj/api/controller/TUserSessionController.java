package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TUserSession;
import com.honglinktech.zbgj.service.TUserSessionService;
/**
*用户回话信息
**/
@ControllerMeta(name = "用户回话信息")
@RestController
@RequestMapping("/tUserSession/api/")
public class TUserSessionController extends CommonBaseController<TUserSession,TUserSessionService> {

	private TUserSessionService tUserSessionService;

	public TUserSessionService getTUserSessionService() {
		return tUserSessionService;
	}
	@Resource
	public void setTUserSessionService(TUserSessionService tUserSessionService) {
		this.tUserSessionService = tUserSessionService;
	}
	@Override
	protected TUserSessionService getService() {
		return tUserSessionService;
	}
	
}
