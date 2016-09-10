package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.TUserRec;
import com.honglinktech.zbgj.service.TUserRecService;
/**
*注册用户推荐奖励
**/
@ControllerMeta(name = "注册用户推荐奖励")
@RestController
@RequestMapping("/tUserRec/api/")
public class TUserRecController extends BaseController<TUserRec,TUserRecService> {

	private TUserRecService tUserRecService;

	public TUserRecService getTUserRecService() {
		return tUserRecService;
	}
	@Resource
	public void setTUserRecService(TUserRecService tUserRecService) {
		this.tUserRecService = tUserRecService;
	}
	@Override
	protected TUserRecService getService() {
		return tUserRecService;
	}
	
}
