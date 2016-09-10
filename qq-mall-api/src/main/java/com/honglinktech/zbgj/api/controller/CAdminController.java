package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.CAdmin;
import com.honglinktech.zbgj.service.CAdminService;
/**
*管理员表
**/
@ControllerMeta(name = "管理员表")
@RestController
@RequestMapping("/cAdmin/api/")
public class CAdminController extends BaseController<CAdmin,CAdminService> {

	private CAdminService cAdminService;

	public CAdminService getCAdminService() {
		return cAdminService;
	}
	@Resource
	public void setCAdminService(CAdminService cAdminService) {
		this.cAdminService = cAdminService;
	}
	@Override
	protected CAdminService getService() {
		return cAdminService;
	}
	
}
