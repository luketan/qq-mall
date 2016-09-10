package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.CRoleSecurity;
import com.honglinktech.zbgj.service.CRoleSecurityService;
/**
*角色权限关联表
**/
@ControllerMeta(name = "角色权限关联表")
@RestController
@RequestMapping("/cRoleSecurity/api/")
public class CRoleSecurityController extends BaseController<CRoleSecurity,CRoleSecurityService> {

	private CRoleSecurityService cRoleSecurityService;

	public CRoleSecurityService getCRoleSecurityService() {
		return cRoleSecurityService;
	}
	@Resource
	public void setCRoleSecurityService(CRoleSecurityService cRoleSecurityService) {
		this.cRoleSecurityService = cRoleSecurityService;
	}
	@Override
	protected CRoleSecurityService getService() {
		return cRoleSecurityService;
	}
	
}
