package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietyDiscuss9Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietyDiscuss9;

/**
*业务
**/
@Component
public class TSocietyDiscuss9Service extends BaseService<TSocietyDiscuss9> {

	protected TSocietyDiscuss9Dao tSocietyDiscuss9Dao;

	
	public TSocietyDiscuss9Dao getTSocietyDiscuss9() {
		return tSocietyDiscuss9Dao;
	}
	@Resource
	public void setTSocietyDiscuss9(TSocietyDiscuss9Dao tSocietyDiscuss9Dao) {
		this.tSocietyDiscuss9Dao = tSocietyDiscuss9Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietyDiscuss9Dao getDao() {
		return tSocietyDiscuss9Dao;
	}
}
