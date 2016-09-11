package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TUserCollect;
import com.honglinktech.zbgj.service.TUserCollectService;
/**
*用户的收藏
**/
@ControllerMeta(name = "用户的收藏")
@RestController
@RequestMapping("/tUserCollect/api/")
public class TUserCollectController extends CommonBaseController<TUserCollect,TUserCollectService> {

	private TUserCollectService tUserCollectService;

	public TUserCollectService getTUserCollectService() {
		return tUserCollectService;
	}
	@Resource
	public void setTUserCollectService(TUserCollectService tUserCollectService) {
		this.tUserCollectService = tUserCollectService;
	}
	@Override
	protected TUserCollectService getService() {
		return tUserCollectService;
	}
	
}
