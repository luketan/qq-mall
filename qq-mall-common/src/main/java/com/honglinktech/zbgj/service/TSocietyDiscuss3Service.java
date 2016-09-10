package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietyDiscuss3Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietyDiscuss3;

/**
*业务
**/
@Component
public class TSocietyDiscuss3Service extends BaseService<TSocietyDiscuss3> {

	protected TSocietyDiscuss3Dao tSocietyDiscuss3Dao;

	
	public TSocietyDiscuss3Dao getTSocietyDiscuss3() {
		return tSocietyDiscuss3Dao;
	}
	@Resource
	public void setTSocietyDiscuss3(TSocietyDiscuss3Dao tSocietyDiscuss3Dao) {
		this.tSocietyDiscuss3Dao = tSocietyDiscuss3Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietyDiscuss3Dao getDao() {
		return tSocietyDiscuss3Dao;
	}
}
