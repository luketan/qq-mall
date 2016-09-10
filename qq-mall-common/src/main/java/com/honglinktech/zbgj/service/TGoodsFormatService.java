package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TGoodsFormatDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TGoodsFormat;

/**
*商品规格业务
**/
@Component
public class TGoodsFormatService extends BaseService<TGoodsFormat> {

	protected TGoodsFormatDao tGoodsFormatDao;

	
	public TGoodsFormatDao getTGoodsFormat() {
		return tGoodsFormatDao;
	}
	@Resource
	public void setTGoodsFormat(TGoodsFormatDao tGoodsFormatDao) {
		this.tGoodsFormatDao = tGoodsFormatDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TGoodsFormatDao getDao() {
		return tGoodsFormatDao;
	}
}
