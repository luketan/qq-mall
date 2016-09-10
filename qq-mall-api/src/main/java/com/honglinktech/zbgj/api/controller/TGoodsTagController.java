package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.TGoodsTag;
import com.honglinktech.zbgj.service.TGoodsTagService;
/**
*商品表情
**/
@ControllerMeta(name = "商品表情")
@RestController
@RequestMapping("/tGoodsTag/api/")
public class TGoodsTagController extends BaseController<TGoodsTag,TGoodsTagService> {

	private TGoodsTagService tGoodsTagService;

	public TGoodsTagService getTGoodsTagService() {
		return tGoodsTagService;
	}
	@Resource
	public void setTGoodsTagService(TGoodsTagService tGoodsTagService) {
		this.tGoodsTagService = tGoodsTagService;
	}
	@Override
	protected TGoodsTagService getService() {
		return tGoodsTagService;
	}
	
}
