package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSenWordsDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSenWords;

/**
*业务
**/
@Component
public class TSenWordsService extends BaseService<TSenWords> {

	protected TSenWordsDao tSenWordsDao;

	
	public TSenWordsDao getTSenWords() {
		return tSenWordsDao;
	}
	@Resource
	public void setTSenWords(TSenWordsDao tSenWordsDao) {
		this.tSenWordsDao = tSenWordsDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSenWordsDao getDao() {
		return tSenWordsDao;
	}
}
