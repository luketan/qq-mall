package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserSocMessage9Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserSocMessage9;

/**
*业务
**/
@Component
public class TUserSocMessage9Service extends BaseService<TUserSocMessage9> {

	protected TUserSocMessage9Dao tUserSocMessage9Dao;

	
	public TUserSocMessage9Dao getTUserSocMessage9() {
		return tUserSocMessage9Dao;
	}
	@Resource
	public void setTUserSocMessage9(TUserSocMessage9Dao tUserSocMessage9Dao) {
		this.tUserSocMessage9Dao = tUserSocMessage9Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserSocMessage9Dao getDao() {
		return tUserSocMessage9Dao;
	}
}
