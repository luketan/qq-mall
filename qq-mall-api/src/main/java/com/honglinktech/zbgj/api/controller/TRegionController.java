package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.TRegion;
import com.honglinktech.zbgj.service.TRegionService;
/**
*
**/
@ControllerMeta(name = "")
@RestController
@RequestMapping("/tRegion/api/")
public class TRegionController extends BaseController<TRegion,TRegionService> {

	private TRegionService tRegionService;

	public TRegionService getTRegionService() {
		return tRegionService;
	}
	@Resource
	public void setTRegionService(TRegionService tRegionService) {
		this.tRegionService = tRegionService;
	}
	@Override
	protected TRegionService getService() {
		return tRegionService;
	}
	
}
