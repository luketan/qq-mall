package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserSocMessage5Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserSocMessage5;

/**
*业务
**/
@Component
public class TUserSocMessage5Service extends BaseService<TUserSocMessage5> {

	protected TUserSocMessage5Dao tUserSocMessage5Dao;

	
	public TUserSocMessage5Dao getTUserSocMessage5() {
		return tUserSocMessage5Dao;
	}
	@Resource
	public void setTUserSocMessage5(TUserSocMessage5Dao tUserSocMessage5Dao) {
		this.tUserSocMessage5Dao = tUserSocMessage5Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserSocMessage5Dao getDao() {
		return tUserSocMessage5Dao;
	}
}
