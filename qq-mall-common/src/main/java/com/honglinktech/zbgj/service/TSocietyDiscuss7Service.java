package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietyDiscuss7Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietyDiscuss7;

/**
*业务
**/
@Component
public class TSocietyDiscuss7Service extends BaseService<TSocietyDiscuss7> {

	protected TSocietyDiscuss7Dao tSocietyDiscuss7Dao;

	
	public TSocietyDiscuss7Dao getTSocietyDiscuss7() {
		return tSocietyDiscuss7Dao;
	}
	@Resource
	public void setTSocietyDiscuss7(TSocietyDiscuss7Dao tSocietyDiscuss7Dao) {
		this.tSocietyDiscuss7Dao = tSocietyDiscuss7Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietyDiscuss7Dao getDao() {
		return tSocietyDiscuss7Dao;
	}
}
