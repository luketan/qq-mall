package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserRecDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserRec;

/**
*注册用户推荐奖励业务
**/
@Component
public class TUserRecService extends BaseService<TUserRec> {

	protected TUserRecDao tUserRecDao;

	
	public TUserRecDao getTUserRec() {
		return tUserRecDao;
	}
	@Resource
	public void setTUserRec(TUserRecDao tUserRecDao) {
		this.tUserRecDao = tUserRecDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserRecDao getDao() {
		return tUserRecDao;
	}
}
