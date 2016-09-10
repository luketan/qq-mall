package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TGStyleDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TGStyle;

/**
*商品款式业务
**/
@Component
public class TGStyleService extends BaseService<TGStyle> {

	protected TGStyleDao tGStyleDao;

	
	public TGStyleDao getTGStyle() {
		return tGStyleDao;
	}
	@Resource
	public void setTGStyle(TGStyleDao tGStyleDao) {
		this.tGStyleDao = tGStyleDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TGStyleDao getDao() {
		return tGStyleDao;
	}
}
