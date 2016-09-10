package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.TPic;
import com.honglinktech.zbgj.service.TPicService;
/**
*商品图片
**/
@ControllerMeta(name = "商品图片")
@RestController
@RequestMapping("/tPic/api/")
public class TPicController extends BaseController<TPic,TPicService> {

	private TPicService tPicService;

	public TPicService getTPicService() {
		return tPicService;
	}
	@Resource
	public void setTPicService(TPicService tPicService) {
		this.tPicService = tPicService;
	}
	@Override
	protected TPicService getService() {
		return tPicService;
	}
	
}
