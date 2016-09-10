package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TGoodsDisDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TGoodsDis;

/**
*商品评论表业务
**/
@Component
public class TGoodsDisService extends BaseService<TGoodsDis> {

	protected TGoodsDisDao tGoodsDisDao;

	
	public TGoodsDisDao getTGoodsDis() {
		return tGoodsDisDao;
	}
	@Resource
	public void setTGoodsDis(TGoodsDisDao tGoodsDisDao) {
		this.tGoodsDisDao = tGoodsDisDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TGoodsDisDao getDao() {
		return tGoodsDisDao;
	}
}
