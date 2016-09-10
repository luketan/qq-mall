package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TSocietyDisDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TSocietyDis;

/**
*回帖内容，根据帖子id，分表 注意分表业务
**/
@Component
public class TSocietyDisService extends BaseService<TSocietyDis> {

	protected TSocietyDisDao tSocietyDisDao;

	
	public TSocietyDisDao getTSocietyDis() {
		return tSocietyDisDao;
	}
	@Resource
	public void setTSocietyDis(TSocietyDisDao tSocietyDisDao) {
		this.tSocietyDisDao = tSocietyDisDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TSocietyDisDao getDao() {
		return tSocietyDisDao;
	}
}
