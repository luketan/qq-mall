package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserSocMessage7Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserSocMessage7;

/**
*业务
**/
@Component
public class TUserSocMessage7Service extends BaseService<TUserSocMessage7> {

	protected TUserSocMessage7Dao tUserSocMessage7Dao;

	
	public TUserSocMessage7Dao getTUserSocMessage7() {
		return tUserSocMessage7Dao;
	}
	@Resource
	public void setTUserSocMessage7(TUserSocMessage7Dao tUserSocMessage7Dao) {
		this.tUserSocMessage7Dao = tUserSocMessage7Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserSocMessage7Dao getDao() {
		return tUserSocMessage7Dao;
	}
}
