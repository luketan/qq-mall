package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserMessage8Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserMessage8;

/**
*用户聊天记录，用户id分表业务
**/
@Component
public class TUserMessage8Service extends BaseService<TUserMessage8> {

	protected TUserMessage8Dao tUserMessage8Dao;

	
	public TUserMessage8Dao getTUserMessage8() {
		return tUserMessage8Dao;
	}
	@Resource
	public void setTUserMessage8(TUserMessage8Dao tUserMessage8Dao) {
		this.tUserMessage8Dao = tUserMessage8Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserMessage8Dao getDao() {
		return tUserMessage8Dao;
	}
}
