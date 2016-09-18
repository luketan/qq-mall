package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TUserKeep;
import com.honglinktech.zbgj.service.TUserKeepService;
/**
*用户的收藏
**/
@ControllerMeta(name = "用户的收藏")
@RestController
@RequestMapping("/tUserKeep/api/")
public class TUserKeepController extends CommonBaseController<TUserKeep,TUserKeepService> {

	private TUserKeepService tUserKeepService;

	public TUserKeepService getTUserKeepService() {
		return tUserKeepService;
	}
	@Resource
	public void setTUserKeepService(TUserKeepService tUserKeepService) {
		this.tUserKeepService = tUserKeepService;
	}
	@Override
	protected TUserKeepService getService() {
		return tUserKeepService;
	}
	
}
