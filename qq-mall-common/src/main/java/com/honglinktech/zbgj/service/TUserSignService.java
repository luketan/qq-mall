package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserSignDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserSign;

/**
*用户的个性签名记录业务
**/
@Component
public class TUserSignService extends BaseService<TUserSign> {

	protected TUserSignDao tUserSignDao;

	
	public TUserSignDao getTUserSign() {
		return tUserSignDao;
	}
	@Resource
	public void setTUserSign(TUserSignDao tUserSignDao) {
		this.tUserSignDao = tUserSignDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserSignDao getDao() {
		return tUserSignDao;
	}
}
