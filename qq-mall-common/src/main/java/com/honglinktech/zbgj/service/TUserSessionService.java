package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserSessionDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserSession;

/**
*用户回话信息业务
**/
@Component
public class TUserSessionService extends BaseService<TUserSession> {

	protected TUserSessionDao tUserSessionDao;

	
	public TUserSessionDao getTUserSession() {
		return tUserSessionDao;
	}
	@Resource
	public void setTUserSession(TUserSessionDao tUserSessionDao) {
		this.tUserSessionDao = tUserSessionDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserSessionDao getDao() {
		return tUserSessionDao;
	}
}
