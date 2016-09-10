package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TRegionDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TRegion;

/**
*业务
**/
@Component
public class TRegionService extends BaseService<TRegion> {

	protected TRegionDao tRegionDao;

	
	public TRegionDao getTRegion() {
		return tRegionDao;
	}
	@Resource
	public void setTRegion(TRegionDao tRegionDao) {
		this.tRegionDao = tRegionDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TRegionDao getDao() {
		return tRegionDao;
	}
}
