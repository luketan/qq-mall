package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserSocMessage1Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserSocMessage1;

/**
*业务
**/
@Component
public class TUserSocMessage1Service extends BaseService<TUserSocMessage1> {

	protected TUserSocMessage1Dao tUserSocMessage1Dao;

	
	public TUserSocMessage1Dao getTUserSocMessage1() {
		return tUserSocMessage1Dao;
	}
	@Resource
	public void setTUserSocMessage1(TUserSocMessage1Dao tUserSocMessage1Dao) {
		this.tUserSocMessage1Dao = tUserSocMessage1Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserSocMessage1Dao getDao() {
		return tUserSocMessage1Dao;
	}
}
