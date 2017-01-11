package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TShoppingCartFormatDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TShoppingCartFormat;

/**
*购物车规格中间表业务
**/
@Component
public class TShoppingCartFormatService extends BaseService<TShoppingCartFormat> {

	protected TShoppingCartFormatDao tShoppingCartFormatDao;

	
	public TShoppingCartFormatDao getTShoppingCartFormat() {
		return tShoppingCartFormatDao;
	}
	@Resource
	public void setTShoppingCartFormat(TShoppingCartFormatDao tShoppingCartFormatDao) {
		this.tShoppingCartFormatDao = tShoppingCartFormatDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TShoppingCartFormatDao getDao() {
		return tShoppingCartFormatDao;
	}
}
