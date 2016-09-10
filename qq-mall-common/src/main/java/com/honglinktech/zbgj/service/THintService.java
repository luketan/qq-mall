package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.THintDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.THint;

/**
*提示语业务
**/
@Component
public class THintService extends BaseService<THint> {

	protected THintDao tHintDao;

	
	public THintDao getTHint() {
		return tHintDao;
	}
	@Resource
	public void setTHint(THintDao tHintDao) {
		this.tHintDao = tHintDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public THintDao getDao() {
		return tHintDao;
	}
}
