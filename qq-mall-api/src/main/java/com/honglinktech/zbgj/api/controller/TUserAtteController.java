package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TUserAtte;
import com.honglinktech.zbgj.service.TUserAtteService;
/**
*用户关注
**/
@ControllerMeta(name = "用户关注")
@RestController
@RequestMapping("/tUserAtte/api/")
public class TUserAtteController extends CommonBaseController<TUserAtte,TUserAtteService> {

	private TUserAtteService tUserAtteService;

	public TUserAtteService getTUserAtteService() {
		return tUserAtteService;
	}
	@Resource
	public void setTUserAtteService(TUserAtteService tUserAtteService) {
		this.tUserAtteService = tUserAtteService;
	}
	@Override
	protected TUserAtteService getService() {
		return tUserAtteService;
	}
	
}
