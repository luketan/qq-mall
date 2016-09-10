package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TGActivityDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TGActivity;

/**
*活动业务
**/
@Component
public class TGActivityService extends BaseService<TGActivity> {

	protected TGActivityDao tGActivityDao;

	
	public TGActivityDao getTGActivity() {
		return tGActivityDao;
	}
	@Resource
	public void setTGActivity(TGActivityDao tGActivityDao) {
		this.tGActivityDao = tGActivityDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TGActivityDao getDao() {
		return tGActivityDao;
	}
}
