package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSystemConfigDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSystemConfig;

/**
*系统消息业务
**/
@Component
public class TSystemConfigService extends BaseService<TSystemConfig> {

	protected TSystemConfigDao tSystemConfigDao;

	
	public TSystemConfigDao getTSystemConfig() {
		return tSystemConfigDao;
	}
	@Resource
	public void setTSystemConfig(TSystemConfigDao tSystemConfigDao) {
		this.tSystemConfigDao = tSystemConfigDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSystemConfigDao getDao() {
		return tSystemConfigDao;
	}
}
