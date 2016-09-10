package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserSocMessage3Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserSocMessage3;

/**
*业务
**/
@Component
public class TUserSocMessage3Service extends BaseService<TUserSocMessage3> {

	protected TUserSocMessage3Dao tUserSocMessage3Dao;

	
	public TUserSocMessage3Dao getTUserSocMessage3() {
		return tUserSocMessage3Dao;
	}
	@Resource
	public void setTUserSocMessage3(TUserSocMessage3Dao tUserSocMessage3Dao) {
		this.tUserSocMessage3Dao = tUserSocMessage3Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserSocMessage3Dao getDao() {
		return tUserSocMessage3Dao;
	}
}
