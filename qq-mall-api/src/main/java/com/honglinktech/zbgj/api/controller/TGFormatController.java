package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.TGFormat;
import com.honglinktech.zbgj.service.TGFormatService;
/**
*商品规格
**/
@ControllerMeta(name = "商品规格")
@RestController
@RequestMapping("/tGFormat/api/")
public class TGFormatController extends BaseController<TGFormat,TGFormatService> {

	private TGFormatService tGFormatService;

	public TGFormatService getTGFormatService() {
		return tGFormatService;
	}
	@Resource
	public void setTGFormatService(TGFormatService tGFormatService) {
		this.tGFormatService = tGFormatService;
	}
	@Override
	protected TGFormatService getService() {
		return tGFormatService;
	}
	
}
