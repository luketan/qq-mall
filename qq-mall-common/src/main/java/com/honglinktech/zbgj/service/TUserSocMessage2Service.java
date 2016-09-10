package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserSocMessage2Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserSocMessage2;

/**
*业务
**/
@Component
public class TUserSocMessage2Service extends BaseService<TUserSocMessage2> {

	protected TUserSocMessage2Dao tUserSocMessage2Dao;

	
	public TUserSocMessage2Dao getTUserSocMessage2() {
		return tUserSocMessage2Dao;
	}
	@Resource
	public void setTUserSocMessage2(TUserSocMessage2Dao tUserSocMessage2Dao) {
		this.tUserSocMessage2Dao = tUserSocMessage2Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserSocMessage2Dao getDao() {
		return tUserSocMessage2Dao;
	}
}
