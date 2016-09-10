package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserMessage6Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserMessage6;

/**
*用户聊天记录，用户id分表业务
**/
@Component
public class TUserMessage6Service extends BaseService<TUserMessage6> {

	protected TUserMessage6Dao tUserMessage6Dao;

	
	public TUserMessage6Dao getTUserMessage6() {
		return tUserMessage6Dao;
	}
	@Resource
	public void setTUserMessage6(TUserMessage6Dao tUserMessage6Dao) {
		this.tUserMessage6Dao = tUserMessage6Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserMessage6Dao getDao() {
		return tUserMessage6Dao;
	}
}
