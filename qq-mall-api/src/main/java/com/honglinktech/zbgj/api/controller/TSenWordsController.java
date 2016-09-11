package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.CommonBaseController;
import com.honglinktech.zbgj.entity.TSenWords;
import com.honglinktech.zbgj.service.TSenWordsService;
/**
*
**/
@ControllerMeta(name = "")
@RestController
@RequestMapping("/tSenWords/api/")
public class TSenWordsController extends CommonBaseController<TSenWords,TSenWordsService> {

	private TSenWordsService tSenWordsService;

	public TSenWordsService getTSenWordsService() {
		return tSenWordsService;
	}
	@Resource
	public void setTSenWordsService(TSenWordsService tSenWordsService) {
		this.tSenWordsService = tSenWordsService;
	}
	@Override
	protected TSenWordsService getService() {
		return tSenWordsService;
	}
	
}
