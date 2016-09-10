package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.TGType;
import com.honglinktech.zbgj.service.TGTypeService;
/**
*商品类别表
**/
@ControllerMeta(name = "商品类别表")
@RestController
@RequestMapping("/tGType/api/")
public class TGTypeController extends BaseController<TGType,TGTypeService> {

	private TGTypeService tGTypeService;

	public TGTypeService getTGTypeService() {
		return tGTypeService;
	}
	@Resource
	public void setTGTypeService(TGTypeService tGTypeService) {
		this.tGTypeService = tGTypeService;
	}
	@Override
	protected TGTypeService getService() {
		return tGTypeService;
	}
	
}
