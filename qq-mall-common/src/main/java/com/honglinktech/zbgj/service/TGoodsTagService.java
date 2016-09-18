package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TGoodsTagDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TGoodsTag;

/**
*商品活动业务
**/
@Component
public class TGoodsTagService extends BaseService<TGoodsTag> {

	protected TGoodsTagDao tGoodsTagDao;

	
	public TGoodsTagDao getTGoodsTag() {
		return tGoodsTagDao;
	}
	@Resource
	public void setTGoodsTag(TGoodsTagDao tGoodsTagDao) {
		this.tGoodsTagDao = tGoodsTagDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TGoodsTagDao getDao() {
		return tGoodsTagDao;
	}
}
