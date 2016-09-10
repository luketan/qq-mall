package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserCollectDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserCollect;

/**
*用户的收藏业务
**/
@Component
public class TUserCollectService extends BaseService<TUserCollect> {

	protected TUserCollectDao tUserCollectDao;

	
	public TUserCollectDao getTUserCollect() {
		return tUserCollectDao;
	}
	@Resource
	public void setTUserCollect(TUserCollectDao tUserCollectDao) {
		this.tUserCollectDao = tUserCollectDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserCollectDao getDao() {
		return tUserCollectDao;
	}
}
