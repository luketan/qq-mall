package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietySubjectDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietySubject;

/**
*业务
**/
@Component
public class TSocietySubjectService extends BaseService<TSocietySubject> {

	protected TSocietySubjectDao tSocietySubjectDao;

	
	public TSocietySubjectDao getTSocietySubject() {
		return tSocietySubjectDao;
	}
	@Resource
	public void setTSocietySubject(TSocietySubjectDao tSocietySubjectDao) {
		this.tSocietySubjectDao = tSocietySubjectDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietySubjectDao getDao() {
		return tSocietySubjectDao;
	}
}
