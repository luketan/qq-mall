package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserMessage4Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserMessage4;

/**
*用户聊天记录，用户id分表业务
**/
@Component
public class TUserMessage4Service extends BaseService<TUserMessage4> {

	protected TUserMessage4Dao tUserMessage4Dao;

	
	public TUserMessage4Dao getTUserMessage4() {
		return tUserMessage4Dao;
	}
	@Resource
	public void setTUserMessage4(TUserMessage4Dao tUserMessage4Dao) {
		this.tUserMessage4Dao = tUserMessage4Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserMessage4Dao getDao() {
		return tUserMessage4Dao;
	}
}
