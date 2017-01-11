package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TPaymentDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TPayment;

/**
*业务
**/
@Component
public class TPaymentService extends BaseService<TPayment> {

	protected TPaymentDao tPaymentDao;

	
	public TPaymentDao getTPayment() {
		return tPaymentDao;
	}
	@Resource
	public void setTPayment(TPaymentDao tPaymentDao) {
		this.tPaymentDao = tPaymentDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TPaymentDao getDao() {
		return tPaymentDao;
	}
}
