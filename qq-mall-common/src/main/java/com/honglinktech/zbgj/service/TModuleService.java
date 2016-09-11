package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TModuleDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TModule;

/**
*api端模块管理业务
**/
@Component
public class TModuleService extends BaseService<TModule> {

	protected TModuleDao tModuleDao;

	
	public TModuleDao getTModule() {
		return tModuleDao;
	}
	@Resource
	public void setTModule(TModuleDao tModuleDao) {
		this.tModuleDao = tModuleDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TModuleDao getDao() {
		return tModuleDao;
	}
}
