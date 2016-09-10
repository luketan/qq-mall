package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.CAdminSessionLog;
import com.honglinktech.zbgj.service.CAdminSessionLogService;
/**
*登录日志表
**/
@ControllerMeta(name = "登录日志表")
@RestController
@RequestMapping("/cAdminSessionLog/api/")
public class CAdminSessionLogController extends BaseController<CAdminSessionLog,CAdminSessionLogService> {

	private CAdminSessionLogService cAdminSessionLogService;

	public CAdminSessionLogService getCAdminSessionLogService() {
		return cAdminSessionLogService;
	}
	@Resource
	public void setCAdminSessionLogService(CAdminSessionLogService cAdminSessionLogService) {
		this.cAdminSessionLogService = cAdminSessionLogService;
	}
	@Override
	protected CAdminSessionLogService getService() {
		return cAdminSessionLogService;
	}
	
}
