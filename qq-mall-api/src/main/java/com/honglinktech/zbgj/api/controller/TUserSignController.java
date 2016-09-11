package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TUserSign;
import com.honglinktech.zbgj.service.TUserSignService;
/**
*用户的个性签名记录
**/
@ControllerMeta(name = "用户的个性签名记录")
@RestController
@RequestMapping("/tUserSign/api/")
public class TUserSignController extends CommonBaseController<TUserSign,TUserSignService> {

	private TUserSignService tUserSignService;

	public TUserSignService getTUserSignService() {
		return tUserSignService;
	}
	@Resource
	public void setTUserSignService(TUserSignService tUserSignService) {
		this.tUserSignService = tUserSignService;
	}
	@Override
	protected TUserSignService getService() {
		return tUserSignService;
	}
	
}
