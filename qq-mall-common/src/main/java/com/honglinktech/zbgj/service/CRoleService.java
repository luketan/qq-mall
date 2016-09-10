package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.CRoleDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.CRole;

/**
*系统角色表业务
**/
@Component
public class CRoleService extends BaseService<CRole> {

	protected CRoleDao cRoleDao;

	
	public CRoleDao getCRole() {
		return cRoleDao;
	}
	@Resource
	public void setCRole(CRoleDao cRoleDao) {
		this.cRoleDao = cRoleDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CRoleDao getDao() {
		return cRoleDao;
	}
}
