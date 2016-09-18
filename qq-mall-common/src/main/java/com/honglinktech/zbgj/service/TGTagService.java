package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TGTagDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TGTag;

/**
*商品表情业务
**/
@Component
public class TGTagService extends BaseService<TGTag> {

	protected TGTagDao tGTagDao;

	
	public TGTagDao getTGTag() {
		return tGTagDao;
	}
	@Resource
	public void setTGTag(TGTagDao tGTagDao) {
		this.tGTagDao = tGTagDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TGTagDao getDao() {
		return tGTagDao;
	}
}
