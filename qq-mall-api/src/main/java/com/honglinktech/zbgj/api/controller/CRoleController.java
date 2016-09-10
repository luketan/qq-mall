package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.CRole;
import com.honglinktech.zbgj.service.CRoleService;
/**
*系统角色表
**/
@ControllerMeta(name = "系统角色表")
@RestController
@RequestMapping("/cRole/api/")
public class CRoleController extends BaseController<CRole,CRoleService> {

	private CRoleService cRoleService;

	public CRoleService getCRoleService() {
		return cRoleService;
	}
	@Resource
	public void setCRoleService(CRoleService cRoleService) {
		this.cRoleService = cRoleService;
	}
	@Override
	protected CRoleService getService() {
		return cRoleService;
	}
	
}
