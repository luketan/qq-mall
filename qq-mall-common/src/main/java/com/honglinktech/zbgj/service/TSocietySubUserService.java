package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietySubUserDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietySubUser;

/**
*用户关注的主题业务
**/
@Component
public class TSocietySubUserService extends BaseService<TSocietySubUser> {

	protected TSocietySubUserDao tSocietySubUserDao;

	
	public TSocietySubUserDao getTSocietySubUser() {
		return tSocietySubUserDao;
	}
	@Resource
	public void setTSocietySubUser(TSocietySubUserDao tSocietySubUserDao) {
		this.tSocietySubUserDao = tSocietySubUserDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietySubUserDao getDao() {
		return tSocietySubUserDao;
	}
}
