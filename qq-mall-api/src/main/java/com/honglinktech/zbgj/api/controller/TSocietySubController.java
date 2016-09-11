package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TSocietySub;
import com.honglinktech.zbgj.service.TSocietySubService;
/**
*
**/
@ControllerMeta(name = "")
@RestController
@RequestMapping("/tSocietySub/api/")
public class TSocietySubController extends CommonBaseController<TSocietySub,TSocietySubService> {

	private TSocietySubService tSocietySubService;

	public TSocietySubService getTSocietySubService() {
		return tSocietySubService;
	}
	@Resource
	public void setTSocietySubService(TSocietySubService tSocietySubService) {
		this.tSocietySubService = tSocietySubService;
	}
	@Override
	protected TSocietySubService getService() {
		return tSocietySubService;
	}
	
}
