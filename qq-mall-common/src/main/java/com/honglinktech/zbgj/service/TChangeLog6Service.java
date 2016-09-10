package com.honglinktech.zbgj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.honglinktech.zbgj.dao.TChangeLog6Dao;
import com.honglinktech.zbgj.base.BaseService;
import com.honglinktech.zbgj.entity.TChangeLog6;

/**
*变更变更日志[饭卡、饭票、经验、成长点、声望、道具、联盟]业务
**/
@Component
public class TChangeLog6Service extends BaseService<TChangeLog6> {

	protected TChangeLog6Dao tChangeLog6Dao;

	
	public TChangeLog6Dao getTChangeLog6() {
		return tChangeLog6Dao;
	}
	@Resource
	public void setTChangeLog6(TChangeLog6Dao tChangeLog6Dao) {
		this.tChangeLog6Dao = tChangeLog6Dao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TChangeLog6Dao getDao() {
		return tChangeLog6Dao;
	}
}
