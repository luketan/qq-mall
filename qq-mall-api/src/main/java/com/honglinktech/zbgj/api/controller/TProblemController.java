package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.TProblem;
import com.honglinktech.zbgj.service.TProblemService;
/**
*活动
**/
@ControllerMeta(name = "活动")
@RestController
@RequestMapping("/tProblem/api/")
public class TProblemController extends BaseController<TProblem,TProblemService> {

	private TProblemService tProblemService;

	public TProblemService getTProblemService() {
		return tProblemService;
	}
	@Resource
	public void setTProblemService(TProblemService tProblemService) {
		this.tProblemService = tProblemService;
	}
	@Override
	protected TProblemService getService() {
		return tProblemService;
	}
	
}
