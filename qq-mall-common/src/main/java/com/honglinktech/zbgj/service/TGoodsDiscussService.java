package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TGoodsDiscussDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TGoodsDiscuss;

/**
*商品评论表业务
**/
@Component
public class TGoodsDiscussService extends BaseService<TGoodsDiscuss> {

	protected TGoodsDiscussDao tGoodsDiscussDao;

	
	public TGoodsDiscussDao getTGoodsDiscuss() {
		return tGoodsDiscussDao;
	}
	@Resource
	public void setTGoodsDiscuss(TGoodsDiscussDao tGoodsDiscussDao) {
		this.tGoodsDiscussDao = tGoodsDiscussDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TGoodsDiscussDao getDao() {
		return tGoodsDiscussDao;
	}
}
