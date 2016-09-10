package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietyTypeDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietyType;

/**
*社区类型业务
**/
@Component
public class TSocietyTypeService extends BaseService<TSocietyType> {

	protected TSocietyTypeDao tSocietyTypeDao;

	
	public TSocietyTypeDao getTSocietyType() {
		return tSocietyTypeDao;
	}
	@Resource
	public void setTSocietyType(TSocietyTypeDao tSocietyTypeDao) {
		this.tSocietyTypeDao = tSocietyTypeDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietyTypeDao getDao() {
		return tSocietyTypeDao;
	}
}
