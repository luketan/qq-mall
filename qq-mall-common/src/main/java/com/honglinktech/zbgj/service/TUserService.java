package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUser;

/**
*业务
**/
@Component
public class TUserService extends BaseService<TUser> {

	protected TUserDao tUserDao;

	
	public TUserDao getTUser() {
		return tUserDao;
	}
	@Resource
	public void setTUser(TUserDao tUserDao) {
		this.tUserDao = tUserDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserDao getDao() {
		return tUserDao;
	}
}
