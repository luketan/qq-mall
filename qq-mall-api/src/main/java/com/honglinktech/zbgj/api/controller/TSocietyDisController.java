package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.TSocietyDis;
import com.honglinktech.zbgj.service.TSocietyDisService;
/**
*回帖内容，根据帖子id，分表 注意分表
**/
@ControllerMeta(name = "回帖内容，根据帖子id，分表 注意分表")
@RestController
@RequestMapping("/tSocietyDis/api/")
public class TSocietyDisController extends BaseController<TSocietyDis,TSocietyDisService> {

	private TSocietyDisService tSocietyDisService;

	public TSocietyDisService getTSocietyDisService() {
		return tSocietyDisService;
	}
	@Resource
	public void setTSocietyDisService(TSocietyDisService tSocietyDisService) {
		this.tSocietyDisService = tSocietyDisService;
	}
	@Override
	protected TSocietyDisService getService() {
		return tSocietyDisService;
	}
	
}
