package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserMessage1Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserMessage1;

/**
*用户聊天记录，用户id分表业务
**/
@Component
public class TUserMessage1Service extends BaseService<TUserMessage1> {

	protected TUserMessage1Dao tUserMessage1Dao;

	
	public TUserMessage1Dao getTUserMessage1() {
		return tUserMessage1Dao;
	}
	@Resource
	public void setTUserMessage1(TUserMessage1Dao tUserMessage1Dao) {
		this.tUserMessage1Dao = tUserMessage1Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserMessage1Dao getDao() {
		return tUserMessage1Dao;
	}
}
