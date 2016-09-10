package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.CAdminSessionLogDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.CAdminSessionLog;

/**
*登录日志表业务
**/
@Component
public class CAdminSessionLogService extends BaseService<CAdminSessionLog> {

	protected CAdminSessionLogDao cAdminSessionLogDao;

	
	public CAdminSessionLogDao getCAdminSessionLog() {
		return cAdminSessionLogDao;
	}
	@Resource
	public void setCAdminSessionLog(CAdminSessionLogDao cAdminSessionLogDao) {
		this.cAdminSessionLogDao = cAdminSessionLogDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CAdminSessionLogDao getDao() {
		return cAdminSessionLogDao;
	}
}
