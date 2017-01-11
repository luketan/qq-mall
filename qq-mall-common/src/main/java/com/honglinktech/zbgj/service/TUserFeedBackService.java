package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserFeedBackDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserFeedBack;

/**
*用户反馈和意见业务
**/
@Component
public class TUserFeedBackService extends BaseService<TUserFeedBack> {

	protected TUserFeedBackDao tUserFeedBackDao;

	
	public TUserFeedBackDao getTUserFeedBack() {
		return tUserFeedBackDao;
	}
	@Resource
	public void setTUserFeedBack(TUserFeedBackDao tUserFeedBackDao) {
		this.tUserFeedBackDao = tUserFeedBackDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserFeedBackDao getDao() {
		return tUserFeedBackDao;
	}
}
