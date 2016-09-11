package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TGoodsFormat;
import com.honglinktech.zbgj.service.TGoodsFormatService;
/**
*商品规格
**/
@ControllerMeta(name = "商品规格")
@RestController
@RequestMapping("/tGoodsFormat/api/")
public class TGoodsFormatController extends CommonBaseController<TGoodsFormat,TGoodsFormatService> {

	private TGoodsFormatService tGoodsFormatService;

	public TGoodsFormatService getTGoodsFormatService() {
		return tGoodsFormatService;
	}
	@Resource
	public void setTGoodsFormatService(TGoodsFormatService tGoodsFormatService) {
		this.tGoodsFormatService = tGoodsFormatService;
	}
	@Override
	protected TGoodsFormatService getService() {
		return tGoodsFormatService;
	}
	
}
