package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TGoodsActivityDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TGoodsActivity;

/**
*商品活动业务
**/
@Component
public class TGoodsActivityService extends BaseService<TGoodsActivity> {

	protected TGoodsActivityDao tGoodsActivityDao;

	
	public TGoodsActivityDao getTGoodsActivity() {
		return tGoodsActivityDao;
	}
	@Resource
	public void setTGoodsActivity(TGoodsActivityDao tGoodsActivityDao) {
		this.tGoodsActivityDao = tGoodsActivityDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TGoodsActivityDao getDao() {
		return tGoodsActivityDao;
	}
}
