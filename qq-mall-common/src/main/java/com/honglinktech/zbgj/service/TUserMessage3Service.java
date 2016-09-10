package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserMessage3Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserMessage3;

/**
*用户聊天记录，用户id分表业务
**/
@Component
public class TUserMessage3Service extends BaseService<TUserMessage3> {

	protected TUserMessage3Dao tUserMessage3Dao;

	
	public TUserMessage3Dao getTUserMessage3() {
		return tUserMessage3Dao;
	}
	@Resource
	public void setTUserMessage3(TUserMessage3Dao tUserMessage3Dao) {
		this.tUserMessage3Dao = tUserMessage3Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserMessage3Dao getDao() {
		return tUserMessage3Dao;
	}
}
