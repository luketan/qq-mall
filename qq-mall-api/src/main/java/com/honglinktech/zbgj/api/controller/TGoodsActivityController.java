package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.TGoodsActivity;
import com.honglinktech.zbgj.service.TGoodsActivityService;
/**
*商品活动
**/
@ControllerMeta(name = "商品活动")
@RestController
@RequestMapping("/tGoodsActivity/api/")
public class TGoodsActivityController extends BaseController<TGoodsActivity,TGoodsActivityService> {

	private TGoodsActivityService tGoodsActivityService;

	public TGoodsActivityService getTGoodsActivityService() {
		return tGoodsActivityService;
	}
	@Resource
	public void setTGoodsActivityService(TGoodsActivityService tGoodsActivityService) {
		this.tGoodsActivityService = tGoodsActivityService;
	}
	@Override
	protected TGoodsActivityService getService() {
		return tGoodsActivityService;
	}
	
}
