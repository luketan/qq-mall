package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserSocMessage4Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserSocMessage4;

/**
*业务
**/
@Component
public class TUserSocMessage4Service extends BaseService<TUserSocMessage4> {

	protected TUserSocMessage4Dao tUserSocMessage4Dao;

	
	public TUserSocMessage4Dao getTUserSocMessage4() {
		return tUserSocMessage4Dao;
	}
	@Resource
	public void setTUserSocMessage4(TUserSocMessage4Dao tUserSocMessage4Dao) {
		this.tUserSocMessage4Dao = tUserSocMessage4Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserSocMessage4Dao getDao() {
		return tUserSocMessage4Dao;
	}
}
