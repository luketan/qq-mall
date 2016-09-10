package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserMessage0Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserMessage0;

/**
*用户聊天记录，用户id分表业务
**/
@Component
public class TUserMessage0Service extends BaseService<TUserMessage0> {

	protected TUserMessage0Dao tUserMessage0Dao;

	
	public TUserMessage0Dao getTUserMessage0() {
		return tUserMessage0Dao;
	}
	@Resource
	public void setTUserMessage0(TUserMessage0Dao tUserMessage0Dao) {
		this.tUserMessage0Dao = tUserMessage0Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserMessage0Dao getDao() {
		return tUserMessage0Dao;
	}
}
