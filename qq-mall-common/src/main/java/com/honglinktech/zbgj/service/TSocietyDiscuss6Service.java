package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietyDiscuss6Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietyDiscuss6;

/**
*业务
**/
@Component
public class TSocietyDiscuss6Service extends BaseService<TSocietyDiscuss6> {

	protected TSocietyDiscuss6Dao tSocietyDiscuss6Dao;

	
	public TSocietyDiscuss6Dao getTSocietyDiscuss6() {
		return tSocietyDiscuss6Dao;
	}
	@Resource
	public void setTSocietyDiscuss6(TSocietyDiscuss6Dao tSocietyDiscuss6Dao) {
		this.tSocietyDiscuss6Dao = tSocietyDiscuss6Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietyDiscuss6Dao getDao() {
		return tSocietyDiscuss6Dao;
	}
}
