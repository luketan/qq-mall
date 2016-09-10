package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.TSocietySubUser;
import com.honglinktech.zbgj.service.TSocietySubUserService;
/**
*用户关注的主题
**/
@ControllerMeta(name = "用户关注的主题")
@RestController
@RequestMapping("/tSocietySubUser/api/")
public class TSocietySubUserController extends BaseController<TSocietySubUser,TSocietySubUserService> {

	private TSocietySubUserService tSocietySubUserService;

	public TSocietySubUserService getTSocietySubUserService() {
		return tSocietySubUserService;
	}
	@Resource
	public void setTSocietySubUserService(TSocietySubUserService tSocietySubUserService) {
		this.tSocietySubUserService = tSocietySubUserService;
	}
	@Override
	protected TSocietySubUserService getService() {
		return tSocietySubUserService;
	}
	
}
