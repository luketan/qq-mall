package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.CSecurity;
import com.honglinktech.zbgj.service.CSecurityService;
/**
*系统权限表
**/
@ControllerMeta(name = "系统权限表")
@RestController
@RequestMapping("/cSecurity/api/")
public class CSecurityController extends BaseController<CSecurity,CSecurityService> {

	private CSecurityService cSecurityService;

	public CSecurityService getCSecurityService() {
		return cSecurityService;
	}
	@Resource
	public void setCSecurityService(CSecurityService cSecurityService) {
		this.cSecurityService = cSecurityService;
	}
	@Override
	protected CSecurityService getService() {
		return cSecurityService;
	}
	
}
