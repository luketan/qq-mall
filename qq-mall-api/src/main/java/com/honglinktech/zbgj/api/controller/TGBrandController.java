package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TGBrand;
import com.honglinktech.zbgj.service.TGBrandService;
/**
*商品品牌
**/
@ControllerMeta(name = "商品品牌")
@RestController
@RequestMapping("/tGBrand/api/")
public class TGBrandController extends CommonBaseController<TGBrand,TGBrandService> {

	private TGBrandService tGBrandService;

	public TGBrandService getTGBrandService() {
		return tGBrandService;
	}
	@Resource
	public void setTGBrandService(TGBrandService tGBrandService) {
		this.tGBrandService = tGBrandService;
	}
	@Override
	protected TGBrandService getService() {
		return tGBrandService;
	}
	
}
