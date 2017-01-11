package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TOrderItemFormatDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TOrderItemFormat;

/**
*订单商品的规格业务
**/
@Component
public class TOrderItemFormatService extends BaseService<TOrderItemFormat> {

	protected TOrderItemFormatDao tOrderItemFormatDao;

	
	public TOrderItemFormatDao getTOrderItemFormat() {
		return tOrderItemFormatDao;
	}
	@Resource
	public void setTOrderItemFormat(TOrderItemFormatDao tOrderItemFormatDao) {
		this.tOrderItemFormatDao = tOrderItemFormatDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TOrderItemFormatDao getDao() {
		return tOrderItemFormatDao;
	}
}
