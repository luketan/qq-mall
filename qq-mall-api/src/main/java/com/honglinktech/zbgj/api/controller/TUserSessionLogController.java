package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TUserSessionLog;
import com.honglinktech.zbgj.service.TUserSessionLogService;
/**
*登录日志表
**/
@ControllerMeta(name = "登录日志表")
@RestController
@RequestMapping("/tUserSessionLog/api/")
public class TUserSessionLogController extends CommonBaseController<TUserSessionLog,TUserSessionLogService> {

	private TUserSessionLogService tUserSessionLogService;

	public TUserSessionLogService getTUserSessionLogService() {
		return tUserSessionLogService;
	}
	@Resource
	public void setTUserSessionLogService(TUserSessionLogService tUserSessionLogService) {
		this.tUserSessionLogService = tUserSessionLogService;
	}
	@Override
	protected TUserSessionLogService getService() {
		return tUserSessionLogService;
	}
	
}
