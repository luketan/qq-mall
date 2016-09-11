package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.THint;
import com.honglinktech.zbgj.service.THintService;
/**
*提示语
**/
@ControllerMeta(name = "提示语")
@RestController
@RequestMapping("/tHint/api/")
public class THintController extends CommonBaseController<THint,THintService> {

	private THintService tHintService;

	public THintService getTHintService() {
		return tHintService;
	}
	@Resource
	public void setTHintService(THintService tHintService) {
		this.tHintService = tHintService;
	}
	@Override
	protected THintService getService() {
		return tHintService;
	}
	
}
