package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserSocMessage8Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserSocMessage8;

/**
*业务
**/
@Component
public class TUserSocMessage8Service extends BaseService<TUserSocMessage8> {

	protected TUserSocMessage8Dao tUserSocMessage8Dao;

	
	public TUserSocMessage8Dao getTUserSocMessage8() {
		return tUserSocMessage8Dao;
	}
	@Resource
	public void setTUserSocMessage8(TUserSocMessage8Dao tUserSocMessage8Dao) {
		this.tUserSocMessage8Dao = tUserSocMessage8Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserSocMessage8Dao getDao() {
		return tUserSocMessage8Dao;
	}
}
