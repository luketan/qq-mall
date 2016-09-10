package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserSocMessage0Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserSocMessage0;

/**
*业务
**/
@Component
public class TUserSocMessage0Service extends BaseService<TUserSocMessage0> {

	protected TUserSocMessage0Dao tUserSocMessage0Dao;

	
	public TUserSocMessage0Dao getTUserSocMessage0() {
		return tUserSocMessage0Dao;
	}
	@Resource
	public void setTUserSocMessage0(TUserSocMessage0Dao tUserSocMessage0Dao) {
		this.tUserSocMessage0Dao = tUserSocMessage0Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserSocMessage0Dao getDao() {
		return tUserSocMessage0Dao;
	}
}
