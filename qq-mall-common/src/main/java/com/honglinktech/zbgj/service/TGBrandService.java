package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TGBrandDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TGBrand;

/**
*商品品牌业务
**/
@Component
public class TGBrandService extends BaseService<TGBrand> {

	protected TGBrandDao tGBrandDao;

	
	public TGBrandDao getTGBrand() {
		return tGBrandDao;
	}
	@Resource
	public void setTGBrand(TGBrandDao tGBrandDao) {
		this.tGBrandDao = tGBrandDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TGBrandDao getDao() {
		return tGBrandDao;
	}
}
