package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserKeepDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserKeep;

/**
*用户的收藏业务
**/
@Component
public class TUserKeepService extends BaseService<TUserKeep> {

	protected TUserKeepDao tUserKeepDao;

	
	public TUserKeepDao getTUserKeep() {
		return tUserKeepDao;
	}
	@Resource
	public void setTUserKeep(TUserKeepDao tUserKeepDao) {
		this.tUserKeepDao = tUserKeepDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserKeepDao getDao() {
		return tUserKeepDao;
	}
}
