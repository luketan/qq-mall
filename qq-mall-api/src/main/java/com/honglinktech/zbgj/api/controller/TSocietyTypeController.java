package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TSocietyType;
import com.honglinktech.zbgj.service.TSocietyTypeService;
/**
*社区类型
**/
@ControllerMeta(name = "社区类型")
@RestController
@RequestMapping("/tSocietyType/api/")
public class TSocietyTypeController extends CommonBaseController<TSocietyType,TSocietyTypeService> {

	private TSocietyTypeService tSocietyTypeService;

	public TSocietyTypeService getTSocietyTypeService() {
		return tSocietyTypeService;
	}
	@Resource
	public void setTSocietyTypeService(TSocietyTypeService tSocietyTypeService) {
		this.tSocietyTypeService = tSocietyTypeService;
	}
	@Override
	protected TSocietyTypeService getService() {
		return tSocietyTypeService;
	}
	
}
