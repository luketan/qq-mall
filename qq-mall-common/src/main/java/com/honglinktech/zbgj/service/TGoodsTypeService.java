package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TGoodsTypeDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TGoodsType;

/**
*商品类别表业务
**/
@Component
public class TGoodsTypeService extends BaseService<TGoodsType> {

	protected TGoodsTypeDao tGoodsTypeDao;

	
	public TGoodsTypeDao getTGoodsType() {
		return tGoodsTypeDao;
	}
	@Resource
	public void setTGoodsType(TGoodsTypeDao tGoodsTypeDao) {
		this.tGoodsTypeDao = tGoodsTypeDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TGoodsTypeDao getDao() {
		return tGoodsTypeDao;
	}
}
