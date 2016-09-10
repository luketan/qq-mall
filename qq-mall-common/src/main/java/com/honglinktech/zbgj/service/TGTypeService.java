package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TGTypeDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TGType;

/**
*商品类别表业务
**/
@Component
public class TGTypeService extends BaseService<TGType> {

	protected TGTypeDao tGTypeDao;

	
	public TGTypeDao getTGType() {
		return tGTypeDao;
	}
	@Resource
	public void setTGType(TGTypeDao tGTypeDao) {
		this.tGTypeDao = tGTypeDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TGTypeDao getDao() {
		return tGTypeDao;
	}
}
