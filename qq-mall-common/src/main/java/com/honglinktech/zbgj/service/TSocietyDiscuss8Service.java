package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietyDiscuss8Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietyDiscuss8;

/**
*业务
**/
@Component
public class TSocietyDiscuss8Service extends BaseService<TSocietyDiscuss8> {

	protected TSocietyDiscuss8Dao tSocietyDiscuss8Dao;

	
	public TSocietyDiscuss8Dao getTSocietyDiscuss8() {
		return tSocietyDiscuss8Dao;
	}
	@Resource
	public void setTSocietyDiscuss8(TSocietyDiscuss8Dao tSocietyDiscuss8Dao) {
		this.tSocietyDiscuss8Dao = tSocietyDiscuss8Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietyDiscuss8Dao getDao() {
		return tSocietyDiscuss8Dao;
	}
}
