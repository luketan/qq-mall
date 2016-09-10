package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TGoodsDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TGoods;

/**
*业务
**/
@Component
public class TGoodsService extends BaseService<TGoods> {

	protected TGoodsDao tGoodsDao;

	
	public TGoodsDao getTGoods() {
		return tGoodsDao;
	}
	@Resource
	public void setTGoods(TGoodsDao tGoodsDao) {
		this.tGoodsDao = tGoodsDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TGoodsDao getDao() {
		return tGoodsDao;
	}
}
