package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TCouponDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TCoupon;

/**
*优惠券业务
**/
@Component
public class TCouponService extends BaseService<TCoupon> {

	protected TCouponDao tCouponDao;

	
	public TCouponDao getTCoupon() {
		return tCouponDao;
	}
	@Resource
	public void setTCoupon(TCouponDao tCouponDao) {
		this.tCouponDao = tCouponDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TCouponDao getDao() {
		return tCouponDao;
	}
}
