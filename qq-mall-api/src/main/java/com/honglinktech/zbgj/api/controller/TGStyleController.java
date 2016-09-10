package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.TGStyle;
import com.honglinktech.zbgj.service.TGStyleService;
/**
*商品款式
**/
@ControllerMeta(name = "商品款式")
@RestController
@RequestMapping("/tGStyle/api/")
public class TGStyleController extends BaseController<TGStyle,TGStyleService> {

	private TGStyleService tGStyleService;

	public TGStyleService getTGStyleService() {
		return tGStyleService;
	}
	@Resource
	public void setTGStyleService(TGStyleService tGStyleService) {
		this.tGStyleService = tGStyleService;
	}
	@Override
	protected TGStyleService getService() {
		return tGStyleService;
	}
	
}
