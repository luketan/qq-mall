package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TChangeLog0Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TChangeLog0;

/**
*变更变更日志[饭卡、饭票、经验、成长点、声望、道具、联盟]业务
**/
@Component
public class TChangeLog0Service extends BaseService<TChangeLog0> {

	protected TChangeLog0Dao tChangeLog0Dao;

	
	public TChangeLog0Dao getTChangeLog0() {
		return tChangeLog0Dao;
	}
	@Resource
	public void setTChangeLog0(TChangeLog0Dao tChangeLog0Dao) {
		this.tChangeLog0Dao = tChangeLog0Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TChangeLog0Dao getDao() {
		return tChangeLog0Dao;
	}
}
