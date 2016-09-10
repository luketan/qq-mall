package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TShoppingCartDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TShoppingCart;

/**
*业务
**/
@Component
public class TShoppingCartService extends BaseService<TShoppingCart> {

	protected TShoppingCartDao tShoppingCartDao;

	
	public TShoppingCartDao getTShoppingCart() {
		return tShoppingCartDao;
	}
	@Resource
	public void setTShoppingCart(TShoppingCartDao tShoppingCartDao) {
		this.tShoppingCartDao = tShoppingCartDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TShoppingCartDao getDao() {
		return tShoppingCartDao;
	}
}
