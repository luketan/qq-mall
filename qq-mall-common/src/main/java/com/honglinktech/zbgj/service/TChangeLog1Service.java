package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TChangeLog1Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TChangeLog1;

/**
*变更变更日志[饭卡、饭票、经验、成长点、声望、道具、联盟]业务
**/
@Component
public class TChangeLog1Service extends BaseService<TChangeLog1> {

	protected TChangeLog1Dao tChangeLog1Dao;

	
	public TChangeLog1Dao getTChangeLog1() {
		return tChangeLog1Dao;
	}
	@Resource
	public void setTChangeLog1(TChangeLog1Dao tChangeLog1Dao) {
		this.tChangeLog1Dao = tChangeLog1Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TChangeLog1Dao getDao() {
		return tChangeLog1Dao;
	}
}
