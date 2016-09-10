package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserMessage9Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserMessage9;

/**
*用户聊天记录，用户id分表业务
**/
@Component
public class TUserMessage9Service extends BaseService<TUserMessage9> {

	protected TUserMessage9Dao tUserMessage9Dao;

	
	public TUserMessage9Dao getTUserMessage9() {
		return tUserMessage9Dao;
	}
	@Resource
	public void setTUserMessage9(TUserMessage9Dao tUserMessage9Dao) {
		this.tUserMessage9Dao = tUserMessage9Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserMessage9Dao getDao() {
		return tUserMessage9Dao;
	}
}
