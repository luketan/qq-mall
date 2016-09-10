package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.CAdminRole;
import com.honglinktech.zbgj.service.CAdminRoleService;
/**
*用户角色关联表
**/
@ControllerMeta(name = "用户角色关联表")
@RestController
@RequestMapping("/cAdminRole/api/")
public class CAdminRoleController extends BaseController<CAdminRole,CAdminRoleService> {

	private CAdminRoleService cAdminRoleService;

	public CAdminRoleService getCAdminRoleService() {
		return cAdminRoleService;
	}
	@Resource
	public void setCAdminRoleService(CAdminRoleService cAdminRoleService) {
		this.cAdminRoleService = cAdminRoleService;
	}
	@Override
	protected CAdminRoleService getService() {
		return cAdminRoleService;
	}
	
}
