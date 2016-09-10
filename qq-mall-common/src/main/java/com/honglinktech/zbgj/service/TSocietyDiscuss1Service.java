package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietyDiscuss1Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietyDiscuss1;

/**
*业务
**/
@Component
public class TSocietyDiscuss1Service extends BaseService<TSocietyDiscuss1> {

	protected TSocietyDiscuss1Dao tSocietyDiscuss1Dao;

	
	public TSocietyDiscuss1Dao getTSocietyDiscuss1() {
		return tSocietyDiscuss1Dao;
	}
	@Resource
	public void setTSocietyDiscuss1(TSocietyDiscuss1Dao tSocietyDiscuss1Dao) {
		this.tSocietyDiscuss1Dao = tSocietyDiscuss1Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietyDiscuss1Dao getDao() {
		return tSocietyDiscuss1Dao;
	}
}
