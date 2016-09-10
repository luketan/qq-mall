package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.CAdminDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.CAdmin;

/**
*管理员表业务
**/
@Component
public class CAdminService extends BaseService<CAdmin> {

	protected CAdminDao cAdminDao;

	
	public CAdminDao getCAdmin() {
		return cAdminDao;
	}
	@Resource
	public void setCAdmin(CAdminDao cAdminDao) {
		this.cAdminDao = cAdminDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CAdminDao getDao() {
		return cAdminDao;
	}
}
