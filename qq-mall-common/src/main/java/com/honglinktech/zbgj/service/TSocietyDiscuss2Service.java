package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietyDiscuss2Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietyDiscuss2;

/**
*业务
**/
@Component
public class TSocietyDiscuss2Service extends BaseService<TSocietyDiscuss2> {

	protected TSocietyDiscuss2Dao tSocietyDiscuss2Dao;

	
	public TSocietyDiscuss2Dao getTSocietyDiscuss2() {
		return tSocietyDiscuss2Dao;
	}
	@Resource
	public void setTSocietyDiscuss2(TSocietyDiscuss2Dao tSocietyDiscuss2Dao) {
		this.tSocietyDiscuss2Dao = tSocietyDiscuss2Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietyDiscuss2Dao getDao() {
		return tSocietyDiscuss2Dao;
	}
}
