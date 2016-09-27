package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TPostCompanyDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TPostCompany;

/**
*快递公司表业务
**/
@Component
public class TPostCompanyService extends BaseService<TPostCompany> {

	protected TPostCompanyDao tPostCompanyDao;

	
	public TPostCompanyDao getTPostCompany() {
		return tPostCompanyDao;
	}
	@Resource
	public void setTPostCompany(TPostCompanyDao tPostCompanyDao) {
		this.tPostCompanyDao = tPostCompanyDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TPostCompanyDao getDao() {
		return tPostCompanyDao;
	}
}
