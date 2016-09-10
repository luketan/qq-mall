package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserAtteDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserAtte;

/**
*用户关注业务
**/
@Component
public class TUserAtteService extends BaseService<TUserAtte> {

	protected TUserAtteDao tUserAtteDao;

	
	public TUserAtteDao getTUserAtte() {
		return tUserAtteDao;
	}
	@Resource
	public void setTUserAtte(TUserAtteDao tUserAtteDao) {
		this.tUserAtteDao = tUserAtteDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserAtteDao getDao() {
		return tUserAtteDao;
	}
}
