package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietyDiscuss4Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietyDiscuss4;

/**
*业务
**/
@Component
public class TSocietyDiscuss4Service extends BaseService<TSocietyDiscuss4> {

	protected TSocietyDiscuss4Dao tSocietyDiscuss4Dao;

	
	public TSocietyDiscuss4Dao getTSocietyDiscuss4() {
		return tSocietyDiscuss4Dao;
	}
	@Resource
	public void setTSocietyDiscuss4(TSocietyDiscuss4Dao tSocietyDiscuss4Dao) {
		this.tSocietyDiscuss4Dao = tSocietyDiscuss4Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietyDiscuss4Dao getDao() {
		return tSocietyDiscuss4Dao;
	}
}
