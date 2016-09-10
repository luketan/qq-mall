package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserMessage2Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserMessage2;

/**
*用户聊天记录，用户id分表业务
**/
@Component
public class TUserMessage2Service extends BaseService<TUserMessage2> {

	protected TUserMessage2Dao tUserMessage2Dao;

	
	public TUserMessage2Dao getTUserMessage2() {
		return tUserMessage2Dao;
	}
	@Resource
	public void setTUserMessage2(TUserMessage2Dao tUserMessage2Dao) {
		this.tUserMessage2Dao = tUserMessage2Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserMessage2Dao getDao() {
		return tUserMessage2Dao;
	}
}
