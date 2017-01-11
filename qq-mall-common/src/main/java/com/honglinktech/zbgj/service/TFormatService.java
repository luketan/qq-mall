package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TFormatDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TFormat;

/**
*产品款式业务
**/
@Component
public class TFormatService extends BaseService<TFormat> {

	protected TFormatDao tFormatDao;

	
	public TFormatDao getTFormat() {
		return tFormatDao;
	}
	@Resource
	public void setTFormat(TFormatDao tFormatDao) {
		this.tFormatDao = tFormatDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TFormatDao getDao() {
		return tFormatDao;
	}
}
