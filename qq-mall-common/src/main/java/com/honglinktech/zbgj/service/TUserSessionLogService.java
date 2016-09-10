package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserSessionLogDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserSessionLog;

/**
*登录日志表业务
**/
@Component
public class TUserSessionLogService extends BaseService<TUserSessionLog> {

	protected TUserSessionLogDao tUserSessionLogDao;

	
	public TUserSessionLogDao getTUserSessionLog() {
		return tUserSessionLogDao;
	}
	@Resource
	public void setTUserSessionLog(TUserSessionLogDao tUserSessionLogDao) {
		this.tUserSessionLogDao = tUserSessionLogDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserSessionLogDao getDao() {
		return tUserSessionLogDao;
	}
}
