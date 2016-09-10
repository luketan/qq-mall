package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.CAdminRoleDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.CAdminRole;

/**
*用户角色关联表业务
**/
@Component
public class CAdminRoleService extends BaseService<CAdminRole> {

	protected CAdminRoleDao cAdminRoleDao;

	
	public CAdminRoleDao getCAdminRole() {
		return cAdminRoleDao;
	}
	@Resource
	public void setCAdminRole(CAdminRoleDao cAdminRoleDao) {
		this.cAdminRoleDao = cAdminRoleDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CAdminRoleDao getDao() {
		return cAdminRoleDao;
	}
}
