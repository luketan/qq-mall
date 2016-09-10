package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TChangeLogDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TChangeLog;

/**
*变更变更日志[逗比、经验、vip]业务
**/
@Component
public class TChangeLogService extends BaseService<TChangeLog> {

	protected TChangeLogDao tChangeLogDao;

	
	public TChangeLogDao getTChangeLog() {
		return tChangeLogDao;
	}
	@Resource
	public void setTChangeLog(TChangeLogDao tChangeLogDao) {
		this.tChangeLogDao = tChangeLogDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TChangeLogDao getDao() {
		return tChangeLogDao;
	}
}
