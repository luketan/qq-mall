package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.CRoleSecurityDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.CRoleSecurity;

/**
*角色权限关联表业务
**/
@Component
public class CRoleSecurityService extends BaseService<CRoleSecurity> {

	protected CRoleSecurityDao cRoleSecurityDao;

	
	public CRoleSecurityDao getCRoleSecurity() {
		return cRoleSecurityDao;
	}
	@Resource
	public void setCRoleSecurity(CRoleSecurityDao cRoleSecurityDao) {
		this.cRoleSecurityDao = cRoleSecurityDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CRoleSecurityDao getDao() {
		return cRoleSecurityDao;
	}
}
