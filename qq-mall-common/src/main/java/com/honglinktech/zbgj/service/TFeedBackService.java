package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TFeedBackDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TFeedBack;

/**
*用户反馈表业务
**/
@Component
public class TFeedBackService extends BaseService<TFeedBack> {

	protected TFeedBackDao tFeedBackDao;

	
	public TFeedBackDao getTFeedBack() {
		return tFeedBackDao;
	}
	@Resource
	public void setTFeedBack(TFeedBackDao tFeedBackDao) {
		this.tFeedBackDao = tFeedBackDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TFeedBackDao getDao() {
		return tFeedBackDao;
	}
}
