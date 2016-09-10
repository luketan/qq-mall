package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TUserAddressDao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TUserAddress;

/**
*用户地址业务
**/
@Component
public class TUserAddressService extends BaseService<TUserAddress> {

	protected TUserAddressDao tUserAddressDao;

	
	public TUserAddressDao getTUserAddress() {
		return tUserAddressDao;
	}
	@Resource
	public void setTUserAddress(TUserAddressDao tUserAddressDao) {
		this.tUserAddressDao = tUserAddressDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TUserAddressDao getDao() {
		return tUserAddressDao;
	}
}
