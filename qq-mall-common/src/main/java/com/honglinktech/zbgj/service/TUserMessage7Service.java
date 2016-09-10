package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserMessage7Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserMessage7;

/**
*用户聊天记录，用户id分表业务
**/
@Component
public class TUserMessage7Service extends BaseService<TUserMessage7> {

	protected TUserMessage7Dao tUserMessage7Dao;

	
	public TUserMessage7Dao getTUserMessage7() {
		return tUserMessage7Dao;
	}
	@Resource
	public void setTUserMessage7(TUserMessage7Dao tUserMessage7Dao) {
		this.tUserMessage7Dao = tUserMessage7Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserMessage7Dao getDao() {
		return tUserMessage7Dao;
	}
}
