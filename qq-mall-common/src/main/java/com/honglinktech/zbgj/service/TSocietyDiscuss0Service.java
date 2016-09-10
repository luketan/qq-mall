package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietyDiscuss0Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietyDiscuss0;

/**
*回帖内容，根据帖子id，分表业务
**/
@Component
public class TSocietyDiscuss0Service extends BaseService<TSocietyDiscuss0> {

	protected TSocietyDiscuss0Dao tSocietyDiscuss0Dao;

	
	public TSocietyDiscuss0Dao getTSocietyDiscuss0() {
		return tSocietyDiscuss0Dao;
	}
	@Resource
	public void setTSocietyDiscuss0(TSocietyDiscuss0Dao tSocietyDiscuss0Dao) {
		this.tSocietyDiscuss0Dao = tSocietyDiscuss0Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietyDiscuss0Dao getDao() {
		return tSocietyDiscuss0Dao;
	}
}
