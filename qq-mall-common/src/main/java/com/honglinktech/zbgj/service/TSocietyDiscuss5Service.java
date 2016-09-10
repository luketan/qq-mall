package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietyDiscuss5Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietyDiscuss5;

/**
*业务
**/
@Component
public class TSocietyDiscuss5Service extends BaseService<TSocietyDiscuss5> {

	protected TSocietyDiscuss5Dao tSocietyDiscuss5Dao;

	
	public TSocietyDiscuss5Dao getTSocietyDiscuss5() {
		return tSocietyDiscuss5Dao;
	}
	@Resource
	public void setTSocietyDiscuss5(TSocietyDiscuss5Dao tSocietyDiscuss5Dao) {
		this.tSocietyDiscuss5Dao = tSocietyDiscuss5Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietyDiscuss5Dao getDao() {
		return tSocietyDiscuss5Dao;
	}
}
