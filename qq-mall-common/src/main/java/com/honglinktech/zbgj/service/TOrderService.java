package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TOrderDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TOrder;

/**
*订单信息业务
**/
@Component
public class TOrderService extends BaseService<TOrder> {

	protected TOrderDao tOrderDao;

	
	public TOrderDao getTOrder() {
		return tOrderDao;
	}
	@Resource
	public void setTOrder(TOrderDao tOrderDao) {
		this.tOrderDao = tOrderDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TOrderDao getDao() {
		return tOrderDao;
	}
}
