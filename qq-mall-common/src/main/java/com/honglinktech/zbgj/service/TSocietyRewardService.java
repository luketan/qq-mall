package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietyRewardDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietyReward;

/**
*社区打赏业务
**/
@Component
public class TSocietyRewardService extends BaseService<TSocietyReward> {

	protected TSocietyRewardDao tSocietyRewardDao;

	
	public TSocietyRewardDao getTSocietyReward() {
		return tSocietyRewardDao;
	}
	@Resource
	public void setTSocietyReward(TSocietyRewardDao tSocietyRewardDao) {
		this.tSocietyRewardDao = tSocietyRewardDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietyRewardDao getDao() {
		return tSocietyRewardDao;
	}
}
