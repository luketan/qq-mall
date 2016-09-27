package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TPostDetailDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TPostDetail;

/**
*快递单详情表业务
**/
@Component
public class TPostDetailService extends BaseService<TPostDetail> {

	protected TPostDetailDao tPostDetailDao;

	
	public TPostDetailDao getTPostDetail() {
		return tPostDetailDao;
	}
	@Resource
	public void setTPostDetail(TPostDetailDao tPostDetailDao) {
		this.tPostDetailDao = tPostDetailDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TPostDetailDao getDao() {
		return tPostDetailDao;
	}
}
