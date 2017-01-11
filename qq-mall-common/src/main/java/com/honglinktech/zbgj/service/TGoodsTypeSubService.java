package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TGoodsTypeSubDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TGoodsTypeSub;

/**
*商品款式业务
**/
@Component
public class TGoodsTypeSubService extends BaseService<TGoodsTypeSub> {

	protected TGoodsTypeSubDao tGoodsTypeSubDao;

	
	public TGoodsTypeSubDao getTGoodsTypeSub() {
		return tGoodsTypeSubDao;
	}
	@Resource
	public void setTGoodsTypeSub(TGoodsTypeSubDao tGoodsTypeSubDao) {
		this.tGoodsTypeSubDao = tGoodsTypeSubDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TGoodsTypeSubDao getDao() {
		return tGoodsTypeSubDao;
	}
}
