package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserSocMessage6Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserSocMessage6;

/**
*业务
**/
@Component
public class TUserSocMessage6Service extends BaseService<TUserSocMessage6> {

	protected TUserSocMessage6Dao tUserSocMessage6Dao;

	
	public TUserSocMessage6Dao getTUserSocMessage6() {
		return tUserSocMessage6Dao;
	}
	@Resource
	public void setTUserSocMessage6(TUserSocMessage6Dao tUserSocMessage6Dao) {
		this.tUserSocMessage6Dao = tUserSocMessage6Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserSocMessage6Dao getDao() {
		return tUserSocMessage6Dao;
	}
}
