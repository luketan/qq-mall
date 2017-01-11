package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TFormatSubDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TFormatSub;

/**
*规格种类业务
**/
@Component
public class TFormatSubService extends BaseService<TFormatSub> {

	protected TFormatSubDao tFormatSubDao;

	
	public TFormatSubDao getTFormatSub() {
		return tFormatSubDao;
	}
	@Resource
	public void setTFormatSub(TFormatSubDao tFormatSubDao) {
		this.tFormatSubDao = tFormatSubDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TFormatSubDao getDao() {
		return tFormatSubDao;
	}
}
