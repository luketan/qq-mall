package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TGFormatDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TGFormat;

/**
*商品规格业务
**/
@Component
public class TGFormatService extends BaseService<TGFormat> {

	protected TGFormatDao tGFormatDao;

	
	public TGFormatDao getTGFormat() {
		return tGFormatDao;
	}
	@Resource
	public void setTGFormat(TGFormatDao tGFormatDao) {
		this.tGFormatDao = tGFormatDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TGFormatDao getDao() {
		return tGFormatDao;
	}
}
