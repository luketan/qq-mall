package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietySubjectUserDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietySubjectUser;

/**
*用户关注的主题业务
**/
@Component
public class TSocietySubjectUserService extends BaseService<TSocietySubjectUser> {

	protected TSocietySubjectUserDao tSocietySubjectUserDao;

	
	public TSocietySubjectUserDao getTSocietySubjectUser() {
		return tSocietySubjectUserDao;
	}
	@Resource
	public void setTSocietySubjectUser(TSocietySubjectUserDao tSocietySubjectUserDao) {
		this.tSocietySubjectUserDao = tSocietySubjectUserDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietySubjectUserDao getDao() {
		return tSocietySubjectUserDao;
	}
}
