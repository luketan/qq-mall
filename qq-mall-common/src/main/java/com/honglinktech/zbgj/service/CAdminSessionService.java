package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.CAdminSessionDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.CAdminSession;

/**
*管理员回话信息业务
**/
@Component
public class CAdminSessionService extends BaseService<CAdminSession> {

	protected CAdminSessionDao cAdminSessionDao;

	
	public CAdminSessionDao getCAdminSession() {
		return cAdminSessionDao;
	}
	@Resource
	public void setCAdminSession(CAdminSessionDao cAdminSessionDao) {
		this.cAdminSessionDao = cAdminSessionDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CAdminSessionDao getDao() {
		return cAdminSessionDao;
	}
}
