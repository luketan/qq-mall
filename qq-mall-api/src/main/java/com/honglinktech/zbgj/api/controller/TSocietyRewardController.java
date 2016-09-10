package com.honglinktech.zbgj.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honglinktech.zbgj.annotation.ControllerMeta;
import com.honglinktech.zbgj.api.base.BaseController;
import com.honglinktech.zbgj.entity.TSocietyReward;
import com.honglinktech.zbgj.service.TSocietyRewardService;
/**
*社区打赏
**/
@ControllerMeta(name = "社区打赏")
@RestController
@RequestMapping("/tSocietyReward/api/")
public class TSocietyRewardController extends BaseController<TSocietyReward,TSocietyRewardService> {

	private TSocietyRewardService tSocietyRewardService;

	public TSocietyRewardService getTSocietyRewardService() {
		return tSocietyRewardService;
	}
	@Resource
	public void setTSocietyRewardService(TSocietyRewardService tSocietyRewardService) {
		this.tSocietyRewardService = tSocietyRewardService;
	}
	@Override
	protected TSocietyRewardService getService() {
		return tSocietyRewardService;
	}
	
}
