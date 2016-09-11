package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TGActivity;
import com.honglinktech.zbgj.service.TGActivityService;
/**
*活动
**/
@ControllerMeta(name = "活动")
@RestController
@RequestMapping("/tGActivity/api/")
public class TGActivityController extends CommonBaseController<TGActivity,TGActivityService> {

	private TGActivityService tGActivityService;

	public TGActivityService getTGActivityService() {
		return tGActivityService;
	}
	@Resource
	public void setTGActivityService(TGActivityService tGActivityService) {
		this.tGActivityService = tGActivityService;
	}
	@Override
	protected TGActivityService getService() {
		return tGActivityService;
	}
	
}
