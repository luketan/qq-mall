package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TGoodsBrandDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TGoodsBrand;

/**
*商品品牌业务
**/
@Component
public class TGoodsBrandService extends BaseService<TGoodsBrand> {

	protected TGoodsBrandDao tGoodsBrandDao;

	
	public TGoodsBrandDao getTGoodsBrand() {
		return tGoodsBrandDao;
	}
	@Resource
	public void setTGoodsBrand(TGoodsBrandDao tGoodsBrandDao) {
		this.tGoodsBrandDao = tGoodsBrandDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TGoodsBrandDao getDao() {
		return tGoodsBrandDao;
	}
}
