package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserMessage5Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserMessage5;

/**
*用户聊天记录，用户id分表业务
**/
@Component
public class TUserMessage5Service extends BaseService<TUserMessage5> {

	protected TUserMessage5Dao tUserMessage5Dao;

	
	public TUserMessage5Dao getTUserMessage5() {
		return tUserMessage5Dao;
	}
	@Resource
	public void setTUserMessage5(TUserMessage5Dao tUserMessage5Dao) {
		this.tUserMessage5Dao = tUserMessage5Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserMessage5Dao getDao() {
		return tUserMessage5Dao;
	}
}
