package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.CAdminSession;
import com.honglinktech.zbgj.service.CAdminSessionService;
/**
*管理员回话信息
**/
@ControllerMeta(name = "管理员回话信息")
@RestController
@RequestMapping("/cAdminSession/api/")
public class CAdminSessionController extends BaseController<CAdminSession,CAdminSessionService> {

	private CAdminSessionService cAdminSessionService;

	public CAdminSessionService getCAdminSessionService() {
		return cAdminSessionService;
	}
	@Resource
	public void setCAdminSessionService(CAdminSessionService cAdminSessionService) {
		this.cAdminSessionService = cAdminSessionService;
	}
	@Override
	protected CAdminSessionService getService() {
		return cAdminSessionService;
	}
	
}
