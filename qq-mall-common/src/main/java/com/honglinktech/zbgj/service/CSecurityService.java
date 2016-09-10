package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.CSecurityDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.CSecurity;

/**
*系统权限表业务
**/
@Component
public class CSecurityService extends BaseService<CSecurity> {

	protected CSecurityDao cSecurityDao;

	
	public CSecurityDao getCSecurity() {
		return cSecurityDao;
	}
	@Resource
	public void setCSecurity(CSecurityDao cSecurityDao) {
		this.cSecurityDao = cSecurityDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CSecurityDao getDao() {
		return cSecurityDao;
	}
}
