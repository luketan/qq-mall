package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.TGoods;
import com.honglinktech.zbgj.service.TGoodsService;
/**
*
**/
@ControllerMeta(name = "")
@RestController
@RequestMapping("/tGoods/api/")
public class TGoodsController extends BaseController<TGoods,TGoodsService> {

	private TGoodsService tGoodsService;

	public TGoodsService getTGoodsService() {
		return tGoodsService;
	}
	@Resource
	public void setTGoodsService(TGoodsService tGoodsService) {
		this.tGoodsService = tGoodsService;
	}
	@Override
	protected TGoodsService getService() {
		return tGoodsService;
	}
	
}
