package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TOrderItemDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TOrderItem;

/**
*订单详情业务
**/
@Component
public class TOrderItemService extends BaseService<TOrderItem> {

	protected TOrderItemDao tOrderItemDao;

	
	public TOrderItemDao getTOrderItem() {
		return tOrderItemDao;
	}
	@Resource
	public void setTOrderItem(TOrderItemDao tOrderItemDao) {
		this.tOrderItemDao = tOrderItemDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TOrderItemDao getDao() {
		return tOrderItemDao;
	}
}
