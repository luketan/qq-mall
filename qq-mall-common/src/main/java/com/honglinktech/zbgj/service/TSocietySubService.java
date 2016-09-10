package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietySubDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietySub;

/**
*业务
**/
@Component
public class TSocietySubService extends BaseService<TSocietySub> {

	protected TSocietySubDao tSocietySubDao;

	
	public TSocietySubDao getTSocietySub() {
		return tSocietySubDao;
	}
	@Resource
	public void setTSocietySub(TSocietySubDao tSocietySubDao) {
		this.tSocietySubDao = tSocietySubDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietySubDao getDao() {
		return tSocietySubDao;
	}
}
