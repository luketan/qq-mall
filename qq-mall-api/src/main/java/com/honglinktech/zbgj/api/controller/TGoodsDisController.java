package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.TGoodsDis;
import com.honglinktech.zbgj.service.TGoodsDisService;
/**
*商品评论表
**/
@ControllerMeta(name = "商品评论表")
@RestController
@RequestMapping("/tGoodsDis/api/")
public class TGoodsDisController extends BaseController<TGoodsDis,TGoodsDisService> {

	private TGoodsDisService tGoodsDisService;

	public TGoodsDisService getTGoodsDisService() {
		return tGoodsDisService;
	}
	@Resource
	public void setTGoodsDisService(TGoodsDisService tGoodsDisService) {
		this.tGoodsDisService = tGoodsDisService;
	}
	@Override
	protected TGoodsDisService getService() {
		return tGoodsDisService;
	}
	
}
