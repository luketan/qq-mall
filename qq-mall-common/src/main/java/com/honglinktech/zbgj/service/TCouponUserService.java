package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TCouponUserDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TCouponUser;

/**
*业务
**/
@Component
public class TCouponUserService extends BaseService<TCouponUser> {

	protected TCouponUserDao tCouponUserDao;

	
	public TCouponUserDao getTCouponUser() {
		return tCouponUserDao;
	}
	@Resource
	public void setTCouponUser(TCouponUserDao tCouponUserDao) {
		this.tCouponUserDao = tCouponUserDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TCouponUserDao getDao() {
		return tCouponUserDao;
	}
}
