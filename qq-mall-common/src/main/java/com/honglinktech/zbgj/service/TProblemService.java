package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TProblemDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TProblem;

/**
*活动业务
**/
@Component
public class TProblemService extends BaseService<TProblem> {

	protected TProblemDao tProblemDao;

	
	public TProblemDao getTProblem() {
		return tProblemDao;
	}
	@Resource
	public void setTProblem(TProblemDao tProblemDao) {
		this.tProblemDao = tProblemDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TProblemDao getDao() {
		return tProblemDao;
	}
}
